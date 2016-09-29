package com.example.oussa.transparency_one;

import java.util.Date;

public class Notification {
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

    public String getPicture() {
        return picture;
    }

    private String productName;
    private String supplierName;
    private Date creationDate;
    private String picture;

    public Notification(String productName, String supplierName) {
        this.productName = sourceName;
        this.supplierName = supplierName;

    }
}
