package com.travelcompany.eshop.model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;
    private String Nationality;
    private String Category;

    public Customer(int id, String name, String email, String address, String nationality, String category) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public void setEmail(String email) {
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
