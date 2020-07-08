package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.CommentVerticalCollection;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private ArrayList<CommentVerticalCollection.Comment> comments;
   private Context context;

    CommentAdapter(Context context, ArrayList<CommentVerticalCollection.Comment> comments) {
        this.comments = comments;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.model_comment,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommentVerticalCollection.Comment item = comments.get(position);
        Glide.with(context)
                .load(item.getUser().getProfileImage())
                .into(holder.img_userIcon);
        holder.ratingBar.setRotationY(180);
        holder.ratingBar.setRating((item.getRatePercent()/100f)*5);
        holder.txt_userName.setText(item.getUser().getName());
        holder.txt_date.setText(item.getDatetime());
        holder.txt_comment.setText(item.getBody());

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }




    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView img_userIcon;
        TextView txt_userName;
        TextView txt_date;
       RatingBar ratingBar;
        TextView txt_comment;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardView);
            img_userIcon=itemView.findViewById(R.id.img_userIcon);
            txt_userName=itemView.findViewById(R.id.txt_userName);
            txt_date=itemView.findViewById(R.id.txt_date);
            txt_comment=itemView.findViewById(R.id.txt_comment);
            ratingBar=itemView.findViewById(R.id.ratingBar);

        }
    }

}
