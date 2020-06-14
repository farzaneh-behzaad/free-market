package pro.vteam.freemarket.ui.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.adapter.VideoRecyclerAdapter;
import pro.vteam.freemarket.models.AppListModel;
import pro.vteam.freemarket.models.ItemModel;

public class VideoFragment extends Fragment {

    private VideoViewModel videoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        videoViewModel = ViewModelProviders.of(this).get(VideoViewModel.class);

        View root = inflater.inflate(R.layout.fragment_video, container, false);
        RecyclerView recyclerView= root.findViewById(R.id.videoRecycler);
        videoViewModel.getList().observe(getViewLifecycleOwner(), categoriesLists -> {
          videoViewModel.getList().observe(getViewLifecycleOwner(), new Observer<ArrayList<ItemModel>>() {
              @Override
              public void onChanged(ArrayList<ItemModel> appListModels) {
                  VideoRecyclerAdapter videoRecyclerAdapter=new VideoRecyclerAdapter(getContext(), appListModels);
                  recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                  recyclerView.setAdapter(videoRecyclerAdapter);
              }
          });
        });

        return root;
    }
}
