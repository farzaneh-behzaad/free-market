package pro.vteam.freemarket.ui.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.adapter.CategoriesPagerAdapter;
import pro.vteam.freemarket.models.CategoriesItemsModel;
import pro.vteam.freemarket.models.CategoriesListModel;

public class CategoriesFragment extends Fragment {
    TabLayout tabLayout;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_categories, container, false);
         tabLayout = root.findViewById(R.id.tab_layout);
        final ViewPager viewPager = root.findViewById(R.id.view_pager);


        tabLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        CategoriesTabViewModel viewModel = ViewModelProviders.of(this).get(CategoriesTabViewModel.class);
        viewModel.getObjectsList().observe(getViewLifecycleOwner(), new Observer<ArrayList<CategoriesListModel>>() {
            @Override
            public void onChanged(ArrayList<CategoriesListModel> categoriesListModels) {
              CategoriesPagerAdapter adapter=new CategoriesPagerAdapter(getChildFragmentManager(),categoriesListModels);
                viewPager.setAdapter(adapter);
                tabLayout.getTabAt(1).select();

            }
        });





        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabPosition = tab.getPosition();
                if (tabPosition == 0) {
                    tab.setText(getResources().getString(R.string.games));
                } else {
                    tab.setText(getResources().getString(R.string.programs));
                }
                viewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return root;
    }




}
