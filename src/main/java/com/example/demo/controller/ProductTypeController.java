package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.ProductDao;
import com.example.demo.dao.ProductTypeDao;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductType;
import com.example.demo.entity.ProductVO;
import com.example.demo.service.ProductTypeService;
import com.example.demo.until.JsonResult;
import com.example.demo.until.ResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProductType)表控制层
 *
 * @author makejava
 * @since 2021-01-14 05:33:11
 */
@RestController
@RequestMapping("productType")
public class ProductTypeController {
    /**
     * 服务对象
     */
    @Resource
    private ProductTypeService productTypeService;

    @Resource
    private ProductTypeDao productTypeDao;

    @GetMapping("queryAll")
    public ResultVO queryAllByLimit(int page, int limit){
        PageInfo pageInfo = productTypeService.queryAllByLimit(page,limit);
        int total = (int)pageInfo.getTotal();
        ResultVO<Product> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("insert")
    public JSONObject insert(@RequestBody ProductType productType){
        if (productTypeService.insert(productType)){
            return JsonResult.sendSuccess();
        }
        else return JsonResult.sendError();
    }

    @RequestMapping("update")
    public JSONObject update(@RequestBody ProductType productType){
        if (productTypeService.update(productType)){
            return JsonResult.sendSuccess();
        }
        else return JsonResult.sendError();
    }

    @RequestMapping("deleteMany")
    public JSONObject deleteMany(@RequestParam(name = "data") List<Integer> data){
        for (Integer integer: data){
            if (!productTypeService.deleteById(integer)){
                return JsonResult.sendError();
            }
        }
        return JsonResult.sendSuccess();
    }

    @RequestMapping("deleteById")
    public JSONObject deleteById(Integer id){
        if (productTypeService.deleteById(id)){
            return JsonResult.sendSuccess();
        }
        else return JsonResult.sendError();
    }

    @RequestMapping("findAll")
    public ResultVO<ProductType> findAll(){
        ResultVO<ProductType> resultVO = new ResultVO<>();
        List list = productTypeDao.queryAll();
        resultVO.setList(list);
        return resultVO;
    }


}