package com.travelcompany.eshop.model;

import com.travelcompany.eshop.exception.CustomerEmailException;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;
    private String Nationality;
    private String Category;

    public Customer(int id, String name, String email, String address, String nationality, String category) throws CustomerEmailException {
        this.id = id;
        this.name = name;
        setEmail(email);
        this.address = address;
        Nationality = nationality;
        Category = category;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws CustomerEmailException {
        if (email.contains("travelcompany.com"))
            throw new CustomerEmailException("You work here. You can not be a customer.");
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
