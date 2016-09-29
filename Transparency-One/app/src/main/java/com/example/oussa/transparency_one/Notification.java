package com.example.oussa.transparency_one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

    public static class ProductActivity extends AppCompatActivity {

        ListView mListView;
        TabHost tabHost;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setLogo(R.drawable.full_logo_big_tran);
            getSupportActionBar().setDisplayUseLogoEnabled(true);

            tabHost = (TabHost) findViewById(R.id.tabhost);
            //Important
            tabHost.setVisibility(TabHost.VISIBLE);
            tabHost.setup();

            TabHost.TabSpec tab1 = tabHost.newTabSpec("received");
            TabHost.TabSpec tab2 = tabHost.newTabSpec("sent");
            TabHost.TabSpec tab3 = tabHost.newTabSpec("updates");

            // Set the Tab name and Activity
            // that will be opened when particular Tab will be selected

            tab1.setIndicator(createTabIndicator("Received"));
            tab1.setContent(R.id.i_layout_1);

            tab2.setIndicator(createTabIndicator("Sent"));
            tab2.setContent(R.id.i_layout_2);

            tab3.setIndicator(createTabIndicator("Updates"));
            tab3.setContent(R.id.i_layout_3);

            /** Add the tabs  to the TabHost to display. */
            tabHost.addTab(tab1);
            tabHost.addTab(tab2);
            tabHost.addTab(tab3);

            tabHost.setCurrentTab(0);
            loadDataInTab("received");


            tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
                @Override
                public void onTabChanged(String tabId) {
                    loadDataInTab(tabId);
                }});

        }

        private void loadDataInTab(String tabId)
        {
            ListView listView = (ListView) tabHost.getCurrentView().findViewById(R.id.listView);
            List<Notification> notifications = getNotifications(tabId);
            switch (tabId)
            {
                case "received":
                    listView.setAdapter(new ReceivedNotificationAdapter(ProductActivity.this, notifications));
                    break;
                case "sent":
                    listView.setAdapter(new SentNotificationAdapter(ProductActivity.this, notifications));
                    break;
            }


        }

        private View createTabIndicator(String text) {
            View view = LayoutInflater.from(this).inflate(R.layout.tab_indicator, null);
            TextView textView = (TextView) view.findViewById(R.id.tv_indicator_label);
            textView.setText(text);
            return view;
        }


        private List<Notification> getNotifications(String notificationType){
            if(notificationType == "received")
            {
                List<Notification> notifications = new ArrayList<Notification>();
                notifications.add(new Notification("Paella", "Jumpy Fishes Ltd", "2 hours ago", R.drawable.logo_big));
                notifications.add(new Notification("Marshmallows", "Candies for us", "4 hours ago", R.drawable.logo_big_negatig));
                notifications.add(new Notification("Yogurt Cherry", "Milk & co", "1 day ago", R.drawable.logo_big));
                notifications.add(new Notification("Mayan Drink", "Energy inc.", "1 week ago", R.drawable.logo_big));
                notifications.add(new Notification("Lakewood Drink", "Drink corp", "2 months ago", R.drawable.logo_big));
                return notifications;

            }
            else if(notificationType == "sent"){
                List<Notification> notifications = new ArrayList<Notification>();

                notifications.add(new Notification("Source 1", "Supplier 1", "1 hour ago", 1));
                notifications.add(new Notification("Source 2", "Supplier 2", "3 hours ago", 1));
                notifications.add(new Notification("Source 3", "Supplier 3", "4 days ago", 1));
                notifications.add(new Notification("Source 4", "Supplier 4", "1 week ago", 1));
                notifications.add(new Notification("Source 5", "Supplier 5", "1 month ago", 1));
                return notifications;
            }
            else{
                return null;
            }

        }
    }
}
