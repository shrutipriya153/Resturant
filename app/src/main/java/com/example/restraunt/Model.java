package com.example.restraunt;

public class Model {
    private String image;
    private String name;
    private String price;

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Model(String image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }
}
