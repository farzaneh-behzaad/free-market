package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Component {

    @SerializedName("type")
    private String type;

    @SerializedName("data")
    private Object object;

    @SerializedName("____comments")
    private ArrayList<String> ____comments;

    public String getType() {
        return type;
    }

    public Object getObject() {
        return object;
    }

    public ArrayList<String> get____comments() {
        return ____comments;
    }
}
