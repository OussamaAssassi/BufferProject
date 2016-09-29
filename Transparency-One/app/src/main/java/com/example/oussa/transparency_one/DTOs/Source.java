package com.example.oussa.transparency_one.DTOs;

/**
 * Created by oussa on 28/09/2016.
 */

public class Source {
    private String sourceName;
    private String supplierName;

    public Source(String sourceName, String supplierName) {
        this.sourceName = sourceName;
        this.supplierName = supplierName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setPseudo(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setText(String supplierName) {
        this.supplierName = supplierName;
    }
}
