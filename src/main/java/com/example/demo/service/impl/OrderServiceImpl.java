package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderVO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductVO;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private ProductDao productDao;


    @Override
    public PageInfo queryAllByLimit(int page, int limit) {
        PageHelper.startPage(page, limit);
        List list = orderDao.queryAll();
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    public boolean insert(OrderVO orderVO) {
        Long count = orderVO.getProductCount();
        Long productCount = productDao.queryById(orderVO.getProductId()).getCount();
        if (count > productCount){
            return false;
        }
        int productId = orderVO.getProductId();
        productDao.subtractProductCountBuId(productId, count);
        return orderDao.insert(orderVO) > 0;
    }

    @Override
    public boolean update(OrderVO orderVO) {
        return orderDao.update(orderVO) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return orderDao.deleteById(id) > 0;
    }

    public List<Order> searchByProductName(String productName){
        List orders = new ArrayList();
        List<ProductVO> products = productDao.searchByName(productName);
        for (ProductVO product : products){
            orders.addAll(orderDao.searchByProId(product.getId()));
        }
        return orders;
    }

    @Override
    public List searchByCompany(String string) {
        List list = orderDao.searchByCompany(string);
        return list;
    }

    public List<Order> searchTwo(String productName, String company){
        return null;
    }

    @Override
    public int subtractProductCountBuId(OrderVO orderVO) {
        Integer id = orderVO.getProductId();
        Long count = orderVO.getProductCount();
        return productDao.subtractProductCountBuId(id, count);
    }

    @Override
    public int addProductCountBuId(OrderVO orderVO) {
        Integer id = orderVO.getProductId();
        Long count = orderVO.getProductCount();
        return productDao.addProductCountBuId(id, count);
    }

    @Override
    public void change(String is, int id, Long count) {
        if (is.equals("jia")){
            productDao.addProductCountBuId(id, count);
        }
        else if (is.equals("jian")){
            productDao.subtractProductCountBuId(id, count);
        }
    }
}
