package pro.vteam.freemarket.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomItemDecoration extends RecyclerView.ItemDecoration {

    private int margin;


    public CustomItemDecoration(double margin) {
        this.margin = (int) margin;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);


        if (parent.getLayoutManager().canScrollHorizontally()) {
            outRect.left = margin;
            if (parent.getChildAdapterPosition(view) == 0)
                outRect.right = margin;
        } else if(parent.getLayoutManager().canScrollVertically()){
            outRect.bottom= margin;
            if(parent.getChildAdapterPosition(view)==0)
                outRect.top= margin;
        }
    }

}
