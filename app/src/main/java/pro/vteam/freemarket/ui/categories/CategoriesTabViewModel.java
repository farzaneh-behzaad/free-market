package pro.vteam.freemarket.ui.categories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pro.vteam.freemarket.models.CategoriesList;
import pro.vteam.freemarket.repository.Repository;

public class CategoriesTabViewModel extends ViewModel {

    private MutableLiveData<ArrayList<CategoriesList>> lists;

    public CategoriesTabViewModel() {
        lists = new MutableLiveData<>();
        Repository.getCategoriesLists(lists);
    }

    public MutableLiveData<ArrayList<CategoriesList>> getObjectsList() {
        return lists;
    }

}
