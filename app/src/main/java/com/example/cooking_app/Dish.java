package com.example.cooking_app;

public class Dish {
    private int id;
    private String name;
    private String image;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish(String time, String name, String image, int id) {
        this.name = name;
        this.image = image;
        this.time = time;
        this.id = id;
    }

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
