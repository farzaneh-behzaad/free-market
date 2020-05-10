package pro.vteam.freemarket.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;


import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.adapter.ApplicationTypesRecyclerAdapter;
import pro.vteam.freemarket.models.AppModel;
import pro.vteam.freemarket.models.ApplicationTypesModel;


public class ItemActivity extends AppCompatActivity {

    ArrayList<AppModel> appList;
    ArrayList<ApplicationTypesModel> appsTypeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);


        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getStringExtra("title"));
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

     modifyAppList();
        modifyAppsTypeList();




        RecyclerView recyclerView=findViewById(R.id.appTypesRecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ApplicationTypesRecyclerAdapter adapter= new ApplicationTypesRecyclerAdapter(this,appsTypeList);
        recyclerView.setAdapter(adapter);

    }


    private void modifyAppList(){
        appList=new ArrayList<>();
        for (int i=0;i<=10;i++){
            AppModel app = new AppModel();
            app.setAppName("اپلیکیشن "+ i);
            app.setAppCost("رایگان");
            app.setAppIconUrl("R.drawable.ic_android_black_24dp");
            appList.add(app);
        }

    }


    private void modifyAppsTypeList(){
        appsTypeList=new ArrayList<>();
        for (int i=0;i<=10;i++){
            ApplicationTypesModel appType = new ApplicationTypesModel();
             appType.setAppsType("نوع " + i);
             appType.setAppsList(appList);
             appsTypeList.add(appType);
        }

    }
}
