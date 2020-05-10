package pro.vteam.freemarket.ui.categories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pro.vteam.freemarket.models.CategoriesList;
import pro.vteam.freemarket.models.CategoriesListItems;
import pro.vteam.freemarket.models.Response;
import pro.vteam.freemarket.repository.Repository;

public class CategoriesTabViewModel extends ViewModel {

    private MutableLiveData<ArrayList<CategoriesList>> lists;

    public CategoriesTabViewModel() {
        lists = new MutableLiveData<>();


        Repository.getCategoriesLists(new Repository.CategoryFetchListener() {
            @Override
            public void onSuccess(Response body) {
                lists.setValue(body.getResult().getCategoriesLists());

            }

            @Override
            public void onFailed() {

            }
        });



    }

    public MutableLiveData<ArrayList<CategoriesList>> getObjectsList() {
        return lists;
    }



//
//        ArrayList<CategoriesListItems> programsList = new ArrayList<>();
//        for (int i = 1; i <= 20; i++) {
//            CategoriesListItems object = new CategoriesListItems("برنامه " + i, "@drawable/ic_edit_black_24dp");
//            programsList.add(object);
//        }
//
//        ArrayList<CategoriesListItems> gamesList = new ArrayList<>();
//        for (int i = 1; i <= 20; i++) {
//            CategoriesListItems object = new CategoriesListItems("بازی " + i, "@drawable/ic_edit_black_24dp");
//            gamesList.add(object);
//        }
//
//        ArrayList<CategoriesList> list = new ArrayList<>();
//        list.add(new CategoriesList("بازی ها ", gamesList));
//        list.add(new CategoriesList("برنامه ها ", programsList));
//
//        return list;
//    }


}
