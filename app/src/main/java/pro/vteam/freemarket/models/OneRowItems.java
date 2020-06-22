package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OneRowItems {

        @SerializedName("title")
        private String title;
        @SerializedName("inlineAction")
        private InlineAction inlineAction;

        @SerializedName("items")
        private ArrayList<Item> items;


        public String getTitle() {
            return title;
        }

        public InlineAction getInlineAction() {
            return inlineAction;
        }

        public ArrayList<Item> getItems() {
        return items;
    }
}

