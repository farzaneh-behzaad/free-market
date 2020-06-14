package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.AppsModel;
import pro.vteam.freemarket.models.BannerListModel;
import pro.vteam.freemarket.models.BannerModel;
import pro.vteam.freemarket.models.AppListModel;
import pro.vteam.freemarket.models.ItemModel;


public class VideoRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<ItemModel> list;

    public VideoRecyclerAdapter(Context context, ArrayList<ItemModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        switch (viewType) {
            case 0: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_banner_list, parent, false);
                return new BannerViewHolder(view);

            }
            case 1: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_app_list, parent, false);
                return new AppsViewHolder(view);
            }
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType=getItemViewType(position);
        switch (viewType)
        {
            case 0:((BannerViewHolder)holder).setData(list.get(position).getBannerListModel()); break;
            case 1:((AppsViewHolder)holder).setData(list.get(position).getAppListModel()); break;



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



    public class BannerViewHolder extends RecyclerView.ViewHolder {

        TextView bannerTitle;
        RecyclerView bannerRecycler;



        BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerTitle=itemView.findViewById(R.id.txt_banner_title);
            bannerRecycler=itemView.findViewById(R.id.banner_recycler);

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

            appsTitle=itemView.findViewById(R.id.txt_app_title);
            appRecycler=itemView.findViewById(R.id.app_recycler);
        }

        void setData(AppListModel appListModel) {
            appsTitle.setText(appListModel.getTitle());
            ArrayList<AppsModel> appList =appListModel.getAppList();
            AppsAdapter appsAdapter = new AppsAdapter(context, appList);
            appRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            appRecycler.setAdapter(appsAdapter);
        }

    }
}


