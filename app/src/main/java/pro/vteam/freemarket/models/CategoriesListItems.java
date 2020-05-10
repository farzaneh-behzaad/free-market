package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class CategoriesListItems {
    @SerializedName("title")
    private String txt_subject;
    @SerializedName("icon")
    private String iconUrl;

  public CategoriesListItems(String subject, String iconUrl){
      this.txt_subject=subject;
      this.iconUrl=iconUrl;
  }

    public String getTxt_subject() {
        return txt_subject;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}
