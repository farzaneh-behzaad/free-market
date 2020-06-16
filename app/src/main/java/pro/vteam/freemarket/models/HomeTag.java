package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class HomeTag {


    @SerializedName("title")
    private String title;
    @SerializedName("backgroundColor")
    private String backgroundColor;


    public String getTitle() {
        return title;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }
}
