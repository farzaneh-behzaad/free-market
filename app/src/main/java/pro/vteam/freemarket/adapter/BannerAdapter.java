package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.Banner;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.viewHolder>{
    private Context context;
    private ArrayList<Banner> list;


    BannerAdapter(Context context, ArrayList<Banner> list){
        this.context= context;
        this.list=list;

    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_banner,parent,false);
        BannerAdapter.viewHolder viewHolder= new viewHolder(view);
        viewHolder.bannerImage =view.findViewById(R.id.img_banner);
        viewHolder.txt_bannerTag =view.findViewById(R.id.txt_bannerTag);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Banner item = list.get(position);

        if(item.getTag() == null){
            holder.txt_bannerTag.setVisibility(View.GONE);
        }
        else {
            holder.txt_bannerTag.setText(item.getTag().getTitle());
            holder.txt_bannerTag.setTextColor(Color.parseColor(item.getTag().getTextColor()));
            holder.txt_bannerTag.setBackgroundColor(Color.parseColor(item.getTag().getBackgroundColor()));

        }

        ((ConstraintLayout.LayoutParams) holder.bannerImage.getLayoutParams()).dimensionRatio
                =item.getImage().getRatio().getConstraintDimensionRatio();
        Glide.with(context)
                .load(item.getImage().getPath())
                .centerCrop()
                .into(holder.bannerImage);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder{

        private ImageView bannerImage;
        private TextView txt_bannerTag;



        viewHolder(@NonNull View itemView) {
            super(itemView);
            bannerImage = itemView.findViewById(R.id.img_banner);
            txt_bannerTag = itemView.findViewById(R.id.txt_bannerTag);

        }
    }
}
