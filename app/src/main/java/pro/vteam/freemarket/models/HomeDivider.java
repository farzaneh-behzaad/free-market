package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class HomeDivider {


    @SerializedName("color")
    private String color;

    @SerializedName("margin")
    private HomeMargin homeMargin;

    public String getColor() {
        return color;
    }

    public HomeMargin getHomeMargin() {
        return homeMargin;
    }

    public  class HomeMargin{

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

    public class  LeftMargin{

        @SerializedName("quantity")
        private int quantity;

        @SerializedName("type")
        private int type;

        public int getQuantity() {
            return quantity;
        }

        public int getType() {
            return type;
        }
    }

    public class  RightMargin{

        @SerializedName("quantity")
        private int quantity;

        @SerializedName("type")
        private int type;

        public int getQuantity() {
            return quantity;
        }

        public int getType() {
            return type;
        }

    }
}
