package com.example.catkingdom.model;

public class Book {

    int id;
    String Title;
    String ImageUrl;

    public Book(int id, String title, String imageUrl) {
        this.id = id;
        Title = title;
        ImageUrl = imageUrl;
    }

    public Book(String title, String imageUrl) {
        Title = title;
        ImageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
