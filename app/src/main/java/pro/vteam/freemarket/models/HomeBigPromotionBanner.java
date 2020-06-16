package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

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
    }

