package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LinkVerticalCollection {

    @SerializedName("title")
    private String title;
    @SerializedName("maxCount")
    private int maxCount;
    @SerializedName("inlineAction")
    private InlineAction inlineAction;
    @SerializedName("divider")
    private Divider Divider;
    @SerializedName("links")
    private ArrayList<Link> links;


    public String getTitle() {
        return title;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public InlineAction getInlineAction() {
        return inlineAction;
    }

    public Divider getDivider() {
        return Divider;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }
}

