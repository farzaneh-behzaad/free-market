package pro.vteam.freemarket.models;

import java.util.ArrayList;

public class ApplicationTypesModel {

   private String appsType;
  private   ArrayList<AppModel> appsList;

    public String getAppsType() {
        return appsType;
    }

    public void setAppsType(String appsType) {
        this.appsType = appsType;
    }

    public ArrayList<AppModel> getAppsList() {
        return appsList;
    }

    public void setAppsList(ArrayList<AppModel> appsList) {
        this.appsList = appsList;
    }
}
