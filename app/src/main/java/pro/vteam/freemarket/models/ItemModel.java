package pro.vteam.freemarket.models;

public class ItemModel {

    BannerListModel bannerListModel;
    AppListModel appListModel;
    int viewType;


    public ItemModel(BannerListModel bannerListModel, int viewType) {
        this.bannerListModel = bannerListModel;
        this.viewType = viewType;
    }

    public ItemModel(AppListModel appListModel, int viewType) {
        this.appListModel = appListModel;
        this.viewType = viewType;
    }


    public BannerListModel getBannerListModel() {
        return bannerListModel;
    }

    public AppListModel getAppListModel() {
        return appListModel;
    }


    public int getViewType() {
        return viewType;
    }


}
