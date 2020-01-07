package com.example.myproperty;

import android.widget.EditText;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class ModelEditProp implements Serializable{

    private String etImageURL;
    private String etAlamat;
    private String etFasilitas;
    private String etHarga;
    private String etKamarMandi;
    private String etKamarTidur;
    private String etLuasBangun;
    private String etLuasTanah;
    private String etTipeProperty;
    private String etDaerah;
    private String etTelepon;
    private String etSurel;
    private String key;

    public ModelEditProp(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImageURL() {
        return etImageURL;
    }

    public void setEtImageURLET(String etImageURL) {
        this.etImageURL = etImageURL;
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

    public String getLuasBangunET() {
        return etLuasBangun;
    }

    public void setLuasBangunET(String etLuasBangun) {
        this.etLuasBangun = etLuasBangun;
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

    public String getDaerahET() {
        return etDaerah;
    }

    public void setDaerahET(String etDaerah) {
        this.etDaerah = etDaerah;
    }

    public String getTeleponET() {
        return etTelepon;
    }

    public void setTeleponET(String etTelepon) {
        this.etTelepon = etTelepon;
    }

    public String getSurelET() {
        return etSurel;
    }

    public void setSurelET(String etSurel) {
        this.etSurel = etSurel;
    }


    @Override
    public String toString() {
        return " "+etAlamat+"\n" +
                " "+etFasilitas +"\n" +
                " "+etHarga +"\n" +
                " "+etKamarMandi +"\n" +
                " "+etKamarTidur +"\n" +
                " "+etLuasBangun +"\n" +
                " "+etTipeProperty +"\n" +
                " "+etDaerah +"\n" +
                " "+etTelepon +"\n" +
                " "+etSurel;
    }

    public ModelEditProp(String al, String fas, String hrg, String km, String kt, String lb, String lt, String tp, String dr, String tl, String su){
        etAlamat = al;
        etFasilitas = fas;
        etHarga = hrg;
        etKamarMandi = km;
        etKamarTidur = kt;
        etLuasBangun = lb;
        etLuasTanah = lt;
        etTipeProperty = tp;
        etDaerah = dr;
        etTelepon = tl;
        etSurel = su;
    }
}

