package com.topnotch.bcryptGenerator.model;

import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptObject {

    private String encryptedString;
    private String data;

    public BCryptObject(String encryptedString, String data) {
        this.encryptedString = encryptedString;
        this.data = data;
    }

    public BCryptObject(){

    }

    public String getEncryptedString() {
        return encryptedString;
    }

    public void setEncryptedString(String encryptedString) {
        this.encryptedString = encryptedString;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isEqual(PasswordEncoder passwordEncoder){
        return passwordEncoder.matches(data, encryptedString);
    }

    @Override
    public String toString() {
        return "BCryptObject{" +
                "encryptedString='" + encryptedString + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
