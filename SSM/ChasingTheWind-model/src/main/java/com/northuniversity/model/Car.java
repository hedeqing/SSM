package com.northuniversity.model;

public class Car {
    private  int id;
    private  String number;
    private  String license;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car() {
    }

    public String getNumber() {
        return number.trim();
    }

    public void setNumber(String number) {
        this.number = number.trim();
    }

    public String getLicense() {
        return license.trim();
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", number='" + number.trim() + '\'' +
                ", license='" + license.trim() + '\'' +
                '}';
    }

    public void setLicense(String license) {
        this.license = license.trim();
    }
}
