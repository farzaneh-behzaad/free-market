package pro.vteam.freemarket.oldModels;

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

    public int getError() {
        return error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getServerDateTime() {
        return serverDateTime;
    }
}
