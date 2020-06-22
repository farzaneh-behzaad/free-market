package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OneRowBanners {


         @SerializedName("title")
         private String title;
         @SerializedName("inlineAction")
         private InlineAction inlineAction;

        @SerializedName("banners")
        private ArrayList<Banner> banners;


        public String getTitle() {
            return title;
        }

        public InlineAction getInlineAction() {
            return inlineAction;
        }

        public ArrayList<Banner> getBanners() {
            return banners;
        }
    }
