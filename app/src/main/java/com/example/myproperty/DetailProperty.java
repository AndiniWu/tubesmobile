package com.example.myproperty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailProperty extends AppCompatActivity {

    TextView daerah_Properti;
    TextView harga_Properti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_property);

        daerah_Properti = findViewById(R.id.daerahProperti);
        harga_Properti = findViewById(R.id.hargaProperti);
        Intent i = getIntent();
        String daerah = i.getStringExtra("namaDaerah");
        String harga = i.getStringExtra("namaHarga");

        daerah_Properti.setText(daerah);
        harga_Properti.setText(harga);
    }
}
