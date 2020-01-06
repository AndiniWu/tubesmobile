package com.example.myproperty;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class DetailProperty extends AppCompatActivity {

    TextView daerah_Properti;
    TextView harga_Properti;
    TextView jenis_Properti;
    TextView kt_Properti;
    TextView km_Properti;
    TextView lt_Properti;
    TextView lb_Properti;
    TextView fasilitas_Properti;
    TextView alamat_Properti;
    TextView telepon_Properti;
    TextView surel_Properti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_property);

        daerah_Properti = findViewById(R.id.daerahProperti);
        harga_Properti = findViewById(R.id.hargaProperti);
        jenis_Properti = findViewById(R.id.jenisProperti);
        kt_Properti = findViewById(R.id.ktProperti);
        km_Properti = findViewById(R.id.kmProperti);
        lt_Properti = findViewById(R.id.ltProperti);
        lb_Properti = findViewById(R.id.lbProperti);
        fasilitas_Properti = findViewById(R.id.fasilitasProperti);
        alamat_Properti = findViewById(R.id.alamatProperti);
        telepon_Properti = findViewById(R.id.teleponProperti);
        surel_Properti = findViewById(R.id.surelProperti);

        Intent i = getIntent();
        String daerah = i.getStringExtra("namaDaerah");
        String harga = i.getStringExtra("namaHarga");
        String jenis = i.getStringExtra("namaJenis");
        String kt = i.getStringExtra("namaKt");
        String km = i.getStringExtra("namaKm");
        String lt = i.getStringExtra("namaLt");
        String lb = i.getStringExtra("namaLb");
        String fasilitas = i.getStringExtra("namaFasilitas");
        String alamat = i.getStringExtra("namaAlamat");
        String telepon = i.getStringExtra("namaTelepon");
        String surel = i.getStringExtra("namaSurel");

        daerah_Properti.setText(daerah);
        harga_Properti.setText(harga);
        jenis_Properti.setText(jenis);
        kt_Properti.setText(kt);
        km_Properti.setText(km);
        lt_Properti.setText(lt);
        lb_Properti.setText(lb);
        fasilitas_Properti.setText(fasilitas);
        alamat_Properti.setText(alamat);
        telepon_Properti.setText(telepon);
        surel_Properti.setText(surel);
    }

    public void bukaLokasi(View view) {
        String loc = alamat_Properti.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void bukaTelepon(View view) {
        String tel = telepon_Properti.getText().toString();
        Uri callUri = Uri.parse("tel:" + tel);
        Intent intent = new Intent(Intent.ACTION_DIAL, callUri);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void bukaSurel(View view) {
        String mail = surel_Properti.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});
        intent.setType("message/rfc822");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}
