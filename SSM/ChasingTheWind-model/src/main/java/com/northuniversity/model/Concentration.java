package com.northuniversity.model;

public class Concentration {
    private  int id;
    @Override
    public String toString() {
        return "Concentration{" +
                "id=" + id +
                ", concentrationId='" + concentrationId + '\'' +
                ", date='" + date + '\'' +
                ", time=" + time +
                ", data_mg=" + data_mg +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  String concentrationId;
    private String date;
    private int time;
    private  int data_mg;


    public void setDate(String date) {
        this.date = date;
    }

    public int getData_mg() {
        return data_mg;
    }

    public void setData_mg(int data_mg) {
        this.data_mg = data_mg;
    }

    public Concentration() {
    }

    public String getConcentrationId() {
        return concentrationId;
    }

    public void setConcentrationId(String concentrationId) {
        this.concentrationId = concentrationId;
    }



    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

}
