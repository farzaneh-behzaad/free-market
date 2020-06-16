package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class Ratio {

    @SerializedName("scale")
    private String scale;

    @SerializedName("type")
    private String type;

    public String getScale() {
        return scale;
    }

    public String getType() {
        return type;
    }
}
