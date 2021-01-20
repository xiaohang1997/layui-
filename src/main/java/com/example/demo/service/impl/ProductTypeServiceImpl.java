package com.example.demo.service.impl;

import com.example.demo.dao.ProductTypeDao;
import com.example.demo.entity.ProductType;
import com.example.demo.entity.ProductVO;
import com.example.demo.service.ProductTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProductType)表服务实现类
 *
 * @author makejava
 * @since 2021-01-14 05:33:11
 */
@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {
    @Resource
    private ProductTypeDao productTypeDao;

    @Override
    public PageInfo queryAllByLimit(int page, int limit) {
        PageHelper.startPage(page, limit);
        List  list = productTypeDao.queryAll();
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    public boolean insert(ProductType productType) {

        return productTypeDao.insert(productType) > 0;
    }

    @Override
    public boolean update(ProductType productType) {
        return productTypeDao.update(productType) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return productTypeDao.deleteById(id)>0;
    }

}