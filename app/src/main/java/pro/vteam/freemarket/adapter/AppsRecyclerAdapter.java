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

public class AppsRecyclerAdapter extends RecyclerView.Adapter<AppsRecyclerAdapter.viewHolder> {
    private  Context context;
    private ArrayList<AppModel> list;


    public AppsRecyclerAdapter(Context context,ArrayList<AppModel> list){
        this.context= context;
        this.list=list;

    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_app,parent,false);

       viewHolder viewHolder=new viewHolder(view);
       viewHolder.appIcon=view.findViewById(R.id.appIcon);
       viewHolder.appName=view.findViewById(R.id.appName);
       viewHolder.appCost=view.findViewById(R.id.appCost);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        AppModel item = list.get(position);
//
//        Glide.with(context)
//                .load(item.getAppIconUrl())
//                .into(holder.appIcon);
        holder.appIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_android_black_24dp));
        holder.appName.setText(item.getAppName());
        holder.appCost.setText(item.getAppCost());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private ImageView appIcon;
        private TextView appName;
        private TextView appCost;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            appIcon= itemView.findViewById(R.id.appIcon);
            appName= itemView.findViewById(R.id.appName);
            appCost= itemView.findViewById(R.id.appCost);
        }
    }
}
