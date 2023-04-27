package com.example.android14_4.model;

public class Item {
    public int id;
    public String name;
    public double price;

    public String date;

    public Item(int id, String name, double price, String date1, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date1;
        this.category = category;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date1) {
        this.date = date1;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category category;
}
