package pro.vteam.freemarket.models;

public class ItemModel {

    BannerListModel bannerListModel;
    AppListModel appListModel;
    BigPromotionBannerModel bigPromotionBannerModel;
    int viewType;


    public ItemModel(BannerListModel bannerListModel, int viewType) {
        this.bannerListModel = bannerListModel;
        this.viewType = viewType;
    }

    public ItemModel(AppListModel appListModel, int viewType) {
        this.appListModel = appListModel;
        this.viewType = viewType;
    }


    public ItemModel(BigPromotionBannerModel bigPromotionBannerModel, int viewType) {
        this.bigPromotionBannerModel = bigPromotionBannerModel;
        this.viewType = viewType;
    }

    public BigPromotionBannerModel getBigPromotionBannerModel() {
        return bigPromotionBannerModel;
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
