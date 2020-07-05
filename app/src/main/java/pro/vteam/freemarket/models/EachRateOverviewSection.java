package pro.vteam.freemarket.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;

import pro.vteam.freemarket.R;

public class EachRateOverviewSection extends LinearLayoutCompat {


    TextView txt_progressNum;
    ProgressBar progressBar;

    public EachRateOverviewSection(Context context) {
        super(context);
        View view= inflate(context,R.layout.model_rates_overview_section,this);
        txt_progressNum=view.findViewById(R.id.txt_progressNum);
        progressBar=view.findViewById(R.id.progressBar);
        progressBar.setRotation(180);
    }


    public void setTxt_progressNum( String value){
        txt_progressNum.setText(value);
    }

    public void setProgressBar( int value){
        progressBar.setProgress(value);
    }
}
