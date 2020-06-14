package pro.vteam.freemarket.models;

import java.util.ArrayList;

public class AppListModel {

    private String title;
    private ArrayList<AppsModel> appList;
    private int viewType;


    public AppListModel(ArrayList<AppsModel> appList, String title) {
        this.title=title;
        this.appList = appList;

    }

    public String getTitle() {
        return title;
    }

    public ArrayList<AppsModel> getAppList() {
        return appList;
    }

}
