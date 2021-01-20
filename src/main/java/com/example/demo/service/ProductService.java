package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    PageInfo queryAllByLimit(int page, int limit);
    boolean insert(ProductVO productVO);
    boolean update(ProductVO productVO);
    boolean deleteById(Integer id);
    PageInfo queryAll(int page, int limit, ProductVO productVO);
    List searchNameAndCount();

}
