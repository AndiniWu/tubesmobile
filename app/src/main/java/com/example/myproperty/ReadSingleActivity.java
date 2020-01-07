package com.example.myproperty;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReadSingleActivity extends AppCompatActivity {

    //private Button btSubmit;
    private TextView et_alamat;
    private TextView et_fasilitas;
    private TextView et_harga;
    private TextView et_kamar_mandi;
    private TextView et_kamar_tidur;
    private TextView et_luas_bangun;
    private TextView et_luas_tanah;
    private TextView et_tipe_property;
    private TextView et_daerah;
    private TextView et_telepon;
    private TextView et_surel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_single);
        et_alamat = (TextView) findViewById(R.id.etAlamat);
        et_fasilitas = (TextView) findViewById(R.id.etFasilitas);
        et_harga = (TextView) findViewById(R.id.etHarga);
        et_kamar_mandi = (TextView) findViewById(R.id.etKamarMandi);
        et_kamar_tidur = (TextView) findViewById(R.id.etKamarTidur);
        et_luas_bangun = (TextView) findViewById(R.id.etLuasBangun);
        et_luas_tanah = (TextView) findViewById(R.id.etLuasTanah);
        et_tipe_property = (TextView) findViewById(R.id.etTipeProperty);
        et_daerah = (TextView) findViewById(R.id.etDaerah);
        et_telepon = (TextView) findViewById(R.id.etTelepon);
        et_surel = (TextView) findViewById(R.id.etSurel);
        //btSubmit = (Button) findViewById(R.id.bt_submit);

        //btSubmit.setVisibility(View.GONE);

        ModelEditProp modelProperty = (ModelEditProp) getIntent().getSerializableExtra("data");
        if(modelProperty!=null){
            et_alamat.setText(modelProperty.getAlamatET());
            et_fasilitas.setText(modelProperty.getFasilitasET());
            et_harga.setText(modelProperty.getHargaET());
            et_kamar_mandi.setText(modelProperty.getKamarMandiET());
            et_kamar_tidur.setText(modelProperty.getKamarTidurET());
            et_luas_bangun.setText(modelProperty.getLuasBangunET());
            et_luas_tanah.setText(modelProperty.getLuasTanahET());
            et_tipe_property.setText(modelProperty.getTipePropET());
            et_daerah.setText(modelProperty.getDaerahET());
            et_telepon.setText(modelProperty.getTeleponET());
            et_surel.setText(modelProperty.getSurelET());
        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, ReadSingleActivity.class);
    }

    public void bukaLokasi(View view) {
        String loc = et_alamat.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void bukaTelepon(View view) {
        String tel = et_telepon.getText().toString();
        Uri callUri = Uri.parse("tel:" + tel);
        Intent intent = new Intent(Intent.ACTION_DIAL, callUri);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void bukaSurel(View view) {
        String mail = et_surel.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {mail});
        intent.setType("message/rfc822");

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}
