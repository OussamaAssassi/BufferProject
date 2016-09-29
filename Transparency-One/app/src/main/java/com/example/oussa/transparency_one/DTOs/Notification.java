package com.example.oussa.transparency_one.DTOs;

public class Notification {

    private String productName;
    private String supplierName;
    private String creationDate;
    private int picture;

    public Notification(String productName, String supplierName, String creationDate, int pictureId) {
        this.productName = productName;
        this.supplierName = supplierName;
        this.creationDate = creationDate;
        this.picture = pictureId;
    }

    public Notification(String productName, String supplierName, String creationDate) {
        this.productName = productName;
        this.supplierName = supplierName;
        this.creationDate = creationDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getSupplierName() {
        return supplierName;
    }
}
