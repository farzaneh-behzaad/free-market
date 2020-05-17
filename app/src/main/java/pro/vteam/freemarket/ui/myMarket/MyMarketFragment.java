package pro.vteam.freemarket.ui.myMarket;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import pro.vteam.freemarket.R;
import pro.vteam.freemarket.adapter.MyMarketPagerAdapter;

public class MyMarketFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_my_market, container, false);
        Toolbar toolbar=root.findViewById(R.id.toolbar);
        toolbar.setTitle("MARKET");
        toolbar.inflateMenu(R.menu.my_market_menue);





        ViewPager viewPager=root.findViewById(R.id.view_pager);
        TabLayout tabLayout=root.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        MyMarketViewModel  myMarketViewModel = ViewModelProviders.of(this).get(MyMarketViewModel.class);
        myMarketViewModel.getTabs().observe(getViewLifecycleOwner(), new Observer<String[]>() {
            @Override
            public void onChanged(String[] strings) {
                MyMarketPagerAdapter adapter=new MyMarketPagerAdapter(getChildFragmentManager(),strings);
                viewPager.setAdapter(adapter);
                tabLayout.getTabAt(1).select();


            }
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
