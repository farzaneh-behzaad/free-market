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


import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.interfaces.CategoriesItemsListener;
import pro.vteam.freemarket.oldModels.AppModel;
import pro.vteam.freemarket.oldModels.BannerListModel;
import pro.vteam.freemarket.oldModels.BannerModel;
import pro.vteam.freemarket.oldModels.AppListModel;
import pro.vteam.freemarket.oldModels.BigPromotionBannerModel;
import pro.vteam.freemarket.oldModels.ItemModel;


public class ItemRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<ItemModel> list;
    private CategoriesItemsListener categoriesItemsListener;

    public ItemRecyclerAdapter(Context context, ArrayList<ItemModel> list) {
        this.context = context;
        this.list = list;
    }


    public void setCategoriesItemsListener(CategoriesItemsListener categoriesItemsListener) {
        this.categoriesItemsListener = categoriesItemsListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        switch (viewType) {
            case 0: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_one_row_banners, parent, false);
                return new BannerViewHolder(view);

            }
            case 1: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_one_row_items, parent, false);
                return new AppsViewHolder(view);
            }

            case 2: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_big_promotion_banner, parent, false);
                return new BigPromotionViewHolder(view);
            }
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                ((BannerViewHolder) holder).setData(list.get(position).getBannerListModel());
                break;
            case 1:
                ((AppsViewHolder) holder).setData(list.get(position).getAppListModel());
                break;
            case 2:
                ((BigPromotionViewHolder) holder).setData(list.get(position).getBigPromotionBannerModel());
                break;

        }
    }


    @Override
    public int getItemViewType(int position) {
        return list.get(position).getViewType();
    }


    @Override

    public int getItemCount() {
        return list.size();
    }


    public class BigPromotionViewHolder extends RecyclerView.ViewHolder {


        ImageView img_promotion_banner;
        ImageView img_promotion_icon;
        TextView txt_promotion_name;
        Button btn_install;

        public BigPromotionViewHolder(@NonNull View itemView) {
            super(itemView);

            img_promotion_banner = itemView.findViewById(R.id.img_bigPromotionBanner);
            img_promotion_icon = itemView.findViewById(R.id.img_bigPromotionIcon);
            txt_promotion_name = itemView.findViewById(R.id.txt_promotion_name);
            btn_install = itemView.findViewById(R.id.btn_inlineAction);

        }


        void setData(BigPromotionBannerModel bigPromotionBannerModel) {
//            Glide.with(context)
//                    .load(bigPromotionBannerModel.getPromotion_banner_url())
//                    .into(img_promotion_banner);
//
//            Glide.with(context)
//                    .load(bigPromotionBannerModel.getPromotion_icon_url())
//                    .into(img_promotion_icon);


            txt_promotion_name.setText(bigPromotionBannerModel.getTxt_name());

        }
    }


    public class BannerViewHolder extends RecyclerView.ViewHolder {

        TextView bannerTitle;
        RecyclerView bannerRecycler;


        BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerTitle = itemView.findViewById(R.id.txt_banner_title);
            bannerRecycler = itemView.findViewById(R.id.banner_recycler);

        }


        void setData(BannerListModel bannerListModel) {

            bannerTitle.setText(bannerListModel.getTitle());

            ArrayList<BannerModel> bannerList = bannerListModel.getBannerList();
            BannersAdapter bannersAdapter = new BannersAdapter(context, bannerList);
            bannerRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            bannerRecycler.setAdapter(bannersAdapter);
        }


    }


    public class AppsViewHolder extends RecyclerView.ViewHolder {

        TextView appsTitle;
        RecyclerView appRecycler;

        AppsViewHolder(@NonNull View itemView) {
            super(itemView);

            appsTitle = itemView.findViewById(R.id.txt_items_title);
            appRecycler = itemView.findViewById(R.id.item_recycler);
        }

        void setData(AppListModel appListModel) {
            appsTitle.setText(appListModel.getTitle());
            ArrayList<AppModel> appList = appListModel.getAppList();
            AppsAdapter appsAdapter = new AppsAdapter(context, appList);
            appRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            appRecycler.setAdapter(appsAdapter);
        }

    }


//    public class CategoriesItemsViewHolder extends RecyclerView.ViewHolder {
//
//        TextView subject;
//        ImageView icon;
//        View divider;
//        CardView cardView;
//
//        CategoriesItemsViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            subject = itemView.findViewById(R.id.txt_subject);
//            icon = itemView.findViewById(R.id.img_icon);
//            divider = itemView.findViewById(R.id.divider);
//            cardView=itemView.findViewById(R.id.item_cardView);
//        }
//
//        void setData(CategoriesItemModel categoriesItemModel,int position) {
//
//
//            if (position == list.size() - 1) {
//               divider.setVisibility(View.GONE);
//            }else {
//               divider.setVisibility(View.VISIBLE);
//            }
//          subject.setText(categoriesItemModel.getTxt_subject());
//            Glide.with(context)
//                    .load(categoriesItemModel.getIconUrl())
//                    .into(icon);
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (categoriesItemsListener != null) {
//                        categoriesItemsListener.onItemClick(position);
//                    }
//                }
//            });
//
//        }
//
//    }
}


