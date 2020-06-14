package pro.vteam.freemarket.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import pro.vteam.freemarket.fragments.MyMarketFragment;
import pro.vteam.freemarket.fragments.MyMarketVideoFragment;

public class MyMarketPagerAdapter extends FragmentPagerAdapter {


    private String [] tabs;


    public MyMarketPagerAdapter(@NonNull FragmentManager fm,String[] tabs) {
        super(fm);
        this.tabs=tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==1){
            return new MyMarketFragment();
        }
        else {
            return new  MyMarketVideoFragment();
        }
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
