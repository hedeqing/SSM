package com.northuniversity.model;

public class Sensor {
    private int id;

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", license='" + license + '\'' +
                ", concentrationId='" + concentrationId + '\'' +
                ", sensorName='" + sensorName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  String license;
    private  String concentrationId;
    private  String sensorName;

    public Sensor() {
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
