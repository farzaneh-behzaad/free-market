package pro.vteam.freemarket.models;

import android.content.Context;
import android.opengl.Visibility;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;

import pro.vteam.freemarket.R;

public class EachItemOverview extends LinearLayoutCompat {

    TextView txt_title;
    TextView txt_subTitle;
    View view_divider;

    public EachItemOverview(Context context) {
        super(context);

        View view = inflate(context, R.layout.item_overview, this);
        txt_title = view.findViewById(R.id.txt_title);
        txt_subTitle = view.findViewById(R.id.txt_subTitle);
        view_divider = view.findViewById(R.id.view_divider);
    }

    public void setTxt_title(String title1) {
        txt_title.setText(title1);
    }

    public void setTxt_subTitle(String title2) {
        txt_subTitle.setText(title2);
    }

    public void setVisibilityDivider(int dividerVisibility){
        view_divider.setVisibility(dividerVisibility);
    }
}
