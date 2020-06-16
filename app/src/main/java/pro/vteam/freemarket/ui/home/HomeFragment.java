package pro.vteam.freemarket.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.adapter.ComponentRecyclerAdapter;
import pro.vteam.freemarket.models.HomeComponent;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView homeRecycler = root.findViewById(R.id.homeRecycler);
        homeViewModel.getComponentList().observe(getViewLifecycleOwner(), new Observer<ArrayList<HomeComponent>>() {
            @Override
            public void onChanged(ArrayList<HomeComponent> homeComponents) {

                ComponentRecyclerAdapter componentRecyclerAdapter=new ComponentRecyclerAdapter(getContext(),homeComponents);
                homeRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                homeRecycler.setAdapter(componentRecyclerAdapter);

            }
        });

        return root;
    }
}
