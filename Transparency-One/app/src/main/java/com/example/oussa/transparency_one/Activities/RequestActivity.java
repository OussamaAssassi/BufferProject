package com.example.oussa.transparency_one.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.oussa.transparency_one.DTOs.Product;
import com.example.oussa.transparency_one.DTOs.ProductsListAdapter;
import com.example.oussa.transparency_one.ProductsService;
import com.example.oussa.transparency_one.R;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity {

    ListView mListView;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_detail);

        getSupportActionBar().setTitle("Visibility request answer (1/2)");

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        ListView productsListView = (ListView) findViewById(R.id.productsListView);

        productsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(RequestActivity.this, VisibilityActivity.class);
                RequestActivity.this.startActivity(myIntent);
            }
        });
        ProductsService productsService = new ProductsService();
        List<Product> productsAvailable = productsService.getProductsAvailable();

        productsListView.setAdapter(new ProductsListAdapter(RequestActivity.this, productsAvailable));
        TextView productNameTextView = (TextView) findViewById(R.id.productName);
        productNameTextView.setText(intent.getStringExtra("requestedProductName"));
        TextView supplierNameTextView = (TextView) findViewById(R.id.customerName);
        supplierNameTextView.setText(intent.getStringExtra("companyName"));
        TextView creationDateTextView = (TextView) findViewById(R.id.creationDate);
        creationDateTextView.setText(intent.getStringExtra("date"));
    }
}
