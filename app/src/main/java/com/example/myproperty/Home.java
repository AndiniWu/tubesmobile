package com.example.myproperty;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String[] daerah_ = getResources().getStringArray(R.array.daerah_properti);
        String[] harga_ = getResources().getStringArray(R.array.harga_properti);
        String[] jenis_ = getResources().getStringArray(R.array.jenis_properti);
        String[] kt_ = getResources().getStringArray(R.array.kt_properti);
        String[] km_ = getResources().getStringArray(R.array.km_properti);
        String[] lt_ = getResources().getStringArray(R.array.lt_properti);
        String[] lb_ = getResources().getStringArray(R.array.lb_properti);
        String[] fasilitas_ = getResources().getStringArray(R.array.fasilitas_properti);
        String[] alamat_ = getResources().getStringArray(R.array.alamat_properti);
        String[] telepon_ = getResources().getStringArray(R.array.telepon_properti);
        String[] surel_ = getResources().getStringArray(R.array.surel_properti);

        recyclerView = findViewById(R.id.homeListView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,daerah_,harga_,jenis_,kt_,km_,lt_,lb_,fasilitas_,alamat_,
                telepon_,surel_);
        recyclerView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                Intent inent1Profile = new Intent(Home.this, DetailProperty.class);
                                startActivity(inent1Profile);
                                Intent inent3Profile = new Intent(Home.this, Search.class);
                                startActivity(inent3Profile);
                                break;
                            case R.id.action_home:
                                Intent inentProfile = new Intent(Home.this, FormProperty.class);
                                startActivity(inentProfile);
                                break;
                            case R.id.action_profile:
                                Intent inent2Profile = new Intent(Home.this, EditProfile.class);
                                startActivity(inent2Profile);
                                break;
                        }
                        return true;
                    }
                });

    }
}