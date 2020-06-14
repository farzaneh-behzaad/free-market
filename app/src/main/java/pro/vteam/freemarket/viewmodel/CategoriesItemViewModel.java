package pro.vteam.freemarket.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pro.vteam.freemarket.models.AppListModel;
import pro.vteam.freemarket.models.AppModel;
import pro.vteam.freemarket.models.ItemModel;

public class CategoriesItemViewModel extends ViewModel {

    MutableLiveData<ArrayList<ItemModel>> items;


    public CategoriesItemViewModel(){

        items=new MutableLiveData<>();
        items.setValue(modifyAppsList());
    }

    public MutableLiveData<ArrayList<ItemModel>> getAppsList() {
        return items;
    }

    private ArrayList<ItemModel> modifyAppsList(){

        ArrayList<AppModel> appList=new ArrayList<>();
            for (int i=0;i<=10;i++){
                AppModel app = new AppModel("R.drawable.ic_android_black_24dp", "اپلیکیشن"+i ,"رایگان");
                appList.add(app);
            }


        ArrayList<ItemModel> itemModels = new ArrayList<>();
        itemModels.add(new ItemModel(new AppListModel(appList, "بازی های پیشنهادی برای شما ۱"), 1));
        itemModels.add(new ItemModel(new AppListModel(appList, "بازی های پیشنهادی برای شما ۲"), 1));
        itemModels.add(new ItemModel(new AppListModel(appList, "بازی های پیشنهادی برای شما ۳"), 1));
        itemModels.add(new ItemModel(new AppListModel(appList, "بازی های پیشنهادی برای شما ۴"), 1));
        itemModels.add(new ItemModel(new AppListModel(appList, "بازی های پیشنهادی برای شما ۵"), 1));

            return itemModels;

    }
}
