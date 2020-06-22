package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class Banner {
    @SerializedName("image")
    private Image image;
    @SerializedName("link")
    private String link;
    @SerializedName("tag")
    private Tag tag;

    public Image getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    public Tag getTag() {
        return tag;
    }
}
