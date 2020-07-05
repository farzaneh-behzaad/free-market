package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RatesOverview {


    @SerializedName("title")
    private String title;
    @SerializedName("link")
    private String link;
    @SerializedName("rateAverage")
    private String rateAverage;
    @SerializedName("rateCount")
    private String rateCount;
    @SerializedName("RatesOverviewSections")
    private ArrayList<RatesOverviewSection> ratesOverviewSections;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getRateAverage() {
        return rateAverage;
    }

    public String getRateCount() {
        return rateCount;
    }

    public ArrayList<RatesOverviewSection> getRatesOverviewSections() {
        return ratesOverviewSections;
    }

    public static class RatesOverviewSection {

        @SerializedName("title")
        private String title;
        @SerializedName("percent")
        private int percent;

        public String getTitle() {
            return title;
        }

        public int getPercent() {
            return percent;
        }
    }
}
