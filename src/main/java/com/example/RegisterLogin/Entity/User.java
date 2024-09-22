package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;


@Entity
@Table(name="User")

public class User {
    @Id
    @Column(name="id", length = 255)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name="username", length = 255)
    private String username;
    @Column(name="role", length = 255)
    private String role;
    @Column(name="password", length = 255)
    private String password;
    public User() {
    }

    public User(String id, String username, String role, String password) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
