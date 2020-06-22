package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HomeLinkVerticalCollection {

    @SerializedName("title")
    private String title;
    @SerializedName("maxCount")
    private int maxCount;
    @SerializedName("inlineAction")
    private HomeInlineAction homeInlineAction;
    @SerializedName("divider")
    private HomeDivider homeDivider;
    @SerializedName("links")
    private ArrayList<HomeLink> links;


    public String getTitle() {
        return title;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public HomeInlineAction getHomeInlineAction() {
        return homeInlineAction;
    }

    public HomeDivider getHomeDivider() {
        return homeDivider;
    }

    public ArrayList<HomeLink> getLinks() {
        return links;
    }
}

