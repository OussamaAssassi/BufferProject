package com.transparency_one.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.transparency_one.Adapters.SourcesListAdapter;
import com.transparency_one.DTOs.Product;
import com.transparency_one.R;

import java.util.ArrayList;
import java.util.List;

import static com.transparency_one.R.drawable.new_icon;
import static com.transparency_one.R.drawable.warning_icon;

public class ComponentActivity extends AppCompatActivity {

    ListView mListView;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int componentPosition = Integer.parseInt(intent.getStringExtra("position"));
        setContentView(R.layout.activity_components);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Components");

        ListView listView = (ListView) findViewById(R.id.componentsListView);
        List<Product> sources = componentPosition == 0 ? getSourcesForComponent() : getSourcesForComponent2();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(ComponentActivity.this, MainActivity.class);
                ComponentActivity.this.startActivity(myIntent);
            }
        });
        listView.setAdapter(new SourcesListAdapter(ComponentActivity.this, sources));

        ListView listView2 = (ListView) findViewById(R.id.componentsListView2);
        List<Product> sources2 = getSourcesForComponent2();
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(ComponentActivity.this, MainActivity.class);
                ComponentActivity.this.startActivity(myIntent);
            }
        });
        listView2.setAdapter(new SourcesListAdapter(ComponentActivity.this, sources2));

    }



    private List<Product> getSourcesForComponent()
    {
        List<Product> components = new ArrayList<Product>();
        components.add(new Product("Cotton plant - Bag of 50 kg", "Steadman Corp - Nicaragua", warning_icon));
        components.add(new Product("Cotton plant - Bag of 100 kg", "Archibald Plantation - Brazil"));
        return components;
    }

    private List<Product> getSourcesForComponent2()
    {
        List<Product> components = new ArrayList<Product>();
        components.add(new Product("Polyester fabric - Bag of 5 kg", "Esterficator Canada", new_icon));
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
