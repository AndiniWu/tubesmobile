package com.example.myproperty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class ReadSingleActivity extends AppCompatActivity {

    private Button btSubmit;
    private EditText et_alamat;
    private EditText et_fasilitas;
    private EditText et_harga;
    private EditText et_kamar_mandi;
    private EditText et_kamar_tidur;
    private EditText et_luas_bangunan;
    private EditText et_luas_tanah;
    private EditText et_tipe_property;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_single);
        et_alamat = (EditText) findViewById(R.id.etAlamat);
        et_fasilitas = (EditText) findViewById(R.id.etFasilitas);
        et_harga = (EditText) findViewById(R.id.etHarga);
        et_kamar_mandi = (EditText) findViewById(R.id.etKamarMandi);
        et_kamar_tidur = (EditText) findViewById(R.id.etKamarTidur);
        et_luas_bangunan = (EditText) findViewById(R.id.etLuasBangunan);
        et_luas_tanah = (EditText) findViewById(R.id.etLuasTanah);
        et_tipe_property = (EditText) findViewById(R.id.etTipeProperty);
        btSubmit = (Button) findViewById(R.id.bt_submit);

        et_alamat.setEnabled(false);
        et_fasilitas.setEnabled(false);
        et_harga.setEnabled(false);
        et_kamar_mandi.setEnabled(false);
        et_kamar_tidur.setEnabled(false);
        et_luas_bangunan.setEnabled(false);
        et_luas_tanah.setEnabled(false);
        et_tipe_property.setEnabled(false);
        btSubmit.setVisibility(View.GONE);

        ModelEditProp modelProperty = (ModelEditProp) getIntent().getSerializableExtra("data");
        if(modelProperty!=null){
            et_alamat.setText(modelProperty.getAlamatET());
            et_fasilitas.setText(modelProperty.getFasilitasET());
            et_harga.setText(modelProperty.getHargaET());
            et_kamar_mandi.setText(modelProperty.getKamarMandiET());
            et_kamar_tidur.setText(modelProperty.getKamarTidurET());
            et_luas_bangunan.setText(modelProperty.getLuasBangunanET());
            et_luas_tanah.setText(modelProperty.getLuasTanahET());
            et_tipe_property.setText(modelProperty.getTipePropET());
        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, ReadSingleActivity.class);
    }
}
