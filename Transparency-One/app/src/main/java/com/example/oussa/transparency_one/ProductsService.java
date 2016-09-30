package com.example.oussa.transparency_one;

import com.example.oussa.transparency_one.DTOs.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon.Budin on 30/09/2016.
 */

public class ProductsService {
    public List<Product> getProductsAvailable()
    {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Own Paella",  R.drawable.primary_icon));
        products.add(new Product("Own  Marshmallows", R.drawable.manufacturing_icon));
        products.add(new Product("Own Yogurt Cherry", R.drawable.distribution_icon));
        products.add(new Product("Own Mayan Drink", R.drawable.primary_icon));
        products.add(new Product("Own Lakewood Drink", R.drawable.manufacturing_icon));
        return products;
    }

    public List<Product> getProblematicProducts()
    {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Hoodies", R.drawable.distribution_icon));
        products.add(new Product("Mushrooms", R.drawable.manufacturing_icon));
        return products;
    }
}
