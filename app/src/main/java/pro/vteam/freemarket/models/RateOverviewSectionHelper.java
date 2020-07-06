package pro.vteam.freemarket.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.text.ParseException;

import pro.vteam.freemarket.R;

public class RateOverviewSectionHelper {


    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static ProgressBar createProgressBar(Context context, int progressPercent, int row, int col) {

        ProgressBar progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setProgress(progressPercent);
        progressBar.setRotation(180);




        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 0;
        params.height =0;
        params.columnSpec = GridLayout.spec(col, 10.0f);
        params.rowSpec = GridLayout.spec(row,1.0f);



        progressBar.setLayoutParams(params);
        return progressBar;
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static TextView createProgressTitle(Context context, String title, int row, int col) {
        TextView txt_progressTitle = new TextView(context);
        txt_progressTitle.setText(title.subSequence(0, 2));
        txt_progressTitle.setTextSize(10.0f);
        txt_progressTitle.setGravity(Gravity.CENTER);


        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setGravity(Gravity.CENTER);
        params.width =0;
        params.height = 0;
        params.columnSpec = GridLayout.spec(col,1.0f);
        params.rowSpec = GridLayout.spec(row,1.0f);

        txt_progressTitle.setLayoutParams(params);
        return txt_progressTitle;
    }


}
