package com.example.demo.service;

import com.example.demo.entity.ProductType;
import com.example.demo.entity.ProductVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (ProductType)表服务接口
 *
 * @author makejava
 * @since 2021-01-14 05:33:10
 */
public interface ProductTypeService {

    PageInfo queryAllByLimit(int page, int limit);
    boolean insert(ProductType productType);
    boolean update(ProductType productType);
    boolean deleteById(Integer id);

}