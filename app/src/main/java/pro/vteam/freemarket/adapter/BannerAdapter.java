package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.BannerModel;
import pro.vteam.freemarket.models.HomeBanner;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.viewHolder>{
    private Context context;
    private ArrayList<HomeBanner> list;


    public BannerAdapter(Context context, ArrayList<HomeBanner> list){
        this.context= context;
        this.list=list;

    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_banner,parent,false);
        BannerAdapter.viewHolder viewHolder=new BannerAdapter.viewHolder(view);
        viewHolder.bannerUrl=view.findViewById(R.id.img_banner);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        HomeBanner item = list.get(position);
        Glide.with(context)
                .load(item.getHomeImage().getPath())
                .into(holder.bannerUrl);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private ImageView bannerUrl;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            bannerUrl= itemView.findViewById(R.id.img_banner);

        }
    }
}
