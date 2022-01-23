package com.example.catkingdom.model;

public class Tip {

    private int id;
    private String title;
    private String publishDate;

    public Tip(String title, String publishDate) {
        this.title = title;
        this.publishDate = publishDate;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
