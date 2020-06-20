package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class Ratio {

    @SerializedName("dimension")
    private String dimensionRatio;

    @SerializedName("type")
    private String type;

    @SerializedName("constraintDimensionRatio")
    private String constraintDimensionRatio;

    public String getConstraintDimensionRatio() {
        return constraintDimensionRatio;
    }

    public String getDimensionRatio() {
        return dimensionRatio;
    }


    public String getType() {
        return type;
    }
}
