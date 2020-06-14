package pro.vteam.freemarket.models;

import java.util.ArrayList;

public class BannerListModel {

    private String title;
    private ArrayList<BannerModel> bannerList;



    public BannerListModel(ArrayList<BannerModel> bannerList, String title) {
        this.title=title;
        this.bannerList = bannerList;


    }

    public String getTitle() {
        return title;
    }

    public ArrayList<BannerModel> getBannerList() {
        return bannerList;
    }

}
