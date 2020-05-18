package pro.vteam.freemarket.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

import pro.vteam.freemarket.models.CategoriesList;
import pro.vteam.freemarket.fragments.ProgramsGamesFragment;

public class CategoriesPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<CategoriesList> listModels;

    public CategoriesPagerAdapter(FragmentManager fm, ArrayList<CategoriesList> listModels) {
        super(fm);
        this.listModels = listModels;

    }

    @Override
    public Fragment getItem(int position) {


       // return new ProgramsGamesFragment(listModels.get(position).getListItems());

        // because of change tabs order
        if(position==0){
         return new ProgramsGamesFragment(listModels.get(1).getListItems());
        }
        else {
            return new ProgramsGamesFragment(listModels.get(0).getListItems());
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {

      //  return listModels.get(position).getTitle();

      // because of change tabs order
        if(position==0){
            return listModels.get(1).getTitle();}
        else {
            return    listModels.get(0).getTitle();}
    }

    @Override
    public int getCount() {
        return listModels.size();
    }




}
