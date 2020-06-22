package pro.vteam.freemarket.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

import pro.vteam.freemarket.fragments.ProgramsGamesFragment;
import pro.vteam.freemarket.oldModels.CategoriesTabListModel;

public class CategoriesPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<CategoriesTabListModel> listModels;

    public CategoriesPagerAdapter(FragmentManager fm, ArrayList<CategoriesTabListModel> listModels) {
        super(fm);
        this.listModels = listModels;

    }

    @Override
    public Fragment getItem(int position) {


       // return new ProgramsGamesFragment(listModels.get(position).getListItems());
        // because of change tabs order
        if(position==0){
         return new ProgramsGamesFragment(listModels.get(1).getItemsList());
        }
        else {
            return new ProgramsGamesFragment(listModels.get(0).getItemsList());
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {

      //  return listModels.get(position).getTitle();
        // because of change tabs order
        if(position==0){
            return listModels.get(1).getTitle();}
        else {
            return   listModels.get(0).getTitle();}
    }

    @Override
    public int getCount() {
        return listModels.size();
    }




}
