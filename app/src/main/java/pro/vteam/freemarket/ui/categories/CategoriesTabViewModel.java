package pro.vteam.freemarket.ui.categories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pro.vteam.freemarket.models.CategoriesItemsModel;
import pro.vteam.freemarket.models.CategoriesListModel;

public class CategoriesTabViewModel extends ViewModel {

    private MutableLiveData<ArrayList<CategoriesListModel>> lists;

    public CategoriesTabViewModel() {
        lists = new MutableLiveData<>();
        lists.setValue(modifyLists());
    }

    public MutableLiveData<ArrayList<CategoriesListModel>> getObjectsList() {
        return lists;
    }

    private ArrayList<CategoriesListModel> modifyLists() {
        ArrayList<CategoriesItemsModel> programsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            CategoriesItemsModel object = new CategoriesItemsModel("برنامه " + i, "@drawable/ic_edit_black_24dp");
            programsList.add(object);
        }

        ArrayList<CategoriesItemsModel> gamesList = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            CategoriesItemsModel object = new CategoriesItemsModel("بازی " + i, "@drawable/ic_edit_black_24dp");
            gamesList.add(object);
        }

        ArrayList<CategoriesListModel> list = new ArrayList<>();
        list.add(new CategoriesListModel("بازی ها ", gamesList));
        list.add(new CategoriesListModel("برنامه ها ", programsList));

        return list;
    }


}
