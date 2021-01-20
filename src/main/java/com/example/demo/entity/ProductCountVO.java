package com.example.demo.entity;

import java.io.Serializable;


public class ProductCountVO implements Serializable {
    private String name;
    private String count;

    public ProductCountVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
