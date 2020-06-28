package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.Divider;
import pro.vteam.freemarket.models.Link;

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.ViewHolder> {

    private ArrayList<Link> linkList;
    private Divider divider;
    private Context context;

    public LinkAdapter(Context context, ArrayList<Link> linkList, Divider divider) {

        this.linkList = linkList;
        this.context = context;
        this.divider = divider;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.model_link, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.linkDivider = view.findViewById(R.id.linkDivider);
        viewHolder.linkIcon = view.findViewById(R.id.linkIcon);
        viewHolder.linkText = view.findViewById(R.id.linkText);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Link item = linkList.get(position);
        Glide.with(context)
                .load(item.getIcon().getPath())
                .into(holder.linkIcon);

        holder.linkText.setText(item.getTitle());
        holder.linkDivider.setBackgroundColor(Color.parseColor(divider.getColor()));

        if (position == linkList.size() - 1)
            holder.linkDivider.setVisibility(View.GONE);
        else {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) holder.linkDivider.getLayoutParams();
            int rightMargin= divider.getMargin().getRightMargin().getQuantity();
            int leftMargin= divider.getMargin().getLeftMargin().getQuantity();
            params.setMargins(leftMargin, 0,rightMargin, 0);
            holder.linkDivider.setLayoutParams(params);
            holder.linkDivider.requestLayout();
        }

    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView linkIcon;
        private TextView linkText;
       private View linkDivider;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linkIcon = itemView.findViewById(R.id.linkIcon);
            linkText = itemView.findViewById(R.id.linkText);
            linkDivider = itemView.findViewById(R.id.linkDivider);
        }
    }
}
