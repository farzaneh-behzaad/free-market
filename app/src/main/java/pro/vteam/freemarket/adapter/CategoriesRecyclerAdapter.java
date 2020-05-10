package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.interfaces.CategoriesItemsListener;
import pro.vteam.freemarket.models.CategoriesListItems;

public class CategoriesRecyclerAdapter extends RecyclerView.Adapter<CategoriesRecyclerAdapter.ViewHolder> {
    private ArrayList<CategoriesListItems> itemsList;
    private Context context;
    private CategoriesItemsListener categoriesItemsListener;


    public CategoriesRecyclerAdapter(Context context,ArrayList<CategoriesListItems> itemsList){
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
        CategoriesListItems item = itemsList.get(position);
        holder.txt_subject .setText(item.getTxt_subject());
        Glide.with(context)
                .load(item.getIconUrl())
                .into(holder.iconUrl);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (categoriesItemsListener!=null) {
                    categoriesItemsListener.onItemClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_subject;
        ImageView iconUrl;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_subject=itemView.findViewById(R.id.txt_subject);
            iconUrl=itemView.findViewById(R.id.img_icon);
            cardView=itemView.findViewById(R.id.item_cardView);

        }
    }

    public void setCategoriesItemsListener(CategoriesItemsListener categoriesItemsListener){
        this.categoriesItemsListener=categoriesItemsListener;
    }


}
