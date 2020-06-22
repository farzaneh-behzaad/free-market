package pro.vteam.freemarket.ui.video;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pro.vteam.freemarket.oldModels.AppModel;
import pro.vteam.freemarket.oldModels.BannerListModel;
import pro.vteam.freemarket.oldModels.BannerModel;
import pro.vteam.freemarket.oldModels.AppListModel;
import pro.vteam.freemarket.oldModels.BigPromotionBannerModel;
import pro.vteam.freemarket.oldModels.ItemModel;

public class VideoViewModel extends ViewModel {

    MutableLiveData<ArrayList<ItemModel>> list = new MutableLiveData<>();


    public VideoViewModel() {
        modifyData();

    }


    public MutableLiveData<ArrayList<ItemModel>> getList() {
        return list;

    }


    public void modifyData() {

        ArrayList<AppModel> appList = new ArrayList<>();
        appList.add(new AppModel("@drawable/ic_android_black_24dp", "نام اپلیکیشن", "رایگان"));
        appList.add(new AppModel("@drawable/ic_android_black_24dp", "نام اپلیکیشن", "رایگان"));
        appList.add(new AppModel("@drawable/ic_android_black_24dp", "نام اپلیکیشن", "رایگان"));
        appList.add(new AppModel("@drawable/ic_android_black_24dp", "نام اپلیکیشن", "رایگان"));
        appList.add(new AppModel("@drawable/ic_android_black_24dp", "نام اپلیکیشن", "رایگان"));

        ArrayList<BannerModel> bannerList = new ArrayList<>();
        bannerList.add(new BannerModel("@drawable/img"));
        bannerList.add(new BannerModel("@drawable/img"));
        bannerList.add(new BannerModel("@drawable/img"));
        bannerList.add(new BannerModel("@drawable/img"));
        bannerList.add(new BannerModel("@drawable/img"));



        ArrayList<ItemModel> itemModels = new ArrayList<>();
        itemModels.add(new ItemModel(new BigPromotionBannerModel("@drawable/promotion","@drawable/p1","بازی های پیشنهادی برای شما بروز شده است"),2));
        itemModels.add(new ItemModel(new AppListModel(appList, "بازی های پیشنهادی برای شما"), 1));
        itemModels.add(new ItemModel(new BannerListModel(bannerList, "بازی های پیشنهادی برای شما"), 0));
        itemModels.add(new ItemModel(new AppListModel(appList, "بازی های پیشنهادی برای شما"), 1));
        itemModels.add(new ItemModel(new BannerListModel(bannerList, "بازی های پیشنهادی برای شما"), 0));
        itemModels.add(new ItemModel(new AppListModel(appList, "بازی های پیشنهادی برای شما"), 1));
        itemModels.add(new ItemModel(new BannerListModel(bannerList, "بازی های پیشنهادی برای شما"), 0));
        itemModels.add(new ItemModel(new AppListModel(appList, "بازی های پیشنهادی برای شما"), 1));



        list.setValue(itemModels);


    }

}