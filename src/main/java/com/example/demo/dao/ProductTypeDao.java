package com.example.demo.dao;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductType;
import com.example.demo.entity.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ProductType)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-14 05:33:09
 */
public interface ProductTypeDao {

    ProductType queryById(Integer integer);
    List<Product> queryAll();
    int insert(ProductType productType);
    int update(ProductType productType);
    int deleteById(Integer id);

}