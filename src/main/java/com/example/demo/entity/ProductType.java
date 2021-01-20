package com.example.demo.entity;

import java.io.Serializable;

/**
 * (ProductType)实体类
 *
 * @author makejava
 * @since 2021-01-14 05:33:08
 */
public class ProductType implements Serializable {
    private static final long serialVersionUID = -21747699693821281L;

    private Integer id;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}