package pro.vteam.freemarket.oldModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class CategoriesTabListModel {

    @SerializedName("title")
    private String title;

    @SerializedName("items")
    private ArrayList<CategoriesItemModel> itemsList;

    public CategoriesTabListModel(String title, ArrayList<CategoriesItemModel> itemsList) {
        this.title = title;
        this.itemsList = itemsList;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<CategoriesItemModel> getItemsList() {
        return itemsList;
    }
}
