package com.northuniversity.model;

public class Car {
    private  String number;
    private  String license;

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", license='" + license + '\'' +
                '}';
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

    public void setLicense(String license) {
        this.license = license;
    }
}
