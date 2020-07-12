package pro.vteam.freemarket.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pro.vteam.freemarket.CostumeTextView;

public class RateOverviewSectionHelper {


    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static ProgressBar createProgressBar(Context context, int progressPercent, int row, int col) {

        ProgressBar progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setProgress(progressPercent);
        progressBar.setRotation(180);


        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 0;
        params.height = 0;

        params.columnSpec = GridLayout.spec(col, 10.0f);
        params.rowSpec = GridLayout.spec(row, 1.0f);


        progressBar.setLayoutParams(params);
        return progressBar;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static TextView createProgressTitle(Context context, String title, int row, int col) {

        CostumeTextView txt_progressTitle = new CostumeTextView(context);
        txt_progressTitle.setText(title);
        txt_progressTitle.setGravity(Gravity.CENTER_VERTICAL);
        txt_progressTitle.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        txt_progressTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,10.0f);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 0;
        params.height = 0;
        params.setMarginStart(10);
        params.columnSpec = GridLayout.spec(col,1.0f);
        params.rowSpec = GridLayout.spec(row, 1.0f);
        txt_progressTitle.setLayoutParams(params);
        return txt_progressTitle;
    }




}
