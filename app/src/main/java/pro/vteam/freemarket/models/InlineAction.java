package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class InlineAction {


    @SerializedName("title")
    private String title;
    @SerializedName("link")
    private String link;

    @SerializedName("backgroundColor")
    private String backgroundColor;

    @SerializedName("textColor")
    private String textColor;



    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }
}
