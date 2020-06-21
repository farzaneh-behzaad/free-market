package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import java.util.ArrayList;

import pro.vteam.freemarket.Constant;
import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.HomeBanner;
import pro.vteam.freemarket.models.HomeBigPromotionBanner;
import pro.vteam.freemarket.models.HomeComponent;
import pro.vteam.freemarket.models.HomeInlineAction;
import pro.vteam.freemarket.models.HomeItem;
import pro.vteam.freemarket.models.HomeOneRowBanners;
import pro.vteam.freemarket.models.HomeOneRowItems;
import pro.vteam.freemarket.utils.CustomItemDecoration;


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
                View view = LayoutInflater.from(context).inflate(R.layout.model_unsuported_component, parent, false);
                return new UnSupportedComponentViewHolder(view);
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

            default:
                ((UnSupportedComponentViewHolder) holder).txt_description.setText("این کامپوننت ساپورت نمی شود لطفا اپلیکیشن را آپدیت کنید.");


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
                return Constant.UN_SUPPORTED_COMPONENT;
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
        TextView txt_bigPromotionTag;
        Button btn_install;
        LinearLayoutCompat bigPromotionTagLayout;


        BigPromotionBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_bigPromotionTag = itemView.findViewById(R.id.txt_bigPromotionTag);
            img_promotion_banner = itemView.findViewById(R.id.img_bigPromotionBanner);
            img_promotion_icon = itemView.findViewById(R.id.img_bigPromotionIcon);
            txt_promotion_name = itemView.findViewById(R.id.txt_promotion_name);
            btn_install = itemView.findViewById(R.id.btn_inlineAction);
            bigPromotionTagLayout = itemView.findViewById(R.id.tag_linearLayout);


        }


        void setData(HomeBigPromotionBanner bigPromotionBanner) {


            if (bigPromotionBanner.getHomeTag().equals("") || bigPromotionBanner.getHomeTag() == null) {
                txt_bigPromotionTag.setVisibility(View.GONE);
            } else {
                txt_bigPromotionTag.setText(bigPromotionBanner.getHomeTag().getTitle());
                bigPromotionTagLayout.setBackgroundColor(Color.parseColor(bigPromotionBanner.getHomeTag().getBackgroundColor()));
            }


            ((ConstraintLayout.LayoutParams) img_promotion_banner.getLayoutParams()).dimensionRatio
                    = bigPromotionBanner.getHomeImage().getRatio().getConstraintDimensionRatio();
            if (bigPromotionBanner.getHomeImage().getPath() != null) {
                Glide.with(context)
                        .load(bigPromotionBanner.getHomeImage().getPath())
                        .centerCrop()
                        .into(img_promotion_banner);
            }


            ((ConstraintLayout.LayoutParams) img_promotion_icon.getLayoutParams()).dimensionRatio
                    = bigPromotionBanner.getHomeItem().getHomeIcon().getRatio().getConstraintDimensionRatio();


            int roundRadius = (int) context.getResources().getDimension(R.dimen.big_promotion_banner_icon_corner_radius);
            RequestOptions requestOptions = new RequestOptions().transform(new CenterCrop(), new RoundedCorners(roundRadius));


            Glide.with(context)
                    .load(bigPromotionBanner.getHomeItem().getHomeIcon().getPath())
                    .apply(requestOptions)
                    .into(img_promotion_icon);

            txt_promotion_name.setText(bigPromotionBanner.getHomeItem().getTitle());

        }
    }


    public class OneRowBannersViewHolder extends RecyclerView.ViewHolder {

        TextView bannerTitle;
        RecyclerView bannerRecycler;
        CustomItemDecoration customItemDecoration;


        OneRowBannersViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerTitle = itemView.findViewById(R.id.txt_banner_title);
            bannerRecycler = itemView.findViewById(R.id.banner_recycler);
            if (customItemDecoration == null)
                setCustomItemDecoration(new CustomItemDecoration(context.getResources().getDimension(R.dimen.recycler_horizontal_margin)));

        }


        void setData(HomeOneRowBanners oneRowBanners) {

            if (oneRowBanners.getTitle() == null || oneRowBanners.getTitle().equals("")) {
                bannerTitle.setVisibility(View.GONE);
            } else {
                bannerTitle.setText(oneRowBanners.getTitle());
            }

            ArrayList<HomeBanner> bannerList = oneRowBanners.getBanners();
            BannerAdapter bannerAdapter = new BannerAdapter(context, bannerList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            bannerRecycler.setLayoutManager(linearLayoutManager);
            bannerRecycler.setAdapter(bannerAdapter);
        }

        void setCustomItemDecoration(CustomItemDecoration customItemDecoration) {
            this.customItemDecoration = customItemDecoration;
            bannerRecycler.addItemDecoration(customItemDecoration);
        }


    }


    public class OneRowItemsViewHolder extends RecyclerView.ViewHolder {

        TextView itemsTitle;
        TextView txt_oneRowItemsInlineAction;
        ImageView icon_oneRowItemsInlineAction;
        RecyclerView itemsRecycler;
        CustomItemDecoration customItemDecoration;
        ConstraintLayout ConstraintLayout_title;

        OneRowItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            ConstraintLayout_title = itemView.findViewById(R.id.txt_titleConstraintLayout);
            txt_oneRowItemsInlineAction = itemView.findViewById(R.id.txt_oneRowItemsInlineAction);
            icon_oneRowItemsInlineAction = itemView.findViewById(R.id.icon_oneRowItemsInlineAction);
            itemsTitle = itemView.findViewById(R.id.txt_items_title);
            itemsRecycler = itemView.findViewById(R.id.item_recycler);
            if (customItemDecoration == null)
                setCustomItemDecoration(new CustomItemDecoration(context.getResources().getDimension(R.dimen.recycler_horizontal_margin)));
        }

        void setData(HomeOneRowItems oneRowItems) {

            String oneRowItemsTitle = oneRowItems.getTitle();
            HomeInlineAction oneRowItemsInlineAction = oneRowItems.getHomeInlineAction();

            if ((oneRowItemsTitle == null || oneRowItemsTitle.equals("")) && oneRowItemsInlineAction == null) {
                ConstraintLayout_title.setVisibility(View.GONE);

            } else if (oneRowItemsTitle == null || oneRowItemsTitle.equals("")) {
                itemsTitle.setVisibility(View.GONE);
                txt_oneRowItemsInlineAction.setText(oneRowItems.getHomeInlineAction().getTitle());

            } else if (oneRowItemsInlineAction == null) {
                icon_oneRowItemsInlineAction.setVisibility(View.GONE);
                txt_oneRowItemsInlineAction.setVisibility(View.GONE);
                itemsTitle.setText(oneRowItems.getTitle());
            } else {

                itemsTitle.setText(oneRowItems.getTitle());
                txt_oneRowItemsInlineAction.setText(oneRowItems.getHomeInlineAction().getTitle());
            }


            ArrayList<HomeItem> items = oneRowItems.getItems();
            ItemAdapter itemAdapter = new ItemAdapter(context, items);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            itemsRecycler.setLayoutManager(linearLayoutManager);
            itemsRecycler.setAdapter(itemAdapter);
        }

        void setCustomItemDecoration(CustomItemDecoration customItemDecoration) {
            this.customItemDecoration = customItemDecoration;
            itemsRecycler.addItemDecoration(customItemDecoration);
        }
    }

    public static class UnSupportedComponentViewHolder extends RecyclerView.ViewHolder {

        TextView txt_description;

        UnSupportedComponentViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_description = itemView.findViewById(R.id.txt_description);
        }

    }


}


