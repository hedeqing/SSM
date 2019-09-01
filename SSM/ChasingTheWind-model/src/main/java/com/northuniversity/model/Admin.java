package com.northuniversity.model;

public class Admin {

    private  int id;
    private String name;
    private String password;
    private String number;

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getPassword() {
        return password.trim();
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getNumber() {
        return number.trim();
    }

    public void setNumber(String number) {
        this.number = number.trim();
    }
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name.trim() + '\'' +
                ", password='" + password .trim()+ '\'' +
                ", number='" + number .trim()+ '\'' +
                '}';
    }

}
