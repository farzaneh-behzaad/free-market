package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class HomeBanner {
    @SerializedName("image")
    private HomeImage homeImage;
    @SerializedName("link")
    private String link;
    @SerializedName("tag")
    private HomeTag homeTag;

    public HomeImage getHomeImage() {
        return homeImage;
    }

    public String getLink() {
        return link;
    }

    public HomeTag getHomeTag() {
        return homeTag;
    }
}
