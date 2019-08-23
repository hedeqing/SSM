package com.northuniversity.model;

public class Car {
    private  String id;
    private  String number;
    private  String license;

    public Car() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLicense() {
        return license;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", license='" + license + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
