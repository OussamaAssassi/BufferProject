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

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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



        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(String tabId) {
                ListView listView;
                List<Source> sources;
                SourceAdapter adapter;
                switch (tabId)
                {
                    case "received":
                        listView = (ListView) tabHost.getCurrentView().findViewById(R.id.listView);
                        sources = getSources(true);
                        adapter = new SourceAdapter(MainActivity.this, sources);
                        listView.setAdapter(adapter);
                        break;
                    case "sent":
                        listView = (ListView) tabHost.getCurrentView().findViewById(R.id.listView);
                        sources = getSources(false);
                        adapter = new SourceAdapter(MainActivity.this, sources);
                        listView.setAdapter(adapter);
                        break;
                    case "updates":
                        break;
                    default:
                        break;

                }
            }});

    }


    private View createTabIndicator(String text) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_indicator, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_indicator_label);
        textView.setText(text);
        return view;
    }


    private List<Source> getSources(Boolean lol){
        if(lol)
        {
            List<Source> sources = new ArrayList<Source>();
            sources.add(new Source("Toto 1", "Tata 1"));
            sources.add(new Source("Toto 2", "Tata 2"));
            sources.add(new Source("Toto 3", "Tata 3"));
            sources.add(new Source("Toto 4", "Tata 4"));
            sources.add(new Source("Toto 5", "Tata 5"));
            return sources;

        }
        else{
            List<Source> sources = new ArrayList<Source>();
            sources.add(new Source("Source 1", "Supplier 1"));
            sources.add(new Source("Source 2", "Supplier 2"));
            sources.add(new Source("Source 3", "Supplier 3"));
            sources.add(new Source("Source 4", "Supplier 4"));
            sources.add(new Source("Source 5", "Supplier 5"));
            return sources;

        }
    }

    private void showListOfSources(){
        List<Source> sources = getSources(true);

        SourceAdapter adapter = new SourceAdapter(MainActivity.this, sources);
        mListView.setAdapter(adapter);
    }
}
