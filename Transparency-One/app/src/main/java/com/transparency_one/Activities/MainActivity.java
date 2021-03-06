package com.transparency_one.Activities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.transparency_one.Activities.RequestActivity;
import com.transparency_one.Adapters.ProductsListAdapter;
import com.transparency_one.Adapters.ReceivedNotificationAdapter;
import com.transparency_one.Adapters.SentNotificationAdapter;
import com.transparency_one.DTOs.Notification;
import com.transparency_one.DTOs.Product;
import com.transparency_one.NotificationsService;
import com.transparency_one.ProductsService;
import com.transparency_one.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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


        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();
        myTimer.schedule(myTask, 10000, 500000000);
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
        notificationsService = new NotificationsService(MainActivity.this.getApplicationContext());

        receivedNotifications = notificationsService.getReceivedNotifications();
        List<Notification> reducedListOfNotificationsNotFullfilled = new ArrayList<Notification>();
        for(Notification n : receivedNotifications)
        {
            if(!n.getWasFulfilled())
                reducedListOfNotificationsNotFullfilled.add(n);
        }


        receivedNotificationAdapter = new ReceivedNotificationAdapter(MainActivity.this, reducedListOfNotificationsNotFullfilled);
        listView.setAdapter(receivedNotificationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, RequestActivity.class);
                myIntent.putExtra("notificationPosition", Integer.toString(position));

                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    private void loadSentRequests()
    {
        ListView listView = (ListView) tabHost.getCurrentView().findViewById(R.id.listView);
        notificationsService = new NotificationsService(MainActivity.this.getApplicationContext());
        sentNotifications = notificationsService.getSentNotifications();
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

        productsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent myIntent = new Intent(MainActivity.this, com.transparency_one.Activities.ComponentActivity.class);
                    myIntent.putExtra("position", Integer.toString(position));
                    MainActivity.this.startActivity(myIntent);
                }
                if(position == 1) {
                    Intent myIntent = new Intent(MainActivity.this, com.transparency_one.Activities.Component2Activity.class);
                    myIntent.putExtra("position", Integer.toString(position));
                    MainActivity.this.startActivity(myIntent);
                }
            }
        });

    }

    class MyTimerTask extends TimerTask {
        public void run() {

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this);
            mBuilder.setSmallIcon(R.drawable.logo_big);
            mBuilder.setContentTitle("New visibility request from Jumpy Fishes Ltd");
            mBuilder.setContentText("Can you provide more visibility on Paella?");

            Intent resultIntent = new Intent(MainActivity.this, RequestActivity.class);
            resultIntent.putExtra("notificationPosition", "0");

            // The stack builder object will contain an artificial back stack for the
            // started Activity.
            // This ensures that navigating backward from the Activity leads out of
            // your application to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
            // Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(MainActivity.class);
            // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            // mId allows you to update the notification later on
            int mId = 0;
            mNotificationManager.notify(mId, mBuilder.build());
        }
    }
}
