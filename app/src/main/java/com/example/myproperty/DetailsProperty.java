package com.example.myproperty;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class DetailsProperty extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private TextView etAlamat, etFasilitas, etHarga, etKamarMandi, etKamarTidur, etLuasBangunan, etLuasTanah, etTipeProperty;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private ImageView profilePicImageView;
    private FirebaseStorage firebaseStorage;
    private TextView textViewemailname;
    private EditText editTextAlamat;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_property);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        editTextAlamat = (EditText)findViewById(R.id.et_username);
        profilePicImageView = findViewById(R.id.profile_pic_imageView);
        etAlamat = findViewById(R.id.alamat_textView);
        etFasilitas = findViewById(R.id.fasilitas_textView);
        etHarga = findViewById(R.id.harga_textView);
        etKamarMandi = findViewById(R.id.kamar_mandi_textView);
        etKamarTidur = findViewById(R.id.kamar_tidur_textView);
        etLuasBangunan = findViewById(R.id.luas_bangunan_textView);
        etLuasTanah = findViewById(R.id.luas_tanah_textView);
        etTipeProperty = findViewById(R.id.tipe_properti_textView);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        StorageReference storageReference = firebaseStorage.getReference();
        // Get the image stored on Firebase via "User id/Images/Profile Pic.jpg".
        storageReference.child(firebaseAuth.getUid()).child("Images").child("Profile Pic").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Using "Picasso" (http://square.github.io/picasso/) after adding the dependency in the Gradle.
                // ".fit().centerInside()" fits the entire image into the specified area.
                // Finally, add "READ" and "WRITE" external storage permissions in the Manifest.
                Picasso.get().load(uri).fit().centerInside().into(profilePicImageView);
            }
        });
        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(getApplicationContext(),SignUp.class));
        }
        final FirebaseUser user=firebaseAuth.getCurrentUser();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                ModelProperty modelproperty = dataSnapshot.getValue(ModelProperty.class);
                etAlamat.setText(modelproperty.getAlamatET());
                etFasilitas.setText(modelproperty.getFasilitasET());
                etHarga.setText(modelproperty.getHargaET());
                etKamarMandi.setText(modelproperty.getKamarMandiET());
                etKamarTidur.setText(modelproperty.getKamarTidurET());
                etLuasBangunan.setText(modelproperty.getLuasBangunET());
                etLuasTanah.setText(modelproperty.getLuasTanahET());
                etTipeProperty.setText(modelproperty.getTipePropET());
            }
            @Override
            public void onCancelled( DatabaseError databaseError) {
                Toast.makeText(DetailsProperty.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void buttonClickedEditAlamat(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_name, null);
        final EditText etUsername = alertLayout.findViewById(R.id.et_surename);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Edit Alamat");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String al = etAlamat.getText().toString();
                String fas = etFasilitas.getText().toString();
                String hrg =  etHarga.getText().toString();
                String km = etKamarMandi.getText().toString();
                String kt = etKamarTidur.getText().toString();
                String lb =  etLuasBangunan.getText().toString();
                String lt = etLuasTanah.getText().toString();
                String tp = etTipeProperty.getText().toString();
                ModelEditProp modelProperty = new ModelEditProp(al,fas, hrg, km, kt, lb, lt, tp);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                databaseReference.child(user.getUid()).setValue(modelProperty);
                databaseReference.child(user.getUid()).setValue(modelProperty);
                etUsername.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
    public void buttonClickedEditSurname(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_username, null);
        final EditText etUserSurname = alertLayout.findViewById(R.id.et_surename);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Edit Fasilitas");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String al = etAlamat.getText().toString();
                String fas = etFasilitas.getText().toString();
                String hrg =  etHarga.getText().toString();
                String km = etKamarMandi.getText().toString();
                String kt = etKamarTidur.getText().toString();
                String lb =  etLuasBangunan.getText().toString();
                String lt = etLuasTanah.getText().toString();
                String tp = etTipeProperty.getText().toString();
                ModelEditProp modelProperty = new ModelEditProp(al,fas, hrg, km, kt, lb, lt, tp);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                databaseReference.child(user.getUid()).setValue(modelProperty);
                databaseReference.child(user.getUid()).setValue(modelProperty);
                etUserSurname.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
    public void buttonClickedEditHarga(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_phoneno, null);
        final EditText hargaET = alertLayout.findViewById(R.id.harga_textView);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Edit Harga");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String al = etAlamat.getText().toString();
                String fas = etFasilitas.getText().toString();
                String hrg =  etHarga.getText().toString();
                String km = etKamarMandi.getText().toString();
                String kt = etKamarTidur.getText().toString();
                String lb =  etLuasBangunan.getText().toString();
                String lt = etLuasTanah.getText().toString();
                String tp = etTipeProperty.getText().toString();
                ModelEditProp modelProperty = new ModelEditProp(al,fas, hrg, km, kt, lb, lt, tp);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                databaseReference.child(user.getUid()).setValue(modelProperty);
                databaseReference.child(user.getUid()).setValue(modelProperty);
                hargaET.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void buttonClickedEditKamarMandi(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_phoneno, null);
        final EditText KamarMandiET = alertLayout.findViewById(R.id.kamar_mandi_textView);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Edit");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String al = etAlamat.getText().toString();
                String fas = etFasilitas.getText().toString();
                String hrg =  etHarga.getText().toString();
                String km = etKamarMandi.getText().toString();
                String kt = etKamarTidur.getText().toString();
                String lb =  etLuasBangunan.getText().toString();
                String lt = etLuasTanah.getText().toString();
                String tp = etTipeProperty.getText().toString();
                ModelEditProp modelProperty = new ModelEditProp(al,fas, hrg, km, kt, lb, lt, tp);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                databaseReference.child(user.getUid()).setValue(modelProperty);
                databaseReference.child(user.getUid()).setValue(modelProperty);
                KamarMandiET.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void buttonClickedEditKamarTidur(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_phoneno, null);
        final EditText KamarTidurET = alertLayout.findViewById(R.id.kamar_tidur_textView);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Edit");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String al = etAlamat.getText().toString();
                String fas = etFasilitas.getText().toString();
                String hrg =  etHarga.getText().toString();
                String km = etKamarMandi.getText().toString();
                String kt = etKamarTidur.getText().toString();
                String lb =  etLuasBangunan.getText().toString();
                String lt = etLuasTanah.getText().toString();
                String tp = etTipeProperty.getText().toString();
                ModelEditProp modelProperty = new ModelEditProp(al,fas, hrg, km, kt, lb, lt, tp);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                databaseReference.child(user.getUid()).setValue(modelProperty);
                databaseReference.child(user.getUid()).setValue(modelProperty);
                KamarTidurET.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void buttonClickedEditLuasBangunan(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_phoneno, null);
        final EditText LuasBangunanET = alertLayout.findViewById(R.id.luas_bangunan_textView);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Edit");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String al = etAlamat.getText().toString();
                String fas = etFasilitas.getText().toString();
                String hrg =  etHarga.getText().toString();
                String km = etKamarMandi.getText().toString();
                String kt = etKamarTidur.getText().toString();
                String lb =  etLuasBangunan.getText().toString();
                String lt = etLuasTanah.getText().toString();
                String tp = etTipeProperty.getText().toString();
                ModelEditProp modelProperty = new ModelEditProp(al,fas, hrg, km, kt, lb, lt, tp);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                databaseReference.child(user.getUid()).setValue(modelProperty);
                databaseReference.child(user.getUid()).setValue(modelProperty);
                LuasBangunanET.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void buttonClickedEditLuasTanah(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_phoneno, null);
        final EditText LuasTanahET = alertLayout.findViewById(R.id.luas_tanah_textView);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Edit");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String al = etAlamat.getText().toString();
                String fas = etFasilitas.getText().toString();
                String hrg =  etHarga.getText().toString();
                String km = etKamarMandi.getText().toString();
                String kt = etKamarTidur.getText().toString();
                String lb =  etLuasBangunan.getText().toString();
                String lt = etLuasTanah.getText().toString();
                String tp = etTipeProperty.getText().toString();
                ModelEditProp modelProperty = new ModelEditProp(al,fas, hrg, km, kt, lb, lt, tp);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                databaseReference.child(user.getUid()).setValue(modelProperty);
                databaseReference.child(user.getUid()).setValue(modelProperty);
                LuasTanahET.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void buttonClickedEditTipeProp(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_phoneno, null);
        final EditText TipePropET = alertLayout.findViewById(R.id.tipe_properti_textView);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Edit");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String al = etAlamat.getText().toString();
                String fas = etFasilitas.getText().toString();
                String hrg =  etHarga.getText().toString();
                String km = etKamarMandi.getText().toString();
                String kt = etKamarTidur.getText().toString();
                String lb =  etLuasBangunan.getText().toString();
                String lt = etLuasTanah.getText().toString();
                String tp = etTipeProperty.getText().toString();
                ModelEditProp modelProperty = new ModelEditProp(al,fas, hrg, km, kt, lb, lt, tp);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                databaseReference.child(user.getUid()).setValue(modelProperty);
                databaseReference.child(user.getUid()).setValue(modelProperty);
                TipePropET.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void navigateLogOut(View v){
        FirebaseAuth.getInstance().signOut();
        Intent inent = new Intent(this, MainActivity.class);
        startActivity(inent);
    }
}
