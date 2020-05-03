package pro.vteam.freemarket.models;

import java.util.ArrayList;

public class CategoriesListModel {


    private String title;
    private ArrayList<CategoriesItemsModel> listItems;

    public CategoriesListModel(String title, ArrayList<CategoriesItemsModel> listItems) {
        this.title = title;
        this.listItems = listItems;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<CategoriesItemsModel> getListItems() {
        return listItems;
    }
}
