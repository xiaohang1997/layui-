package com.example.demo.controller;

import com.example.demo.entity.Ispay;
import com.example.demo.entity.Tip;
import com.example.demo.service.IspayService;
import com.example.demo.until.ResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Ispay)表控制层
 *
 * @author makejava
 * @since 2021-01-21 14:44:37
 */
@RestController
@RequestMapping("ispay")
public class IspayController {
    /**
     * 服务对象
     */
    @Resource
    private IspayService ispayService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Ispay selectOne(Integer id) {
        return this.ispayService.queryById(id);
    }


    @RequestMapping("findAll")
    public ResultVO<Ispay> findAll(int page, int limit){
        PageInfo pageInfo = ispayService.findAll(page,limit);
        int total = (int)pageInfo.getTotal();
        ResultVO<Ispay> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }
}