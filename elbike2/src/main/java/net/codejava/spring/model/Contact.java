package net.codejava.spring.model;

public class Contact {

    private int id;
    private String name;
    private String country;
    private String date1;
    private String date2;

    public Contact() {
    }

    public Contact(String name, String email, String address, String telephone) {
        this.name = name;
        this.country = email;
        this.date1 = address;
        this.date2 = telephone;
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

}
