package com.northuniversity.model;

public class Concentration {
    private  String concentrationId;
    private String data;
    private  String time0_mg;
    private  String time4_mg;
    private  String time8_mg;
    private  String time12_mg;

    private  String time16_mg;
    private  String time20_mg;

    public Concentration() {
    }

    @Override
    public String toString() {
        return "Concentration{" +
                "concentrationId='" + concentrationId + '\'' +
                ", data='" + data + '\'' +
                ", time0_mg='" + time0_mg + '\'' +
                ", time4_mg='" + time4_mg + '\'' +
                ", time8_mg='" + time8_mg + '\'' +
                ", time12_mg='" + time12_mg + '\'' +
                ", time16_mg='" + time16_mg + '\'' +
                ", time20_mg='" + time20_mg + '\'' +
                '}';
    }

    public String getConcentrationId() {
        return concentrationId;
    }

    public void setConcentrationId(String concentrationId) {
        this.concentrationId = concentrationId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime0_mg() {
        return time0_mg;
    }

    public void setTime0_mg(String time0_mg) {
        this.time0_mg = time0_mg;
    }

    public String getTime4_mg() {
        return time4_mg;
    }

    public void setTime4_mg(String time4_mg) {
        this.time4_mg = time4_mg;
    }

    public String getTime8_mg() {
        return time8_mg;
    }

    public void setTime8_mg(String time8_mg) {
        this.time8_mg = time8_mg;
    }

    public String getTime12_mg() {
        return time12_mg;
    }

    public void setTime12_mg(String time12_mg) {
        this.time12_mg = time12_mg;
    }

    public String getTime16_mg() {
        return time16_mg;
    }

    public void setTime16_mg(String time16_mg) {
        this.time16_mg = time16_mg;
    }

    public String getTime20_mg() {
        return time20_mg;
    }

    public void setTime20_mg(String time20_mg) {
        this.time20_mg = time20_mg;
    }
}
