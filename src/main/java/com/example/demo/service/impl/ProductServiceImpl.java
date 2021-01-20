package com.example.demo.service.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductVO;
import com.example.demo.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public PageInfo queryAllByLimit(int page, int limit) {

        PageHelper.startPage(page, limit);
        List  list = productDao.queryAll(null);
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    public boolean insert(ProductVO productVO) {

        return productDao.insert(productVO) > 0;
    }

    @Override
    public boolean update(ProductVO productVO) {
        return productDao.update(productVO) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        boolean b = productDao.deleteById(id) > 0;
        return b;
    }

    public PageInfo queryAll(int page, int limit, ProductVO productVO){
        PageHelper.startPage(page, limit);
        List list = productDao.queryAll(productVO);
        PageInfo result = new PageInfo(list);
        return result;
    }

    public List searchNameAndCount(){
        return productDao.searchNameAndCount();
    }



}
