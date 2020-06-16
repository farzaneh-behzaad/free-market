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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_app,parent,false);

        ItemAdapter.viewHolder viewHolder=new ItemAdapter.viewHolder(view);
        viewHolder.appsIcon=view.findViewById(R.id.appIcon);
        viewHolder.appsName=view.findViewById(R.id.appName);
        viewHolder.txtExtra=view.findViewById(R.id.txtExtra);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        HomeItem item = list.get(position);

        Glide.with(context)
                .load(item.getHomeIcon().getPath())
                .into(holder.appsIcon);

        holder.appsName.setText(item.getTitle());
        holder.txtExtra.setText(item.getPrice());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private ImageView appsIcon;
        private TextView appsName;
        private TextView txtExtra;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            appsIcon= itemView.findViewById(R.id.appIcon);
            appsName= itemView.findViewById(R.id.appName);
            txtExtra= itemView.findViewById(R.id.txtExtra);
        }
    }
}
