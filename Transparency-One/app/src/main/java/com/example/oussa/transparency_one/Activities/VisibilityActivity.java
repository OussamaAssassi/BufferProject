package com.example.oussa.transparency_one.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.oussa.transparency_one.Adapters.VisibilitiesListAdapter;
import com.example.oussa.transparency_one.NotificationsService;
import com.example.oussa.transparency_one.R;

import java.util.ArrayList;
import java.util.List;

public class VisibilityActivity extends AppCompatActivity {

    ListView mListView;
    TabHost tabHost;
    int notificationPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_visibility);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Request answer - Step 2");

        Intent intent = getIntent();

        notificationPosition = Integer.parseInt(intent.getStringExtra("notificationPosition"));


        ListView listView = (ListView) findViewById(R.id.visibilitiesListView);

        List<String> visibilities = getVisibilitiesAvailable();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NotificationsService notificationService = new NotificationsService(VisibilityActivity.this.getApplicationContext());
                notificationService.fulFilReceivedNotification(notificationPosition);
                Intent myIntent = new Intent(VisibilityActivity.this, MainActivity.class);

                VisibilityActivity.this.startActivity(myIntent);

            }
        });

        listView.setAdapter(new VisibilitiesListAdapter(VisibilityActivity.this, visibilities));
    }
    private List<String> getVisibilitiesAvailable()
    {
        List<String> products = new ArrayList<String>();
        products.add("FULL");
        products.add("GEOGRAPHICAL");
        products.add("COMPOSITION");
        return products;
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
