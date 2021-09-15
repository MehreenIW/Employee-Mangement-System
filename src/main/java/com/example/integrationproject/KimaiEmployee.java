package com.example.integrationproject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class KimaiEmployee {

    public KimaiEmployee(String username, String plainPassword, String[] role) {
        this.username = username;
        this.role = role;
        this.plainPassword = plainPassword;
    }

    public KimaiEmployee() {

    }

    @JsonProperty("id")
    protected int id;

    @JsonProperty("username")
    protected String username;

    @JsonProperty("roles")
    protected String[] role;

    @JsonProperty("plainPassword")
    protected String plainPassword;

    public int getId() {
        return id;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public String getplainPassword() {
        return plainPassword;
    }

    public void setplainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    @Override
    public String toString() {
        return "Employee{" +
                " username='" + username + '\'' +
                ", role=" + Arrays.toString(role) +
                '}';
    }

}
