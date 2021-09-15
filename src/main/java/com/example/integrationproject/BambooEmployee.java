package com.example.integrationproject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BambooEmployee {
    private String firstName;
    private String lastName;
    private String role;

    public BambooEmployee(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public void setFirstName(String name) {
        this.firstName = firstName;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("jobTitle")
    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

