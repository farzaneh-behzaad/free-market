package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class HomeLink {


    @SerializedName("icon")
    private HomeIcon homeIcon;

    @SerializedName("link")
   private String link;

    public HomeIcon getHomeIcon() {
        return homeIcon;
    }

    public String getLink() {
        return link;
    }
}
