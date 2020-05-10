package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {

    @SerializedName("page")
    private int page;

    @SerializedName("pagerSize")
    private int pagerSize;

    @SerializedName("actualPageSize")
    private int actualPageSize;

    @SerializedName("totalSize")
    private int totalSize;

    @SerializedName("totalPage")
    private int totalPage;


    private @SerializedName("data")
    ArrayList<CategoriesList> categoriesLists;

    public ArrayList<CategoriesList> getCategoriesLists() {
        return categoriesLists;
    }

}


