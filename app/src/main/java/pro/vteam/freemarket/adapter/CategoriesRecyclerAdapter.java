package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.CategoriesItemsModel;

public class CategoriesRecyclerAdapter extends RecyclerView.Adapter<CategoriesRecyclerAdapter.ViewHolder> {
    private ArrayList<CategoriesItemsModel> itemsList;
    private Context context;

    public CategoriesRecyclerAdapter(Context context,ArrayList<CategoriesItemsModel> itemsList){
        this.context=context;
        this.itemsList=itemsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.model_categories_programs_games,parent,false);
        ViewHolder holder=new ViewHolder(view);
        holder.txt_subject=view.findViewById(R.id.txt_subject);
        holder.iconUrl=view.findViewById(R.id.img_icon);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoriesItemsModel item = itemsList.get(position);
        holder.txt_subject .setText(item.getTxt_subject());
        holder.iconUrl.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_edit_black_24dp));
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_subject;
        ImageView iconUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_subject=itemView.findViewById(R.id.txt_subject);
            iconUrl=itemView.findViewById(R.id.img_icon);

        }
    }
}
