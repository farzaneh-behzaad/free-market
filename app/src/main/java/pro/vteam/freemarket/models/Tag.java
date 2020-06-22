package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class Tag {


    @SerializedName("title")
    private String title;
    @SerializedName("backgroundColor")
    private String backgroundColor;
    @SerializedName("textColor")
    private String textColor;


    public String getTitle() {
        return title;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }
}
