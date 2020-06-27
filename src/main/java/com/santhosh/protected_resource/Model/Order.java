package com.santhosh.protected_resource.Model;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class Order {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    private String id;

    public Order(String username, String name, Date date) {
        this.username = username;
        this.name = name;
        this.date = date;
    }

    private String username;

    public Order() {
    }

    private String name;
    private Date date;
}
