package com.company.chatterbook.modules;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<ChatterPost> chatterPosts = new ArrayList<>();

    public User(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setChatterPosts(List<ChatterPost> arr){
        chatterPosts.addAll(arr);
    }

    public List<ChatterPost> getChatterPosts(){
        return this.chatterPosts;
    }
}
