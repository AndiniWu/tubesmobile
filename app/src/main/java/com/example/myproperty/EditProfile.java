
//package com.example.myproperty;
//
//import android.os.Bundle;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.auth.FirebaseAuth;
//
//public class EditProfile extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_profile2);
//
//        mAuth = FirebaseAuth.getInstance();
//    }
//
//    private void updateprofile(Profile profile) {
//        /**
//         * Baris kode yang digunakan untuk mengupdate data profile
//         * yang sudah dimasukkan di Firebase Realtime Database
//         */
//        database.child("profile") //akses parent index, ibaratnya seperti nama tabel
//                .child(profil.getKey()) //select data berdasarkan key
//                .setValue(profil) //set value data yang baru
//                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//
//                        /**
//                         * Baris kode yang akan dipanggil apabila proses update barang sukses
//                         */
//                        Snackbar.make(findViewById(R.id.bt_submit), "Data berhasil diupdatekan", Snackbar.LENGTH_LONG).setAction("Oke", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                finish();
//                            }
//                        }).show();
//                    }
//                });
//    }
//}

package com.example.myproperty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile2);


    }
}

