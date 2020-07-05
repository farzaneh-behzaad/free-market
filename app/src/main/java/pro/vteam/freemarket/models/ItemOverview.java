package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ItemOverview {
    @SerializedName("itemOverviewSections")
    ArrayList<ItemOverviewSection> itemOverviewSections;

    public ArrayList<ItemOverviewSection> getItemOverviewSections() {
        return itemOverviewSections;
    }

    public class ItemOverviewSection {


        @SerializedName("title")
        private String title;
        @SerializedName("subTitle")
        private String subTitle;
        @SerializedName("link")
        private String link;

        public String getTitle() {
            return title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public String getLink() {
            return link;
        }
    }
}
