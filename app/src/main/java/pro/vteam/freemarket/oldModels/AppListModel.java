package pro.vteam.freemarket.oldModels;

import java.util.ArrayList;

public class AppListModel {

    private String title;
    private ArrayList<AppModel> appList;
    private int viewType;


    public AppListModel(ArrayList<AppModel> appList, String title) {
        this.title=title;
        this.appList = appList;

    }

    public String getTitle() {
        return title;
    }

    public ArrayList<AppModel> getAppList() {
        return appList;
    }

}
