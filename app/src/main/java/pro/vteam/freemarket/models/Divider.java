package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class Divider {


    @SerializedName("color")
    private String color;

    @SerializedName("margin")
    private Margin margin;

    public String getColor() {
        return color;
    }

    public Margin getMargin() {
        return margin;
    }

    public static class Margin{

        @SerializedName("leftMargin")
        private LeftMargin leftMargin;

        @SerializedName("rightMargin")
        private RightMargin rightMargin;

        public LeftMargin getLeftMargin() {
            return leftMargin;
        }

        public RightMargin getRightMargin() {
            return rightMargin;
        }
    }

    public static class  LeftMargin{

        @SerializedName("quantity")
        private int quantity;

        @SerializedName("type")
        private String type;

        public int getQuantity() {
            return quantity;
        }

        public String getType() {
            return type;
        }
    }

    public static class  RightMargin{

        @SerializedName("quantity")
        private int quantity;

        @SerializedName("type")
        private String type;

        public int getQuantity() {
            return quantity;
        }

        public String getType() {
            return type;
        }

    }
}
