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
        products.add(new Product("Own Paella"));
        products.add(new Product("Own  Marshmallows"));
        products.add(new Product("Own Yogurt Cherry"));
        products.add(new Product("Own Mayan Drink"));
        products.add(new Product("Own Lakewood Drink"));
        return products;
    }

    public List<Product> getProblematicProducts()
    {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Paella"));
        products.add(new Product("Mushrooms"));
        return products;
    }
}
