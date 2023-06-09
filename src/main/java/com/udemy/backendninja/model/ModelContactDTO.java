package com.udemy.backendninja.model;

public class ModelContactDTO {

    private int id;
    private String firstname;
    private String lastname;
    private String telephone;
    private String city;

    public ModelContactDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ModelContactDTO{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", telephone=" + telephone + ", city=" + city + '}';
    }

    
}
