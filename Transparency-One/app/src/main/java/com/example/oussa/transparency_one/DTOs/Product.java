package com.example.oussa.transparency_one.DTOs;

/**
 * Created by Simon.Budin on 29/09/2016.
 */

public class Product {

    public Product(String productName) {
        this.name = productName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
