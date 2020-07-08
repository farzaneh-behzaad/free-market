package pro.vteam.freemarket.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CommentVerticalCollection {

    @SerializedName("Comments")
    private ArrayList<Comment> comments;


    public ArrayList<Comment> getComments() {
        return comments;
    }

    public static class Comment {

        @SerializedName("user")
        private User user;
        @SerializedName("datetime")
        private String datetime;
        @SerializedName("ratePercent")
        private int ratePercent;
        @SerializedName("body")
        private String body;


        public User getUser() {
            return user;
        }

        public String getDatetime() {
            return datetime;
        }

        public int getRatePercent() {
            return ratePercent;
        }

        public String getBody() {
            return body;
        }
    }


    public static class User {

        @SerializedName("name")
        private String name;

        @SerializedName("profileImage")
        private String profileImage;

        public String getName() {
            return name;
        }

        public String getProfileImage() {
            return profileImage;
        }
    }
}
