package com.northuniversity.model;


public class User {
    private  int id;
    private String userName;
    private String password;
    private String gender;
    private String number;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName.trim() + '\'' +
                ", password='" + password.trim() + '\'' +
                ", gender='" + gender.trim() + '\'' +
                ", number='" + number.trim() + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName.trim();
    }

    public void setUserName(String userName) {
        this.userName = userName.trim();
    }

    public String getPassword() {
        return password.trim();
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getGender() {
        return gender.trim();
    }

    public void setGender(String gender) {
        this.gender = gender.trim();
    }

    public String getNumber() {
        return number.trim();
    }

    public void setNumber(String number) {
        this.number = number.trim();
    }

    public User() {
    }
}
