package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class

HomeBigPromotionBanner {

        @SerializedName("image")
        private HomeImage homeImage;
        @SerializedName("item")
        private HomeItem homeItem;
        @SerializedName("inlineAction")
        private  HomeInlineAction homeInlineAction;
        @SerializedName("tag")
        private HomeTag homeTag;

        @SerializedName("actionbar")
        private HomeActionbar homeActionbar;

        public HomeImage getHomeImage() {
            return homeImage;
        }

        public HomeItem getHomeItem() {
            return homeItem;
        }

        public HomeInlineAction getHomeInlineAction() {
            return homeInlineAction;
        }

        public HomeTag getHomeTag() {
            return homeTag;
        }

        public HomeActionbar getHomeActionbar() {
        return homeActionbar;
    }
}

