package com.example.oussa.transparency_one.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.oussa.transparency_one.Adapters.ProductsListAdapter;
import com.example.oussa.transparency_one.DTOs.Notification;
import com.example.oussa.transparency_one.DTOs.Product;
import com.example.oussa.transparency_one.NotificationsService;
import com.example.oussa.transparency_one.ProductsService;
import com.example.oussa.transparency_one.R;

import java.util.List;

public class RequestActivity extends AppCompatActivity {

    ListView mListView;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_detail);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Visibility request answer - Step 1");

        Intent intent = getIntent();

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

        NotificationsService notificationService = new NotificationsService(RequestActivity.this.getApplicationContext());
        List<Notification> notifs = notificationService.getReceivedNotifications();
        int notificationPosition = Integer.parseInt(intent.getStringExtra("notificationPosition"));
        Notification notification = notifs.get(notificationPosition);

        notificationService.fulFilReceivedNotification(notificationPosition);
        TextView productNameTextView = (TextView) findViewById(R.id.productName);
        productNameTextView.setText(notification.getProductName());
        TextView supplierNameTextView = (TextView) findViewById(R.id.customerName);
        supplierNameTextView.setText(notification.getSupplierName());
        TextView creationDateTextView = (TextView) findViewById(R.id.creationDate);
        creationDateTextView.setText(notification.getCreationDate());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
