package pro.vteam.freemarket;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textview.MaterialTextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CostumeTextView extends MaterialTextView {
    Typeface iconTypeFace;

    public CostumeTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        iconTypeFace = Typeface.createFromAsset(context.getAssets(), "free_market_font_icon.ttf");
    }
    public CostumeTextView(@NonNull Context context) {
        super(context);
        iconTypeFace = Typeface.createFromAsset(context.getAssets(), "free_market_font_icon.ttf");
    }




    @Override
    public void setText(CharSequence text, BufferType type) {



        SpannableStringBuilder ssb = new SpannableStringBuilder(text);

        while (true) {
            Pattern pattern = Pattern.compile("<icon>(\\w*)</icon>");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {

                int start = matcher.start();
                int end = matcher.start() + 1;

                String matchValue = matcher.group(1).toString();
                String iconString = String.valueOf((char) (Integer.parseInt(matchValue.replace("\\", ""), 16)));
                text = matcher.replaceFirst(iconString);
                ssb.delete(start, matcher.end());
                ssb.insert(start, iconString);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    ssb.setSpan(new TypefaceSpan(iconTypeFace), start, end, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE);
                }
            } else {

                break;
            }
            super.setText(ssb, type);
        }
        super.setText(ssb,type);
    }
}
