package com.northuniversity.model;

import java.sql.Blob;

public class User {
    private String uName;
    private int uPassword;
    private String uGender;
    private String uNumber;
    private Blob uAvator;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", uPassword=" + uPassword +
                ", uGender='" + uGender + '\'' +
                ", uNumber='" + uNumber + '\'' +
                ", uAvator='" + uAvator + '\'' +
                '}';
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getuPassword() {
        return uPassword;
    }

    public void setuPassword(int uPassword) {
        this.uPassword = uPassword;
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    public String getuNumber() {
        return uNumber;
    }

    public void setuNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    public Blob getuAvator() {
        return uAvator;
    }

    public void setuAvator(Blob uAvator) {
        this.uAvator = uAvator;
    }
}
