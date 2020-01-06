package com.example.myproperty;

import com.google.firebase.database.Exclude;

public class ModelUser {
    private String imageURL;
    private String key;
    private int position;
    private String fullnameET;
    private String usernameET;
    private String nohpET;

    public ModelUser(){}
    public ModelUser(int position){
        this.position = position;
    }
    public ModelUser(String fullnameET, String usernameET, String nohpET){
        this.fullnameET = fullnameET;
        this.usernameET = usernameET;
        this.nohpET = nohpET;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getFullnameET() {
        return fullnameET;
    }

    public void setFullnameET(String fullnameET) {
        this.fullnameET = fullnameET;
    }

    public String getUsernameET() {
        return usernameET;
    }

    public void setUsernameET(String usernameET) {
        this.usernameET = usernameET;
    }

    public String getNohpET() {
        return nohpET;
    }

    public void setNohpET(String nohpET) {
        this.nohpET = nohpET;
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
