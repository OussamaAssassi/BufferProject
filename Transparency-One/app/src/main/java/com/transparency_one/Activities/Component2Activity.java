package com.transparency_one.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.transparency_one.Activities.MainActivity;
import com.transparency_one.Adapters.SourcesListAdapter;
import com.transparency_one.DTOs.Product;
import com.transparency_one.R;

import java.util.ArrayList;
import java.util.List;

import static com.transparency_one.R.drawable.warning_icon;

public class Component2Activity extends AppCompatActivity {

    ListView mListView;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int componentPosition = Integer.parseInt(intent.getStringExtra("position"));
        setContentView(R.layout.activity_components2);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Components");

        ListView listView = (ListView) findViewById(R.id.componentsListView);
        List<Product> sources = getSourcesForComponent() ;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(Component2Activity.this, MainActivity.class);
                Component2Activity.this.startActivity(myIntent);
            }
        });
        listView.setAdapter(new SourcesListAdapter(Component2Activity.this, sources));

        ListView listView2 = (ListView) findViewById(R.id.componentsListView2);
        List<Product> sources2 = getSourcesForComponent2();
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(Component2Activity.this, MainActivity.class);
                Component2Activity.this.startActivity(myIntent);
            }
        });
        listView2.setAdapter(new SourcesListAdapter(Component2Activity.this, sources2));


        ListView listView3 = (ListView) findViewById(R.id.componentsListView3);
        List<Product> sources3 = getSourcesForComponent3();
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(Component2Activity.this, MainActivity.class);
                Component2Activity.this.startActivity(myIntent);
            }
        });
        listView3.setAdapter(new SourcesListAdapter(Component2Activity.this, sources3));
    }

    private List<Product> getSourcesForComponent()
    {
        List<Product> components = new ArrayList<Product>();
        components.add(new Product("Glucose syrup - Bag of 10 kg", "Sugarly France"));
        components.add(new Product("Glucose syrop - Bag of 5 kg", "World of Sugar Spain", warning_icon));
        return components;
    }

    private List<Product> getSourcesForComponent2()
    {
        List<Product> components = new ArrayList<Product>();
        components.add(new Product("White sugar - Box of 100 kg", "Sugar cooperative Netherland"));
        return components;
    }
    private List<Product> getSourcesForComponent3()
    {
        List<Product> components = new ArrayList<Product>();
        components.add(new Product("E120 coloring - Box of 500 g", "Food colorizer Germany"));
        return components;
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
