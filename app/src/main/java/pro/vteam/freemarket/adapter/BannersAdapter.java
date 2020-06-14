package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.AppModel;
import pro.vteam.freemarket.models.BannerModel;

public class BannersAdapter extends RecyclerView.Adapter<BannersAdapter.viewHolder>{
    private Context context;
    private ArrayList<BannerModel> list;


    public BannersAdapter(Context context, ArrayList<BannerModel> list){
        this.context= context;
        this.list=list;

    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_banner,parent,false);
        BannersAdapter.viewHolder viewHolder=new BannersAdapter.viewHolder(view);
        viewHolder.bannerUrl=view.findViewById(R.id.img_banner);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        BannerModel item = list.get(position);
//        Glide.with(context)
//                .load(item.getImgBannerUrl())
//                .into(holder.bannerUrl);
//        holder.bannerUrl.setImageDrawable(context.getResources().getDrawable(R.drawable.img));


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
