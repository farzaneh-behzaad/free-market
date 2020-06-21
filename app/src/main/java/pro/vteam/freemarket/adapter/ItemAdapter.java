package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.HomeItem;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewHolder>{
    private Context context;
    private ArrayList<HomeItem> list;


     ItemAdapter(Context context, ArrayList<HomeItem> list){
        this.context= context;
        this.list=list;

    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_item,parent,false);

        ItemAdapter.viewHolder viewHolder= new viewHolder(view);
        viewHolder.itemIcon =view.findViewById(R.id.itemIcon);
        viewHolder.itemName =view.findViewById(R.id.itemName);
        viewHolder.itemPrice =view.findViewById(R.id.itemPrice);
        viewHolder.txtTag =view.findViewById(R.id.txt_tag);
        viewHolder.tagCardView =view.findViewById(R.id.tag_cardView);


        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        HomeItem item = list.get(position);


        if(item.getTag()==null){
            holder.txtTag.setVisibility(View.GONE);
        }else {holder.txtTag.setText(item.getTag().getTitle());
          holder.tagCardView.setCardBackgroundColor(Color.parseColor(item.getTag().getBackgroundColor()));
        }

        ((ConstraintLayout.LayoutParams) holder.itemIcon.getLayoutParams()).dimensionRatio
                =item.getHomeIcon().getRatio().getConstraintDimensionRatio();

        Glide.with(context)
                .load(item.getHomeIcon().getPath())
                .centerCrop()
                .into(holder.itemIcon);

        holder.itemName.setText(item.getTitle());
        holder.itemPrice.setText(item.getPrice());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

     static class viewHolder extends RecyclerView.ViewHolder{


        private ImageView itemIcon;
        private TextView itemName;
        private TextView itemPrice;
         private TextView txtTag;
         CardView tagCardView;

         viewHolder(@NonNull View itemView) {
            super(itemView);
            itemIcon = itemView.findViewById(R.id.itemIcon);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            txtTag=itemView.findViewById(R.id.txt_tag);
             tagCardView=itemView.findViewById(R.id.tag_cardView);
        }
    }
}
