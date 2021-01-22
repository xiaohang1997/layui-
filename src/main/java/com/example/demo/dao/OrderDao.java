package com.example.demo.dao;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderVO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductVO;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface OrderDao {

    List<Order> queryAll();
    int insert(OrderVO order);
    int update(OrderVO order);
    int deleteById(Integer id);
    List<Order> searchByProId(Integer id);
    List<Order> searchByCompany(String company);
    List<Order> selectTime();
}
