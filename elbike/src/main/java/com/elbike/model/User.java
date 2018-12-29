package com.elbike.model;

import java.util.List;

public class User {

    /**
     * @return the date1
     */
    
    // form:hidden - hidden value

    Integer id;

    // form:input - textbox
    String name;

    // form:input - textbox
    String date1;

    // form:input - textbox
    String date2;

    // form:radiobutton - radio button
    String sex;

    // form:select - form:option - dropdown - single select
    String country;

    // form:select - multiple=true - dropdown - multiple select
    List<String> skill;
    
    
    public User(){
    }
    
    public User(Integer id, String name, String date1, String date2, String sex, String country, List<String> skill){
        this.id = id;
        this.name = name;
        this.date1 = date1;
        this.date2 = date2;
        this.sex = sex;
        this.country = country;
        this.skill = skill;        
    }

    public boolean isNew() {
        return (this.id == null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", date1=" + date1 
                + ", date2=" + date2 + ", sex=" + sex + ", country=" + country + "]" + isNew();
    }

}
