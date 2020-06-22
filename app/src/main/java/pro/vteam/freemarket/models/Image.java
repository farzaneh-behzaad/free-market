package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class Image {


    @SerializedName("path")
    private String path;


    @SerializedName("ratio")
    private Ratio ratio;


    public String getPath() {
        return path;
    }

    public Ratio getRatio() {
        return ratio;
    }
}
