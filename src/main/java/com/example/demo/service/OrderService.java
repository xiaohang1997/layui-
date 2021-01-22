package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderVO;
import com.example.demo.entity.ProductVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {
    PageInfo queryAllByLimit(int page, int limit);
    boolean insert(OrderVO orderVO);
    boolean update(OrderVO orderVO);
    boolean deleteById(Integer id);
    public List searchByProductName(String productName);
    List searchByCompany(String string);
    List<Order> searchTwo(String productName, String company);
    int subtractProductCountBuId(OrderVO orderVO);
    int addProductCountBuId(OrderVO orderVO);
    void change(String is, int id, Long count);
    void selectTime();
}
