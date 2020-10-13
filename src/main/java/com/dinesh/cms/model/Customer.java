package com.dinesh.cms.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

//    @JsonProperty("id")
    private int customerId;
//    @JsonProperty("first")
    private String firstName;
//    @JsonProperty("last")
    private String lastName;
//    @JsonProperty("email")
    private String email;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
