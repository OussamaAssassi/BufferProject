package com.example.oussa.transparency_one.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.oussa.transparency_one.DTOs.Notification;
import com.example.oussa.transparency_one.DTOs.Product;
import com.example.oussa.transparency_one.Adapters.ProductsListAdapter;
import com.example.oussa.transparency_one.Adapters.ReceivedNotificationAdapter;
import com.example.oussa.transparency_one.Adapters.SentNotificationAdapter;
import com.example.oussa.transparency_one.NotificationsService;
import com.example.oussa.transparency_one.ProductsService;
import com.example.oussa.transparency_one.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    TabHost tabHost;
    ReceivedNotificationAdapter  receivedNotificationAdapter;
    SentNotificationAdapter sentNotificationAdapter;
    List<Notification> receivedNotifications;
    List<Notification> sentNotifications;

    NotificationsService notificationsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("My requests");

        tabHost = (TabHost) findViewById(R.id.tabhost);
        //Important
        tabHost.setVisibility(TabHost.VISIBLE);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("received");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("sent");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("updates");

        tab1.setIndicator("Received");
        tab1.setContent(R.id.i_layout_1);

        tab2.setIndicator("Sent");
        tab2.setContent(R.id.i_layout_2);

        tab3.setIndicator("Updates");
        tab3.setContent(R.id.i_layout_3);

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);

        tabHost.setCurrentTab(0);
        loadTab("received");

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(String tabId) {
                loadTab(tabId);
            }});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.send_reminder:
                // User chose the "Settings" item, show the app settings UI...
                ListView listView = (ListView) tabHost.getCurrentView().findViewById(R.id.listView);
                for (int i = 0; i < sentNotificationAdapter.getCount(); i++) {
                    if(sentNotificationAdapter.checkedHolder[i]){
                        sentNotifications.get(i).setCreationDate("just now");
                        sentNotificationAdapter.checkedHolder[i] = false;
                    }
                }
                sentNotificationAdapter.notifyDataSetChanged();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    private void loadTab(String tabId)
    {
        switch (tabId)
        {
            case "received":
                loadReceivedRequests();
                break;
            case "sent":
                loadSentRequests();
                break;
            case "updates":
                loadUpdates();
                break;
        }
    }

    private void loadReceivedRequests()
    {
        ListView listView = (ListView) tabHost.getCurrentView().findViewById(R.id.listView);
        notificationsService = new NotificationsService();
        receivedNotifications = notificationsService.getMockedNotifications("received");
        receivedNotificationAdapter = new ReceivedNotificationAdapter(MainActivity.this, receivedNotifications);
        listView.setAdapter(receivedNotificationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, RequestActivity.class);
                Notification notification = (Notification) parent.getItemAtPosition(position);
                myIntent.putExtra("requestedProductName", notification.getProductName());
                myIntent.putExtra("companyName", notification.getSupplierName());
                myIntent.putExtra("date", notification.getCreationDate());

                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    private void loadSentRequests()
    {
        ListView listView = (ListView) tabHost.getCurrentView().findViewById(R.id.listView);
        notificationsService = new NotificationsService();
        sentNotifications = notificationsService.getMockedNotifications("received");
        sentNotificationAdapter = new SentNotificationAdapter(MainActivity.this, sentNotifications);
        listView.setAdapter(sentNotificationAdapter);
    }

    private void loadUpdates()
    {
        ListView productsListView = (ListView) tabHost.getCurrentView().findViewById(R.id.productsListView);
        ProductsService productsService = new ProductsService();
        List<Product> problematicProducts = productsService.getProblematicProducts();
        ProductsListAdapter productListAdapter = new ProductsListAdapter(MainActivity.this, problematicProducts);
        productsListView.setAdapter(productListAdapter);

    }
}
