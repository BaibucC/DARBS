package com.elbike2.model;

public class User {

    private int id;
    private String name;
    private String country;
    private String date1;
    private String date2;
    private Boolean status;
    private Boolean inuse;

    public User() {
    }

    public User(String name, String email, String address, String telephone) {
        this.name = name;
        this.country = email;
        this.date1 = address;
        this.date2 = telephone;
        this.status = status;
        this.inuse = inuse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getInuse() {
        return inuse;
    }

    public void setInuse(Boolean inuse) {
        this.inuse = inuse;
    }

}
