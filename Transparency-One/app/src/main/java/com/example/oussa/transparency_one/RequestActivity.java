package com.example.oussa.transparency_one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TabHost;

public class RequestActivity extends AppCompatActivity {

    ListView mListView;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_details);

    }

}
