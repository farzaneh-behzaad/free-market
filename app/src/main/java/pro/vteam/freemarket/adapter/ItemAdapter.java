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
import pro.vteam.freemarket.models.HomeItem;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewHolder>{
    private Context context;
    private ArrayList<HomeItem> list;


    public ItemAdapter(Context context, ArrayList<HomeItem> list){
        this.context= context;
        this.list=list;

    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_item,parent,false);

        ItemAdapter.viewHolder viewHolder=new ItemAdapter.viewHolder(view);
        viewHolder.itemIcon =view.findViewById(R.id.itemIcon);
        viewHolder.itemName =view.findViewById(R.id.itemName);
        viewHolder.itemPrice =view.findViewById(R.id.itemPrice);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        HomeItem item = list.get(position);

        Glide.with(context)
                .load(item.getHomeIcon().getPath())
                .into(holder.itemIcon);

        holder.itemName.setText(item.getTitle());
        holder.itemPrice.setText(item.getPrice());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private ImageView itemIcon;
        private TextView itemName;
        private TextView itemPrice;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            itemIcon = itemView.findViewById(R.id.itemIcon);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
        }
    }
}
