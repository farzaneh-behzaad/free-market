package pro.vteam.freemarket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.adapter.ItemRecyclerAdapter;
import pro.vteam.freemarket.models.ItemModel;
import pro.vteam.freemarket.viewmodel.CategoriesItemViewModel;

public class ItemCategoriesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_item_categories,container,false);


        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle(getArguments().getString("title"));

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        if (( (AppCompatActivity)getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        RecyclerView recyclerView = view.findViewById(R.id.item_component_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        CategoriesItemViewModel viewModel = ViewModelProviders.of(this).get(CategoriesItemViewModel.class);
        viewModel.getAppsList().observe(() -> getLifecycle(), new Observer<ArrayList<ItemModel>>() {
            @Override
            public void onChanged(ArrayList<ItemModel> itemModels) {
                ItemRecyclerAdapter adapter= new ItemRecyclerAdapter(getContext(),itemModels);
                recyclerView.setAdapter(adapter);

            }
        });



        return view;
    }
}
