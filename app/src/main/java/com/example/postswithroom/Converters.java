package com.example.postswithroom;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class Converters {

    @TypeConverter
    public String fromUserToGson(User user){
        return new Gson().toJson(user);
    }

    @TypeConverter
    public User fromGsonToUser(String stringUser){
        return new Gson().fromJson(stringUser, User.class);
    }
}
