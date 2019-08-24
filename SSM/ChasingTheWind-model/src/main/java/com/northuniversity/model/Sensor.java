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
                "license='" + license.trim() + '\'' +
                ", concentrationId='" + concentrationId.trim() + '\'' +
                ", sensorName='" + sensorName.trim() + '\'' +
                '}';
    }

    public String getLicense() {
        return license.trim();
    }

    public void setLicense(String license) {
        this.license = license.trim();
    }

    public String getConcentrationId() {
        return concentrationId.trim();
    }

    public void setConcentrationId(String concentrationId) {
        this.concentrationId = concentrationId.trim();
    }

    public String getSensorName() {
        return sensorName.trim();
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName.trim();
    }
}
