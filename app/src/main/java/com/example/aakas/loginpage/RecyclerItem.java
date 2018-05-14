package com.example.aakas.loginpage;


public class RecyclerItem {
    private String title;
    private String location;
    private String image;

    public RecyclerItem(String title, String description) {
        this.title = title;
        this.location = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return location;
    }

    public void setDescription(String description) {
        this.location = location;
    }

    /*public String getImage() {
        return image;
    }

    public void setImage() {
        this.image = image;
    }*/
}

