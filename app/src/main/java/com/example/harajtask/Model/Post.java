package com.example.harajtask.Model;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {

    private String title, username, thumbURL, city, body, phone;
    private int commentCount;
    private long date;
    private static final String DEF_PHONE = "+966500100100";

    public Post(String title, String username, String thumbURL, String city, String body, int commentCount, long date) {
        this.title = title;
        this.username = username;
        this.thumbURL = thumbURL;
        this.city = city;
        this.body = body;
        this.commentCount = commentCount;
        this.date = date;
        this.phone = DEF_PHONE;
    }

    public Post() {
        this.phone = DEF_PHONE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getThumbURL() {
        return thumbURL;
    }

    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
