package pro.vteam.freemarket.ui.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.widget.ProgressBar;

import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.adapter.CategoriesPagerAdapter;
import pro.vteam.freemarket.databinding.FragmentCategoriesBinding;

public class CategoriesFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentCategoriesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false);
        View root = binding.getRoot();


        TabLayout tabLayout = root.findViewById(R.id.tab_layout);
        final ViewPager viewPager = root.findViewById(R.id.view_pager);

        tabLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        CategoriesTabViewModel viewModel = ViewModelProviders.of(this).get(CategoriesTabViewModel.class);
        binding.setIsLoading(viewModel.isLoading);

        viewModel.getObjectsList().observe(getViewLifecycleOwner(), categoriesLists -> {
            CategoriesPagerAdapter adapter = new CategoriesPagerAdapter(getChildFragmentManager(), categoriesLists);
            viewPager.setAdapter(adapter);
            tabLayout.getTabAt(1).select();
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
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
