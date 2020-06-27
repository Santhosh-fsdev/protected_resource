package com.santhosh.protected_resource.Model;

import org.springframework.data.annotation.Id;

public class Inventory {

    public Inventory() {
    }

    public Inventory( String item, String name, int quantity, int price) {
        this.item = item;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Id
    public String id;
    public String item;
    public String name;
    public int quantity;
    public int price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
