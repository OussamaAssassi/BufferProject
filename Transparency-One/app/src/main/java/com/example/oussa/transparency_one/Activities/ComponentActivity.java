package com.example.oussa.transparency_one.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.oussa.transparency_one.Adapters.ComponentsListAdapter;
import com.example.oussa.transparency_one.Adapters.VisibilitiesListAdapter;
import com.example.oussa.transparency_one.DTOs.Product;
import com.example.oussa.transparency_one.R;

import java.util.ArrayList;
import java.util.List;

public class ComponentActivity extends AppCompatActivity {

    ListView mListView;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);

        getSupportActionBar().setTitle("Components");

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        ListView listView = (ListView) findViewById(R.id.componentsListView);

        List<Product> components = getComponentsForProduct();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(ComponentActivity.this, MainActivity.class);
                ComponentActivity.this.startActivity(myIntent);
            }
        });

        listView.setAdapter(new ComponentsListAdapter(ComponentActivity.this, components));
    }
    private List<Product> getComponentsForProduct()
    {
        List<Product> components = new ArrayList<Product>();
        components.add(new Product("Weed", R.drawable.eye_icon, R.drawable.hands_icon));
        components.add(new Product("Heroin", R.drawable.eye_icon, R.drawable.hands_icon));
        components.add(new Product("Cocain", R.drawable.eye_icon, R.drawable.hands_icon));
        return components;
    }
}
