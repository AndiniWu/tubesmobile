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
        setContentView(R.layout.activity_main);

        String[] daerah_ = getResources().getStringArray(R.array.daerah_properti);
        String[] harga_ = getResources().getStringArray(R.array.harga_properti);
        String[] jenis_ = getResources().getStringArray(R.array.jenis_properti);
        String[] kt_ = getResources().getStringArray(R.array.kt_properti);
        String[] km_ = getResources().getStringArray(R.array.km_properti);
        String[] lt_ = getResources().getStringArray(R.array.lt_properti);
        String[] lb_ = getResources().getStringArray(R.array.lb_properti);
        String[] fasilitas_ = getResources().getStringArray(R.array.fasilitas_properti);
        String[] alamat_ = getResources().getStringArray(R.array.alamat_properti);


        recyclerView = findViewById(R.id.homeListView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,daerah_,harga_,jenis_,kt_,km_,lt_,lb_,fasilitas_,alamat_);
        recyclerView.setAdapter(adapter);

    }
}