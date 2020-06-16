package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HomeOneRowBanners {


         @SerializedName("title")
         private String title;
         @SerializedName("inlineAction")
         private HomeInlineAction homeInlineAction;

        @SerializedName("banners")
        private ArrayList<HomeBanner> banners;


        public String getTitle() {
            return title;
        }

        public HomeInlineAction getHomeInlineAction() {
            return homeInlineAction;
        }

        public ArrayList<HomeBanner> getBanners() {
            return banners;
        }
    }
