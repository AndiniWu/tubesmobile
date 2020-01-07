package com.example.myproperty;

import android.widget.EditText;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class ModelEditProp implements Serializable{

    private String etAlamat;
    private String etFasilitas;
    private String etHarga;
    private String etKamarMandi;
    private String etKamarTidur;
    private String etLuasBangunan;
    private String etLuasTanah;
    private String etTipeProperty;
    private String key;

    public ModelEditProp(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAlamatET() {
        return etAlamat;
    }

    public void setAlamatET(String etAlamat) {
        this.etAlamat = etAlamat;
    }

    public String getFasilitasET() {
        return etFasilitas;
    }

    public void setFasilitasET(String etFasilitas) {
        this.etFasilitas = etFasilitas;
    }

    public String getHargaET() {
        return etHarga;
    }

    public void setHargaET(String etHarga) {
        this.etHarga = etHarga;
    }

    public String getKamarMandiET() {
        return etKamarMandi;
    }

    public void setKamarMandiET(String etKamarMandi) {
        this.etKamarMandi = etKamarMandi;
    }

    public String getKamarTidurET() {
        return etKamarTidur;
    }

    public void setKamarTidurET(String etKamarTidur) {
        this.etKamarTidur = etKamarTidur;
    }

    public String getLuasBangunanET() {
        return etLuasBangunan;
    }

    public void setLuasBangunanET(String etLuasBangunan) {
        this.etLuasBangunan = etLuasBangunan;
    }

    public String getLuasTanahET() {
        return etLuasTanah;
    }

    public void setLuasTanahET(String etLuasTanah) {
        this.etLuasTanah = etLuasTanah;
    }

    public String getTipePropET() {
        return etTipeProperty;
    }

    public void setTipePropET(String etTipeProperty) {
        this.etTipeProperty = etTipeProperty;
    }

    @Override
    public String toString() {
        return " "+etAlamat+"\n" +
                " "+etFasilitas +"\n" +
                " "+etHarga +"\n" +
                " "+etKamarMandi +"\n" +
                " "+etKamarTidur +"\n" +
                " "+etLuasBangunan +"\n" +
                " "+etLuasTanah +"\n" +
                " "+etTipeProperty ;
    }

    public ModelEditProp(String al, String fas, String hrg, String km, String kt, String lb, String lt, String tp){
        etAlamat = al;
        etFasilitas = fas;
        etHarga = hrg;
        etKamarMandi = km;
        etKamarTidur = kt;
        etLuasBangunan = lb;
        etLuasTanah = lt;
        etTipeProperty = tp;
    }
}

