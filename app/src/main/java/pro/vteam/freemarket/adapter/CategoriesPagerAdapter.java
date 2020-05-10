package pro.vteam.freemarket.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

import pro.vteam.freemarket.models.CategoriesList;
import pro.vteam.freemarket.fragments.ProgramsGamesFragment;

public class CategoriesPagerAdapter extends FragmentPagerAdapter {

    ArrayList<CategoriesList> listModels;

    public CategoriesPagerAdapter(FragmentManager fm, ArrayList<CategoriesList> listModels) {
        super(fm);
        this.listModels = listModels;
    }

    @Override
    public Fragment getItem(int position) {
        return new ProgramsGamesFragment(listModels.get(position).getListItems());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listModels.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return listModels.size();
    }


}
