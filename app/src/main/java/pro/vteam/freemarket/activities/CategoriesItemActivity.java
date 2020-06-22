package pro.vteam.freemarket.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.adapter.ItemRecyclerAdapter;
import pro.vteam.freemarket.oldModels.ItemModel;
import pro.vteam.freemarket.viewmodel.CategoriesItemViewModel;


public class CategoriesItemActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_item);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getStringExtra("title"));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        RecyclerView recyclerView = findViewById(R.id.item_component_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        CategoriesItemViewModel viewModel = ViewModelProviders.of(this).get(CategoriesItemViewModel.class);
        viewModel.getAppsList().observe(() -> getLifecycle(), new Observer<ArrayList<ItemModel>>() {
            @Override
            public void onChanged(ArrayList<ItemModel> itemModels) {

                ItemRecyclerAdapter adapter= new ItemRecyclerAdapter(getApplicationContext(),itemModels);
                recyclerView.setAdapter(adapter);

            }
        });





    }



}
