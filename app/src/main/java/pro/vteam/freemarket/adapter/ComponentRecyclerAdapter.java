package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.util.ArrayList;

import pro.vteam.freemarket.Constant;
import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.AppListModel;
import pro.vteam.freemarket.models.AppModel;
import pro.vteam.freemarket.models.BannerListModel;
import pro.vteam.freemarket.models.BannerModel;
import pro.vteam.freemarket.models.BigPromotionBannerModel;
import pro.vteam.freemarket.models.HomeBanner;
import pro.vteam.freemarket.models.HomeBigPromotionBanner;
import pro.vteam.freemarket.models.HomeComponent;
import pro.vteam.freemarket.models.HomeItem;
import pro.vteam.freemarket.models.HomeOneRowBanners;
import pro.vteam.freemarket.models.HomeOneRowItems;


public class ComponentRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<HomeComponent> list;


    public ComponentRecyclerAdapter(Context context, ArrayList<HomeComponent> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        switch (viewType) {
            case Constant.BIG_PROMOTION_BANNER: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_big_promotion_banner, parent, false);
                return new BigPromotionBannerViewHolder(view);

            }
            case Constant.ONE_ROW_ITEMS: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_one_row_items, parent, false);
                return new OneRowItemsViewHolder(view);
            }

            case Constant.ONE_ROW_BANNERS: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_one_row_banners, parent, false);
                return new OneRowBannersViewHolder(view);
            }
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        Gson gson = new Gson();
        switch (viewType) {

            case Constant.BIG_PROMOTION_BANNER:
                String jsonPromotionObject = gson.toJson(list.get(position).getObject());
                HomeBigPromotionBanner bigPromotionBanner = gson.fromJson(jsonPromotionObject, HomeBigPromotionBanner.class);
                ((BigPromotionBannerViewHolder) holder).setData(bigPromotionBanner);
                break;

            case Constant.ONE_ROW_BANNERS:
                String jsonBannerObject = gson.toJson(list.get(position).getObject());
                HomeOneRowBanners oneRowBanners = gson.fromJson(jsonBannerObject, HomeOneRowBanners.class);
                ((OneRowBannersViewHolder) holder).setData(oneRowBanners);
                break;

            case Constant.ONE_ROW_ITEMS:
                String jsonItemObject = gson.toJson(list.get(position).getObject());
                HomeOneRowItems oneRowItems = gson.fromJson(jsonItemObject, HomeOneRowItems.class);
                ((OneRowItemsViewHolder) holder).setData(oneRowItems);
                break;

        }
    }


    @Override
    public int getItemViewType(int position) {
        String type = list.get(position).getType();
        switch (type) {

            case "OneRowBanners":
                return Constant.ONE_ROW_BANNERS;

            case "OneRowItems":
                return Constant.ONE_ROW_ITEMS;

            case "BigPromotionBanner":
                return Constant.BIG_PROMOTION_BANNER;
            default:
                return 0;
        }

    }


    @Override

    public int getItemCount() {
        return list.size();
    }


    public class BigPromotionBannerViewHolder extends RecyclerView.ViewHolder {

        ImageView img_promotion_banner;
        ImageView img_promotion_icon;
        TextView txt_promotion_name;
        Button btn_install;

        BigPromotionBannerViewHolder(@NonNull View itemView) {
            super(itemView);

            img_promotion_banner = itemView.findViewById(R.id.img_promotion_banner);
            img_promotion_icon = itemView.findViewById(R.id.img_promotion_icon);
            txt_promotion_name = itemView.findViewById(R.id.txt_promotion_name);
            btn_install = itemView.findViewById(R.id.btn_install);

        }


        void setData(HomeBigPromotionBanner bigPromotionBanner) {
            Glide.with(context)
                    .load(bigPromotionBanner.getHomeImage().getPath())
                    .into(img_promotion_banner);

            Glide.with(context)
                    .load(bigPromotionBanner.getHomeItem().getHomeIcon().getPath())
                    .into(img_promotion_icon);
            txt_promotion_name.setText(bigPromotionBanner.getHomeItem().getTitle());

        }
    }


    public class OneRowBannersViewHolder extends RecyclerView.ViewHolder {

        TextView bannerTitle;
        RecyclerView bannerRecycler;


        OneRowBannersViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerTitle = itemView.findViewById(R.id.txt_banner_title);
            bannerRecycler = itemView.findViewById(R.id.banner_recycler);

        }


        void setData(HomeOneRowBanners oneRowBanners) {

            bannerTitle.setText(oneRowBanners.getTitle());
            ArrayList<HomeBanner> bannerList = oneRowBanners.getBanners();
            BannerAdapter bannerAdapter = new BannerAdapter(context, bannerList);
            bannerRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            bannerRecycler.setAdapter(bannerAdapter);
        }


    }


    public class OneRowItemsViewHolder extends RecyclerView.ViewHolder {

        TextView appsTitle;
        RecyclerView appRecycler;

        OneRowItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            appsTitle = itemView.findViewById(R.id.txt_app_title);
            appRecycler = itemView.findViewById(R.id.app_recycler);
        }

        void setData(HomeOneRowItems oneRowItems) {
            appsTitle.setText(oneRowItems.getTitle());
            ArrayList<HomeItem> items = oneRowItems.getItems();
            ItemAdapter itemAdapter = new ItemAdapter(context, items);
            appRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            appRecycler.setAdapter(itemAdapter);
        }

    }

}


