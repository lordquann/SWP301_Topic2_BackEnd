package com.example.RegisterLogin.Dto;

import jakarta.validation.constraints.Pattern;

public class UserDTO {
    private int id;
    private String phone;
    private String email;
    private String role;
    private String password;
    public UserDTO() {
    }

    public UserDTO(int id, String phone, String email, String role, String password) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

