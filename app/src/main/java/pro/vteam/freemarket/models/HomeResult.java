package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HomeResult {


    @SerializedName("hasNext")
    private boolean hasNext;

    @SerializedName("page")
    private HomePage homePage;


    public boolean isHasNext() {
        return hasNext;
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
