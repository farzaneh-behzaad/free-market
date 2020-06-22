package pro.vteam.freemarket.oldModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import pro.vteam.freemarket.oldModels.CategoriesTabListModel;


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
    ArrayList<CategoriesTabListModel> categoriesLists;

    public ArrayList<CategoriesTabListModel> getCategoriesLists() {
        return categoriesLists;
    }

}


