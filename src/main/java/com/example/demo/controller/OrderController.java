package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.*;
import com.example.demo.service.IspayService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import com.example.demo.until.JsonResult;
import com.example.demo.until.ResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private IspayService ispayService;


    @GetMapping("queryAll")
    public ResultVO queryAllByLimit(int page, int limit){
        PageInfo pageInfo = orderService.queryAllByLimit(page,limit);
        int total = (int)pageInfo.getTotal();
        ResultVO<Order> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("insert")
    public JSONObject insert(@RequestBody OrderVO orderVO){
        if (orderService.insert(orderVO)){
            return JsonResult.sendSuccess();
        }
        else return JsonResult.sendError();
    }

    @RequestMapping("update")
    public JSONObject update(@RequestBody OrderVO orderVO){
        if (orderService.update(orderVO)){
            return JsonResult.sendSuccess();
        }
        else return JsonResult.sendError();
    }

    @RequestMapping("deleteMany")
    public JSONObject deleteMany(@RequestParam(name = "data") List<Integer> data){
        for (Integer integer: data){
            if (!orderService.deleteById(integer)){
                return JsonResult.sendError();
            }
        }
        return JsonResult.sendSuccess();
    }

    @RequestMapping("deleteById")
    public JSONObject deleteById(Integer id){
        boolean b = orderService.deleteById(id);
        if (b){
            return JsonResult.sendSuccess();
        }
        else return JsonResult.sendError();
    }

    @RequestMapping("search")
    public ResultVO search(Integer page, Integer limit, @RequestParam Map<String, String> map){
        String searchParams = map.get("searchParams");
        String productName = searchParams.split("\"")[3];
        String company = searchParams.split("\"")[7];
        ResultVO resultVO = new ResultVO();
        if (!productName.isEmpty() && company.isEmpty()){
            List list = orderService.searchByProductName(productName);
            resultVO.setList(list);
            return resultVO;
        }else if(!company.isEmpty() && productName.isEmpty()){
            List list = orderService.searchByCompany(company);
            resultVO.setList(list);
            return resultVO;
        }else if (searchParams.isEmpty()){
            return resultVO;
        }else if (!productName.isEmpty() && !company.isEmpty()){
            List list = orderService.searchTwo(productName,company);
            return resultVO;
        }
        return resultVO;
    }

    @RequestMapping("change")
    public JSONObject update(@RequestBody Change change){
         String is = change.getIs();
         Integer productId = change.getProductId();
         Long productCount = change.getProductCount();
         Integer ispay = change.getIspay();
         Integer isdel = change.getIsdel();
         Integer id = change.getId();
         OrderVO orderVO = new OrderVO();
         orderVO.setId(id);
         orderVO.setIsdel(isdel);
         orderVO.setIspay(ispay);
         orderService.update(orderVO);
         orderService.change(is, productId, productCount);
         if (ispay == 1){
             ispayService.deleteByOrderId(id);
         }
         return JsonResult.sendSuccess();
    }

}
