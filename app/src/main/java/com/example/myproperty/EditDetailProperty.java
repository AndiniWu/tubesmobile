package com.example.myproperty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditDetailProperty extends AppCompatActivity {

    // variable fields EditText dan Button
    private DatabaseReference database;
    private Button btSubmit;
    private EditText etAlamat;
    private EditText etFasilitas;
    private EditText etHarga;
    private EditText etKamarMandi;
    private EditText etKamarTidur;
    private EditText etLuasBangunan;
    private EditText etLuasTanah;
    private EditText etTipeProperty;
    private Button uploadImg;
    private ImageView chosenImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_detail_property);

        // inisialisasi fields EditText dan Button
        etAlamat = (EditText) findViewById(R.id.alamat);
        etFasilitas = (EditText) findViewById(R.id.fasilitas);
        etHarga = (EditText) findViewById(R.id.harga);
        etKamarMandi = (EditText) findViewById(R.id.kamar_mandi);
        etKamarTidur = (EditText) findViewById(R.id.kamar_tidur);
        etLuasBangunan = (EditText) findViewById(R.id.luas_bangunan);
        etLuasTanah = (EditText) findViewById(R.id.luas_tanah);
        etTipeProperty = (EditText) findViewById(R.id.tipe_properti);
        btSubmit = (Button) findViewById(R.id.updateBtn);

        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        final ModelEditProp modeledit = (ModelEditProp) getIntent().getSerializableExtra("data");

        if (modeledit != null) {
            etAlamat.setText(modeledit.getAlamatET());
            etFasilitas.setText(modeledit.getFasilitasET());
            etHarga.setText(modeledit.getHargaET());
            etKamarMandi.setText(modeledit.getKamarMandiET());
            etKamarTidur.setText(modeledit.getKamarTidurET());
            etLuasBangunan.setText(modeledit.getLuasBangunanET());
            etLuasTanah.setText(modeledit.getLuasTanahET());
            etTipeProperty.setText(modeledit.getTipePropET());
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    modeledit.setAlamatET(etAlamat.getText().toString());
                    modeledit.setFasilitasET(etFasilitas.getText().toString());
                    modeledit.setHargaET(etHarga.getText().toString());
                    modeledit.setKamarMandiET(etKamarMandi.getText().toString());
                    modeledit.setKamarTidurET(etKamarTidur.getText().toString());
                    modeledit.setLuasBangunanET(etLuasBangunan.getText().toString());
                    modeledit.setLuasTanahET(etLuasTanah.getText().toString());
                    modeledit.setTipePropET(etTipeProperty.getText().toString());

                    updateproperty(modeledit);
                }
            });
        } else {
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!isEmpty(etAlamat.getText().toString()) && !isEmpty(etFasilitas.getText().toString()) && !isEmpty(etHarga.getText().toString()) && !isEmpty(etKamarMandi.getText().toString()) && !isEmpty(etKamarTidur.getText().toString()) && !isEmpty(etLuasBangunan.getText().toString()) && !isEmpty(etLuasTanah.getText().toString()) && !isEmpty(etTipeProperty.getText().toString())) {
                        submitproperty(new ModelEditProp(etAlamat.getText().toString(), etFasilitas.getText().toString(), etHarga.getText().toString(), etKamarMandi.getText().toString(), etKamarTidur.getText().toString(), etLuasBangunan.getText().toString(), etLuasTanah.getText().toString(), etTipeProperty.getText().toString()));
                    } else
                        Snackbar.make(findViewById(R.id.updateBtn), "Data barang tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(
                            etAlamat.getWindowToken(), 0);
                }
            });
        }
    }

    private boolean isEmpty(String s){
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void updateproperty(ModelEditProp modeledit) {
        /**
         * Baris kode yang digunakan untuk mengupdate data barang
         * yang sudah dimasukkan di Firebase Realtime Database
         */
        database = FirebaseDatabase.getInstance().getReference();

        database.child("property_upload") //akses parent index, ibaratnya seperti nama tabel
                .child(modeledit.getKey()) //select barang berdasarkan key
                .setValue(modeledit) //set value barang yang baru
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        /**
                         * Baris kode yang akan dipanggil apabila proses update barang sukses
                         */
                        Snackbar.make(findViewById(R.id.editBtn), "Data berhasil diupdatekan", Snackbar.LENGTH_LONG).setAction("Oke", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                finish();
                            }
                        }).show();
                    }
                });
    }

    private void submitproperty(ModelEditProp modeledit) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("property_upload").push().setValue(modeledit).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etAlamat.setText("");
                etFasilitas.setText("");
                etHarga.setText("");
                etKamarMandi.setText("");
                etKamarTidur.setText("");
                etLuasBangunan.setText("");
                etLuasTanah.setText("");
                etTipeProperty.setText("");
                Snackbar.make(findViewById(R.id.updateBtn), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, EditDetailProperty.class);
    }
}
