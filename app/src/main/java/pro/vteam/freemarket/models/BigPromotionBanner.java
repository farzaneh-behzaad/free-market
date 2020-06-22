package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class BigPromotionBanner {

        @SerializedName("image")
        private Image image;
        @SerializedName("item")
        private Item item;
        @SerializedName("inlineAction")
        private InlineAction inlineAction;
        @SerializedName("tag")
        private Tag tag;

        @SerializedName("actionbar")
        private BigPromotionBannerActionbar bigPromotionBannerActionbar;

        public Image getImage() {
            return image;
        }

        public Item getItem() {
            return item;
        }

        public InlineAction getInlineAction() {
            return inlineAction;
        }

        public Tag getTag() {
            return tag;
        }

        public BigPromotionBannerActionbar getBigPromotionBannerActionbar() {
        return bigPromotionBannerActionbar;
    }
}

