package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class HomeInlineAction {


    @SerializedName("title")
    private String title;
    @SerializedName("link")
    private String link;


    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
