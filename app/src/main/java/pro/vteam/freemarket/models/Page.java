package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Page {


    @SerializedName("name")
    private String name;

    @SerializedName("version")
    private String version;

    @SerializedName("components")
    private ArrayList<Component> components;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }
}
