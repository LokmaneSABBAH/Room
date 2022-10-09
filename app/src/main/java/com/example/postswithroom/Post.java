package com.example.postswithroom;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts_table")
public class Post {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private User user;
    private String title;
    private String body;

    public Post(User user, String title, String body) {
        this.user = user;
        this.title = title;
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public User getUser() {
        return user;
    }
}
