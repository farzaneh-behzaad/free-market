package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.AppModel;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.viewHolder>{
    private Context context;
    private ArrayList<AppModel> list;


    public AppsAdapter(Context context,ArrayList<AppModel> list){
        this.context= context;
        this.list=list;

    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_item,parent,false);

        AppsAdapter.viewHolder viewHolder=new AppsAdapter.viewHolder(view);
        viewHolder.appsIcon=view.findViewById(R.id.itemIcon);
        viewHolder.appsName=view.findViewById(R.id.itemName);
        viewHolder.txtExtra=view.findViewById(R.id.itemPrice);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        AppModel item = list.get(position);
//
//        Glide.with(context)
//                .load(item.getAppIconUrl())
//                .into(holder.appIcon);
        holder.appsIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_android_black_24dp));
        holder.appsName.setText(item.getAppName());
        holder.txtExtra.setText(item.getTxtExtra());
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
            appsIcon= itemView.findViewById(R.id.itemIcon);
            appsName= itemView.findViewById(R.id.itemName);
            txtExtra= itemView.findViewById(R.id.itemPrice);
        }
    }
}
