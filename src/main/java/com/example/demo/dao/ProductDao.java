package com.example.demo.dao;

import com.example.demo.entity.OrderVO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductVO;

import java.util.List;

public interface ProductDao {

    List<Product> queryAll(ProductVO productVO);
    int insert(ProductVO productVO);
    int update(ProductVO productVO);
    int deleteById(Integer id);
    Product queryById(Integer id);
    List<ProductVO> searchByName(String name);
    List searchNameAndCount();
    int addProductCountBuId(int id, Long count);
    int subtractProductCountBuId(int id, Long count);

}
