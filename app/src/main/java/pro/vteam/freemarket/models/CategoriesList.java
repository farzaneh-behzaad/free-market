package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class CategoriesList {

    @SerializedName("title")
    private String title;

    @SerializedName("items")
    private ArrayList<CategoriesListItems> listItems;

    public CategoriesList(String title, ArrayList<CategoriesListItems> listItems) {
        this.title = title;
        this.listItems = listItems;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<CategoriesListItems> getListItems() {
        return listItems;
    }
}
