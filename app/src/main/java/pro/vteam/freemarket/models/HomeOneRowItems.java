package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HomeOneRowItems {

        @SerializedName("title")
        private String title;
        @SerializedName("inlineAction")
        private HomeInlineAction homeInlineAction;
        @SerializedName("items")
        private ArrayList<HomeItem> items;


        public String getTitle() {
            return title;
        }

        public HomeInlineAction getHomeInlineAction() {
            return homeInlineAction;
        }

        public ArrayList<HomeItem> getItems() {
            return items;
        }
    }

