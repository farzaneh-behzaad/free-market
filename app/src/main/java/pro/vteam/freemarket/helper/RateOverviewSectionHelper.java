package pro.vteam.freemarket.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//        title = "5 <icon>e911</icon><icon>eac1</icon>";
        TextView txt_progressTitle = new TextView(context);
        txt_progressTitle.setText(getTextWithIconTypeFaced(context, title));


        txt_progressTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,10.0f);
        txt_progressTitle.setGravity(Gravity.CENTER);


        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setGravity(Gravity.CENTER);
        params.width = GridLayout.LayoutParams.WRAP_CONTENT;
        params.height = 0;
        params.columnSpec = GridLayout.spec(col);
        params.rowSpec = GridLayout.spec(row, 1.0f);

        txt_progressTitle.setLayoutParams(params);
        return txt_progressTitle;
    }

    private static SpannableStringBuilder getTextWithIconTypeFaced(Context context, String title) {
        Typeface iconTypeFace = Typeface.createFromAsset(context.getAssets(), "free_market_font_icon.ttf");

        SpannableStringBuilder ssb = new SpannableStringBuilder(title);

        while (true) {
            Pattern pattern = Pattern.compile("<icon>(\\w*)</icon>");
            Matcher matcher = pattern.matcher(title);
            if (matcher.find()) {

                int start = matcher.start();
                int end = matcher.start() + 1;

                String matchValue = matcher.group(1).toString();
                String iconString = String.valueOf((char) (Integer.parseInt(matchValue.replace("\\", ""), 16)));
                title = matcher.replaceFirst(iconString);
                ssb.delete(start, matcher.end());
                ssb.insert(start, iconString);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    ssb.setSpan(new TypefaceSpan(iconTypeFace), start, end, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE);
                }
            } else {
                break;
            }
        }
        return ssb;
    }


}
