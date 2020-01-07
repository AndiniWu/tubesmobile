package com.example.myproperty;

import com.google.firebase.database.Exclude;

public class ModelProperty {
    private String imageURL;
    private String key;
    private int position;
    private String alamatET;
    private String tipePropET;
    private String hargaET;
    private String luasBangunanET;
    private String luasTanahET;
    private String kamarMandiET;
    private String kamarTidurET;
    private String fasilitasET;

    public ModelProperty() {
    }
    public ModelProperty(int position){
        this.position = position;
    }
    public ModelProperty(String alamatET, String imageURL, String tipePropET, String hargaET, String luasBangunET, String luasTanahET, String kamarMandiET, String kamarTidurET, String fasilitasET){
        if(alamatET.trim().equals("")){
            alamatET = "No Address";
        }
        this.alamatET = alamatET;
        this.imageURL = imageURL;
        this.tipePropET = tipePropET;
        this.hargaET = hargaET;
        this.luasBangunanET = luasBangunanET;
        this.luasTanahET = luasTanahET;
        this.kamarMandiET = kamarMandiET;
        this.kamarTidurET = kamarTidurET;
        this.fasilitasET = fasilitasET;
    }


    public String getAlamatET() {
        return alamatET;
    }

    public void setAlamatET(String alamatET) {
        this.alamatET = alamatET;
    }

    public String getTipePropET() {
        return tipePropET;
    }

    public void setTipePropET(String tipePropET) {
        this.tipePropET = tipePropET;
    }

    public String getHargaET() {
        return hargaET;
    }

    public void setHargaET(String hargaET) {
        this.hargaET = hargaET;
    }

    public String getLuasBangunET() {
        return luasBangunanET;
    }

    public void setLuasBangunET(String luasBangunET) {
        this.luasBangunanET = luasBangunanET;
    }

    public String getLuasTanahET() {
        return luasTanahET;
    }

    public void setLuasTanahET(String luasTanahET) {
        this.luasTanahET = luasTanahET;
    }

    public String getKamarMandiET() {
        return kamarMandiET;
    }

    public void setKamarMandiET(String kamarMandiET) {
        this.kamarMandiET = kamarMandiET;
    }

    public String getKamarTidurET() {
        return kamarTidurET;
    }

    public void setKamarTidurET(String kamarTidurET) {
        this.kamarTidurET = kamarTidurET;
    }

    public String getFasilitasET() {
        return fasilitasET;
    }

    public void setFasilitasET(String fasilitasET) {
        this.fasilitasET = fasilitasET;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Exclude
    public String getKey() {
        return key;
    }

    @Exclude
    public void setKey(String key) {
        this.key = key;
    }
}
