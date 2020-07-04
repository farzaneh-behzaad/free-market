package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class ItemHeader {
    @SerializedName("item")
    private Item item;

    @SerializedName("company")
    private Company company;

    @SerializedName("inlineAction")
    private InlineAction inlineAction;

    @SerializedName("image")
    private Image image;




    public Item getItem() {
        return item;
    }

    public Company getCompany() {
        return company;
    }

    public InlineAction getInlineAction() {
        return inlineAction;
    }

    public Image getImage() {
        return image;
    }


    public class Company {

        @SerializedName("title")
        private String title;


        @SerializedName("link")
        private String link;

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }
    }


}
