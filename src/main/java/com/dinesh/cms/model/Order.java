package com.dinesh.cms.model;

import java.util.Date;

public class Order {

    private int itemId;
    private int weightPounds;
    private Date date;
    private Customer customer;

    public Order(int itemId, int weightPounds, Date date, Customer customer) {
        this.itemId = itemId;
        this.weightPounds = weightPounds;
        this.date = date;
        this.customer = customer;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getWeightPounds() {
        return weightPounds;
    }

    public void setWeightPounds(int weightPounds) {
        this.weightPounds = weightPounds;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
