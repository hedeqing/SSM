package com.northuniversity.model;

public class Sensor {
    private  String license;
    private  String concentrationId;
    private  String sensorName;

    public Sensor() {
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "license='" + license + '\'' +
                ", concentrationId='" + concentrationId + '\'' +
                ", sensorName='" + sensorName + '\'' +
                '}';
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getConcentrationId() {
        return concentrationId;
    }

    public void setConcentrationId(String concentrationId) {
        this.concentrationId = concentrationId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}
