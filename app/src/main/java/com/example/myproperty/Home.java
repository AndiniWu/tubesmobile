package com.example.myproperty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String[] daerah_ = getResources().getStringArray(R.array.daerah_properti);
        String[] harga_ = getResources().getStringArray(R.array.harga_properti);

        recyclerView = findViewById(R.id.homeListView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,daerah_,harga_); // our adapter takes two string array
        recyclerView.setAdapter(adapter);

    }
}
