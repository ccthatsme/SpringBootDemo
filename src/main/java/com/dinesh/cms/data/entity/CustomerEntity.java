package com.dinesh.cms.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    //@JsonProperty("id")
    private int id;

    @Column(name = "first_name", nullable = false)
    //@JsonProperty("first")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    //@JsonProperty("last")
    private String lastName;

    @Column(name = "email", nullable = true)
    //@JsonProperty("email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
