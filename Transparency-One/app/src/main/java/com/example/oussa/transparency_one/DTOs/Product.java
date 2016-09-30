package com.example.oussa.transparency_one.DTOs;

/**
 * Created by Simon.Budin on 29/09/2016.
 */

public class Product {

    public Product(String productName, int picture) {
        this.name = productName;
        this.picture = picture;
    }


    public Product(String productName, String supplierName, int picture) {
        this.name = productName;
        this.supplierName = supplierName;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    private String name;
    private String supplierName;
    private int picture;
}
