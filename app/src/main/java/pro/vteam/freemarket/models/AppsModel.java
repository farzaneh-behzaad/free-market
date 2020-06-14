package pro.vteam.freemarket.models;

public class AppsModel {
   private String imgAppUrl;
   private String  appName;
   private String txtExtra;

    public AppsModel(String imgAppUrl, String appName, String txtExtra) {
        this.imgAppUrl = imgAppUrl;
        this.appName = appName;
        this.txtExtra = txtExtra;
    }

    public String getImgAppUrl() {
        return imgAppUrl;
    }

    public String getAppName() {
        return appName;
    }

    public String getTxtExtra() {
        return txtExtra;
    }

}
