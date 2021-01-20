package com.example.demo.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private Long count;
    private ProductType type;


    public Product() {
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType productType) {
        this.type = productType;
    }

}
