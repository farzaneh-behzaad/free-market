package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class Link {


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
}
