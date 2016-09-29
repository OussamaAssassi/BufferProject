package com.example.oussa.transparency_one;

import java.util.Date;

public class Notification {

    private String productName;
    private String supplierName;
    private Date creationDate;
    private int picture;

    public Notification(String productName, String supplierName, Date creationDate, int pictureId) {
        this.productName = productName;
        this.supplierName = supplierName;
        this.creationDate = creationDate;
        this.picture = pictureId;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
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
