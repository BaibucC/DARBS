/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elbike2.model;

import javax.validation.constraints.NotEmpty;

public class Bike {

    private int id;
    private String bikename;
    private Boolean status;
    private Boolean inuse;

    public Bike() {
    }

    public Bike(String bikename, Boolean status, Boolean inuse) {
        this.id = id;
        this.bikename = bikename;
        this.status = status;
        this.inuse = inuse;
    }

    /**
     * @return the bikename
     */
    public String getBikename() {
        return bikename;
    }

    /**
     * @param bikename the bikename to set
     */
    public void setBikename(String bikename) {
        this.bikename = bikename;
    }

    /**
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return the inuse
     */
    public Boolean getInuse() {
        return inuse;
    }

    /**
     * @param inuse the inuse to set
     */
    public void setInuse(Boolean inuse) {
        this.inuse = inuse;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
