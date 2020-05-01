package pro.vteam.freemarket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.adapter.CategoriesRecyclerAdapter;
import pro.vteam.freemarket.models.CategoriesItemsModel;

public class ProgramsGamesFragment extends Fragment {

    private ArrayList<CategoriesItemsModel> list;

    public ProgramsGamesFragment(ArrayList<CategoriesItemsModel> list) {
        this.list = list;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_programs_games, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler);

        CategoriesRecyclerAdapter categoriesRecyclerAdapter = new CategoriesRecyclerAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(categoriesRecyclerAdapter);
        return rootView;
    }
}
