package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Product;
import com.example.demo.entity.Tip;
import com.example.demo.service.TipService;
import com.example.demo.until.JsonResult;
import com.example.demo.until.ResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tip)表控制层
 *
 * @author makejava
 * @since 2021-01-16 09:35:55
 */
@RestController
@RequestMapping("tip")
public class TipController {
    /**
     * 服务对象
     */
    @Resource
    private TipService tipService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public Tip selectOne(Integer id) {
        return this.tipService.queryById(id);
    }

    @RequestMapping("findAll")
    public ResultVO<Tip> findAll(int page, int limit){
        PageInfo pageInfo = tipService.findAll(page,limit);
        int total = (int)pageInfo.getTotal();
        ResultVO<Tip> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("findLastFive")
    public ResultVO<Tip> findLastFive(){
        List<Tip> tips = tipService.findLastFive();
        ResultVO<Tip> resultVO = new ResultVO<>();
        resultVO.setList(tips);
        return resultVO;
    }

    @RequestMapping("insert")
    public JSONObject insert(@RequestBody Tip tip){
        tipService.insert(tip);
        return JsonResult.sendSuccess();
    }

    @RequestMapping("deleteMany")
    public JSONObject deleteMany(String data){
        String strs[] =data.split(",");
        Integer[] integers = new Integer[strs.length];
        for(int i = 0;i<strs.length;i++){
            integers[i]= Integer.parseInt(strs[i]);
            tipService.deleteById(integers[i]);
        }
        return JsonResult.sendSuccess();
    }

    @RequestMapping("deleteById")
    public JSONObject deleteById(Integer id){
        tipService.deleteById(id);
        return JsonResult.sendSuccess();
    }
}