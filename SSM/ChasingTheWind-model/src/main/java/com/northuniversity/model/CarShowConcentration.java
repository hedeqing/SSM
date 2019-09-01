package com.northuniversity.model;

import java.util.List;

public class CarShowConcentration {
    private  String license;
    private List<List<Integer>> data_mg;

    public CarShowConcentration() {
    }

    @Override
    public String toString() {
        return "CarShowConcentration{" +
                "license='" + license + '\'' +
                ", data_mg=" + data_mg +
                '}';
    }

    public List<List<Integer>> getData_mg() {
        return data_mg;
    }

    public void setData_mg(List<List<Integer>> data_mg) {
        this.data_mg = data_mg;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

}
