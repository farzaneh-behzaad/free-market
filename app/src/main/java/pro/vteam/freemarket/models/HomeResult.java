package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class HomeResult {


    @SerializedName("hasNext")
    private boolean hasNext;

    @SerializedName("page")
    private Page page;


    public boolean isHasNext() {
        return hasNext;
    }

    public Page getPage() {
        return page;
    }
}
