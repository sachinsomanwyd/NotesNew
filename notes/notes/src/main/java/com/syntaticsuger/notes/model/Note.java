package com.syntaticsuger.notes.model;

public class Note {
    private int id;
    private String Title;
    private String description;
    public String getTitle(){
        return Title;
    }
    public String getDescription(){
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
