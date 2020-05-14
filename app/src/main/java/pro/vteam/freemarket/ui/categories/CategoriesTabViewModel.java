package pro.vteam.freemarket.ui.categories;

import android.database.Observable;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pro.vteam.freemarket.models.CategoriesList;
import pro.vteam.freemarket.repository.Repository;

public class CategoriesTabViewModel extends ViewModel {


    public ObservableBoolean isLoading = new ObservableBoolean(true);

    private MutableLiveData<ArrayList<CategoriesList>> lists;

    public CategoriesTabViewModel() {
        lists = new MutableLiveData<>();

        Repository.getCategoriesLists(lists);

        lists.observeForever(categoriesLists -> {
            isLoading.set(false);
            isLoading.notifyChange();
        });
    }

    MutableLiveData<ArrayList<CategoriesList>> getObjectsList() {
        return lists;
    }

}
