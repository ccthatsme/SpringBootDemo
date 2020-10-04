package com.dinesh.cms.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "customers")
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<OrderEntity> orderList = new HashSet<>();

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

    public Set<OrderEntity> getOrderList() {
        return orderList;
    }

    public void setOrderList(Set<OrderEntity> orderList) {
        this.orderList = orderList;
    }
}
