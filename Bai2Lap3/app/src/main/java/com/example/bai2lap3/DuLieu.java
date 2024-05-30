package com.example.bai2lap3;

import java.io.Serializable;

public class DuLieu implements Serializable {
    int image;
    String name;
    String price;


    public DuLieu(int image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;

    }

    public DuLieu() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "DuLieu{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
