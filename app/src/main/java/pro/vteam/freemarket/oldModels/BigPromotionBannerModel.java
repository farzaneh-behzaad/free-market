package pro.vteam.freemarket.oldModels;

public class BigPromotionBannerModel {

    private String promotion_banner_url;
    private String promotion_icon_url;
    private String txt_name;

    public BigPromotionBannerModel(String promotion_banner_url, String promotion_icon_url, String txt_name) {
        this.promotion_banner_url = promotion_banner_url;
        this.promotion_icon_url = promotion_icon_url;
        this.txt_name = txt_name;
    }

    public String getPromotion_banner_url() {
        return promotion_banner_url;
    }

    public String getPromotion_icon_url() {
        return promotion_icon_url;
    }

    public String getTxt_name() {
        return txt_name;
    }
}
