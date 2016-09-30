package com.example.oussa.transparency_one.DTOs;

/**
 * Created by Simon.Budin on 29/09/2016.
 */

public class Product {

    public Product(String productName, int picture) {
        this.name = productName;
        this.picture = picture;
    }

    public Product(String productName, int picture, int statusPicture) {
        this.name = productName;
        this.picture = picture;
        this.statusPicture = statusPicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }


    public int getStatusPicture() {
        return statusPicture;
    }

    public void setStatusPicture(int statusPicture) {
        this.statusPicture = statusPicture;
    }

    private String name;
    private int picture;
    private int statusPicture;
}
