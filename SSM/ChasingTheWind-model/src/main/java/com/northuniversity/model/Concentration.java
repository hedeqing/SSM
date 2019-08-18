package com.northuniversity.model;

public class Concentration {
    private  String concentrationId;
    private String data;
    private  String time0;
    private  String time4;
    private  String time8;
    private  String time12;

    private  String time16;
    private  String time20;

    public Concentration() {
    }

    @Override
    public String toString() {
        return "Concentration{" +
                "concentrationId='" + concentrationId + '\'' +
                ", data='" + data + '\'' +
                ", time0='" + time0 + '\'' +
                ", time4='" + time4 + '\'' +
                ", time8='" + time8 + '\'' +
                ", time12='" + time12 + '\'' +
                ", time16='" + time16 + '\'' +
                ", time20='" + time20 + '\'' +
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

    public String getTime0() {
        return time0;
    }

    public void setTime0(String time0) {
        this.time0 = time0;
    }

    public String getTime4() {
        return time4;
    }

    public void setTime4(String time4) {
        this.time4 = time4;
    }

    public String getTime8() {
        return time8;
    }

    public void setTime8(String time8) {
        this.time8 = time8;
    }

    public String getTime12() {
        return time12;
    }

    public void setTime12(String time12) {
        this.time12 = time12;
    }

    public String getTime16() {
        return time16;
    }

    public void setTime16(String time16) {
        this.time16 = time16;
    }

    public String getTime20() {
        return time20;
    }

    public void setTime20(String time20) {
        this.time20 = time20;
    }
}
