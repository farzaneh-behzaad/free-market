package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

public class Response {


    @SerializedName("result")
    private Result result;

    @SerializedName("error")
    private int error;

    @SerializedName("statusCode")
    private int statusCode;

    @SerializedName("serverDateTime")
    private String serverDateTime;

    public Result getResult() {
        return result;
    }
}
