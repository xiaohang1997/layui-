package com.example.demo.service;

import com.example.demo.entity.Ispay;
import com.example.demo.entity.Tip;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Ispay)表服务接口
 *
 * @author makejava
 * @since 2021-01-21 14:44:35
 */
public interface IspayService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Ispay queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Ispay> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param ispay 实例对象
     * @return 实例对象
     */
    Ispay insert(Ispay ispay);

    /**
     * 修改数据
     *
     * @param ispay 实例对象
     * @return 实例对象
     */
    Ispay update(Ispay ispay);

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    boolean deleteByOrderId(Integer orderId);

    PageInfo<Ispay> findAll(int page, int limit);



}