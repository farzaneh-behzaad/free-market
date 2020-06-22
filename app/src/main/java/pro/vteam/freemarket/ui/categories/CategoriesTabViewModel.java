package pro.vteam.freemarket.ui.categories;

import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pro.vteam.freemarket.oldModels.CategoriesTabListModel;
import pro.vteam.freemarket.repository.Repository;

public class CategoriesTabViewModel extends ViewModel {


    ObservableBoolean isLoading = new ObservableBoolean(true);
    ObservableBoolean isFailed = new ObservableBoolean(false);

    private MutableLiveData<ArrayList<CategoriesTabListModel>> lists;

    public CategoriesTabViewModel() {
        pullData();
    }

    MutableLiveData<ArrayList<CategoriesTabListModel>> getObjectsList() {
        return lists;
    }


    public void pullData() {
        if (lists == null) {
            lists = new MutableLiveData<>();
        }
        isLoading.set(true);
        isFailed.set(false);
        isLoading.notifyChange();
        isFailed.notifyChange();

        Repository.getCategoriesLists(new Repository.categoriesDataListener() {
            @Override
            public void onAccess(ArrayList<CategoriesTabListModel> list) {
                lists.setValue(list);
                isFailed.set(false);
                isLoading.set(false);
                isFailed.notifyChange();
                isLoading.notifyChange();

            }

            @Override
            public void onFailed() {
                isFailed.set(true);
                isLoading.set(false);
                isLoading.notifyChange();
                isFailed.notifyChange();
                Log.wtf("LOG_isFailed", isFailed.get() + "");
            }
        });

    }

}
