package com.example.oussa.transparency_one.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.oussa.transparency_one.DTOs.VisibilitiesListAdapter;
import com.example.oussa.transparency_one.R;

import java.util.ArrayList;
import java.util.List;

public class VisibilityActivity extends AppCompatActivity {

    ListView mListView;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_visibility);

        getSupportActionBar().setTitle("Visibility request answer (2/2)");

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        ListView listView = (ListView) findViewById(R.id.visibilitiesListView);

        List<String> visibilities = getVisibilitiesAvailable();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
}
