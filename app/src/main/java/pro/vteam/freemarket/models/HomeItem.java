package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class HomeItem {


    @SerializedName("link")
    private String link;
    @SerializedName("icon")
    private HomeIcon homeIcon;
    @SerializedName("title")
    private String title;
    @SerializedName("price")
    private String price;
    @SerializedName("tag")
    private String tag;

    public String getLink() {
        return link;
    }

    public HomeIcon getHomeIcon() {
        return homeIcon;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getTag() {
        return tag;
    }
}
