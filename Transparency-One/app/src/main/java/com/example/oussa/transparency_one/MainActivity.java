package com.example.oussa.transparency_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;
import android.graphics.Color;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        showListOfSources();
    }


    private List<Source> getSources(){
        List<Source> sources = new ArrayList<Source>();
        sources.add(new Source("Source 1", "Supplier 1"));
        sources.add(new Source("Source 2", "Supplier 2"));
        sources.add(new Source("Source 3", "Supplier 3"));
        sources.add(new Source("Source 4", "Supplier 4"));
        sources.add(new Source("Source 5", "Supplier 5"));
        return sources;
    }

    private void showListOfSources(){
        List<Source> sources = getSources();

        SourceAdapter adapter = new SourceAdapter(MainActivity.this, sources);
        mListView.setAdapter(adapter);
    }
}
