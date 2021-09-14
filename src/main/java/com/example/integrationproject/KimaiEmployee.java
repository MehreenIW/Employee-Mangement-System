package com.example.integrationproject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class KimaiEmployee {
    @JsonProperty("id")
    protected int id;

    @JsonProperty("username")
    protected String username;


    @JsonProperty("email")
    protected String email;

    @JsonProperty("roles")
    protected String[] role;

    public int getId() {
        return id;
    }


    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getplainPassword() {
        return plainPassword;
    }

    public void setplainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    @JsonProperty("plainPassword")
    protected String plainPassword;

    @Override
    public String toString() {
        return "Employee{" +
                " username='" + username + '\'' +
                ", role=" + Arrays.toString(role) +
                '}';
    }

    public KimaiEmployee(String username, String plainPassword, String[] role) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.plainPassword = plainPassword;
    }
     public KimaiEmployee(){

     }


    public String getFirstName() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.username = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

}
