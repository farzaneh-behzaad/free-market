package pro.vteam.freemarket.models;

public class CategoriesItemsModel {
   private String txt_subject;
  private String iconUrl;

  public CategoriesItemsModel(String subject, String iconUrl){
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
