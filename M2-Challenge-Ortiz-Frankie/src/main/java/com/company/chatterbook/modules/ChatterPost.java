package com.company.chatterbook.modules;

public class ChatterPost {

    private String text;

    public ChatterPost(String text){
        setText(text);
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
