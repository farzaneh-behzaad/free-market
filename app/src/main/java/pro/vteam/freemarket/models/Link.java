package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("title")
    private String title;

    @SerializedName("icon")
    private Icon icon;

    @SerializedName("link")
   private String link;

    public Icon getIcon() {
        return icon;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }
}
