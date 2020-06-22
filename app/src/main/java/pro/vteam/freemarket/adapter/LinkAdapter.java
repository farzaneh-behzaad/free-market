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
import pro.vteam.freemarket.models.HomeLink;

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.ViewHolder> {

    private ArrayList<HomeLink> linkList;
    private Context context;

    public LinkAdapter(Context context, ArrayList<HomeLink> linkList) {

        this.linkList = linkList;
        this.context=context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.model_link, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HomeLink item = linkList.get(position);
        Glide.with(context)
                .load(item.getHomeIcon().getPath())
                .into(holder.linkIcon);

        holder.linkText.setText(item.getLink());
    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView linkIcon;
        private TextView linkText;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linkIcon = itemView.findViewById(R.id.linkIcon);
            linkText = itemView.findViewById(R.id.linkText);
        }
    }
}
