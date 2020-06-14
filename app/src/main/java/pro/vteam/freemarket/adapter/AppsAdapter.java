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
import pro.vteam.freemarket.models.AppsModel;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.viewHolder>{
    private Context context;
    private ArrayList<AppsModel> list;


    public AppsAdapter(Context context,ArrayList<AppsModel> list){
        this.context= context;
        this.list=list;

    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_apps,parent,false);

        AppsAdapter.viewHolder viewHolder=new AppsAdapter.viewHolder(view);
        viewHolder.appsIcon=view.findViewById(R.id.appsIcon);
        viewHolder.appsName=view.findViewById(R.id.appsName);
        viewHolder.txtExtra=view.findViewById(R.id.txtExtra);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        AppsModel item = list.get(position);
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
            appsIcon= itemView.findViewById(R.id.appsIcon);
            appsName= itemView.findViewById(R.id.appsName);
            txtExtra= itemView.findViewById(R.id.txtExtra);
        }
    }
}
