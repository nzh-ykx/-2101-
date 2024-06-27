package com.example.entity;

public class Account {
    private String username;
    private  String password;
    private  String name;
    private  String role;//通过role字段来区分管理员和学生

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String rule) {
        this.role = rule;
    }
}
