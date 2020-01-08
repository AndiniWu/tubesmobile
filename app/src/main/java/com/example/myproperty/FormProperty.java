package com.example.myproperty;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


public class FormProperty extends AppCompatActivity{

    private static final int PICK_IMAGE_REQUEST = 1;
    private Button chooseImageBtn;
    private Button uploadBtn;
    private EditText alamatET;
    private EditText tipePropET;
    private EditText hargaET;
    private EditText luasBangunET;
    private EditText luasTanahET;
    private EditText kamarMandiET;
    private EditText kamarTidurET;
    private EditText fasilitasET;
    private EditText daerahET;
    private EditText teleponET;
    private EditText surelET;
    private ImageView chosenImageView;
    private ProgressBar uploadProgressBar;

    private Uri mImageUri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_property);

        chooseImageBtn = findViewById(R.id.upload_image);
        uploadBtn = findViewById(R.id.uploadBtn);
        alamatET = findViewById(R.id.alamat);
        tipePropET = findViewById(R.id.tipe_properti);
        hargaET = findViewById(R.id.harga);
        luasBangunET = findViewById(R.id.luas_bangunan);
        luasTanahET = findViewById(R.id.luas_tanah);
        kamarMandiET = findViewById(R.id.kamar_mandi);
        kamarTidurET = findViewById(R.id.kamar_tidur);
        fasilitasET = findViewById(R.id.fasilitas);
        daerahET = findViewById(R.id.daerah);
        teleponET = findViewById(R.id.telepon);
        surelET = findViewById(R.id.surel);
        chosenImageView = findViewById(R.id.chosenImageView);
        uploadProgressBar = findViewById(R.id.progress_bar);

        mStorageRef = FirebaseStorage.getInstance().getReference("property_upload");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("property_upload");

        chooseImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mUploadTask != null && mUploadTask.isInProgress()){
                    Toast.makeText(FormProperty.this, "An Upload is Still in Progress", Toast.LENGTH_SHORT).show();
                }else{
                    uploadFile();
                }
            }
        });
    }

    private void openFileChooser(){
        Intent intent= new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();

            Picasso.get().load(mImageUri).into(chosenImageView);
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile() {
        if (mImageUri != null) {
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));

            uploadProgressBar.setVisibility(View.VISIBLE);
            uploadProgressBar.setIndeterminate(true);

            mUploadTask = fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    uploadProgressBar.setVisibility(View.VISIBLE);
                                    uploadProgressBar.setIndeterminate(false);
                                    uploadProgressBar.setProgress(0);
                                }
                            }, 500);

                            Toast.makeText(FormProperty.this, "Property Upload successful", Toast.LENGTH_LONG).show();
                            ModelProperty upload = new ModelProperty(alamatET.getText().toString().trim(),
                                    taskSnapshot.getMetadata().getReference().getDownloadUrl().toString(),
                                    tipePropET.getText().toString(),
                                    hargaET.getText().toString(),
                                    luasBangunET.getText().toString(),
                                    luasTanahET.getText().toString(),
                                    kamarMandiET.getText().toString(),
                                    kamarTidurET.getText().toString(),
                                    fasilitasET.getText().toString(),
                                    daerahET.getText().toString(),
                                    teleponET.getText().toString(),
                                    surelET.getText().toString()
                            );

                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(upload);

                            uploadProgressBar.setVisibility(View.INVISIBLE);
                            openImagesActivity ();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            uploadProgressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(FormProperty.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            uploadProgressBar.setProgress((int) progress);
                        }
                    });
        } else {
            Toast.makeText(this, "You haven't Selected Any file selected", Toast.LENGTH_SHORT).show();
        }
    }
    private void openImagesActivity(){
        Intent intent = new Intent(this, ReadActivity.class);
        startActivity(intent);
    }
}
