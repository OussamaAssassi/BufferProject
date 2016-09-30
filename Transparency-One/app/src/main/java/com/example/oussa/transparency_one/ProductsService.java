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
        products.add(new Product("Rice",  R.drawable.primary_icon));
        products.add(new Product("Marshmallows", R.drawable.manufacturing_icon));
        products.add(new Product("Yogurt Cherry", R.drawable.distribution_icon));
        products.add(new Product("Milk", R.drawable.primary_icon));
        products.add(new Product("Lakewood Drink", R.drawable.manufacturing_icon));
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
