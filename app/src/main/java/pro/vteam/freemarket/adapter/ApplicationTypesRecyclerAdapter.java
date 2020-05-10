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
import pro.vteam.freemarket.models.ApplicationTypesModel;

public class ApplicationTypesRecyclerAdapter extends RecyclerView.Adapter<ApplicationTypesRecyclerAdapter.viewHolder> {
    private Context context;
    private ArrayList<ApplicationTypesModel> list;

    public ApplicationTypesRecyclerAdapter(Context context, ArrayList<ApplicationTypesModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_application_types, parent, false);

        viewHolder holder = new viewHolder(view);
        holder.recyclerView = view.findViewById(R.id.appsRecycler);
        holder.txt_appType = view.findViewById(R.id.txt_appType);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        ApplicationTypesModel item = list.get(position);

        holder.txt_appType.setText(item.getAppsType());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(new AppsRecyclerAdapter(context, item.getAppsList()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView txt_appType;
        RecyclerView recyclerView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txt_appType = itemView.findViewById(R.id.txt_appType);
            recyclerView = itemView.findViewById(R.id.appsRecycler);
        }
    }
}
