package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class Item {


    @SerializedName("link")
    private String link;
    @SerializedName("icon")
    private Icon icon;
    @SerializedName("title")
    private String title;
    @SerializedName("price")
    private String price;
    @SerializedName("tag")
    private Tag tag;

    public String getLink() {
        return link;
    }

    public Icon getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public Tag getTag() {
        return tag;
    }
}
