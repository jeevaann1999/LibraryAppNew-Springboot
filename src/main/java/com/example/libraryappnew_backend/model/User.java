package com.example.libraryappnew_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userReg")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String aadhar;
    private String address;
    private int pincode;
    private String dob;
    private String email;
    private int phone;
    private String username;
    private String password;
    private String confirm;

    public User() {
    }

    public User(int id, String name, String aadhar, String address, int pincode, String dob, String email, int phone, String username, String password, String confirm) {
        this.id = id;
        this.name = name;
        this.aadhar = aadhar;
        this.address = address;
        this.pincode = pincode;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.confirm = confirm;
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

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
