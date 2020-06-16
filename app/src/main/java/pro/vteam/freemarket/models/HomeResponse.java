package pro.vteam.freemarket.models;


import com.google.gson.annotations.SerializedName;


public class HomeResponse {


    @SerializedName("result")
    private HomeResult homeResult;
    @SerializedName("error")
    private int error;
    @SerializedName("statusCode")
    private  int statusCode;
    @SerializedName("serverDateTime")
    private String serverDateTime;


    public HomeResult getHomeResult() {
        return homeResult;
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
