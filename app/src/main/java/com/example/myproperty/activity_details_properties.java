package com.example.myproperty;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.google.firebase.database.FirebaseDatabase;

public class activity_details_properties extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_properties);
        setContentView(R.layout.activity_detail_property);
        String[] daerah_ = getResources().getStringArray(R.array.daerah_properti);
        String[] harga_ = getResources().getStringArray(R.array.harga_properti);
        String[] jenis_ = getResources().getStringArray(R.array.jenis_properti);

        View recyclerView = findViewById(R.id.homeListView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, daerah_, harga_, jenis_); // our adapter takes two string array
        recyclerView.setAdapter(adapter);
        /**
         * Inisialisasi dan mengambil Firebase Database Reference
         */
        database = FirebaseDatabase.getInstance().getReference();

        /**
         * Mengambil data barang dari Firebase Realtime DB
         */
    }
    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FirebaseDBReadActivity.class);
    }
}
