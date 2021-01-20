package com.example.demo.service;

import com.example.demo.entity.Tip;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Tip)表服务接口
 *
 * @author makejava
 * @since 2021-01-16 09:35:54
 */
public interface TipService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Tip queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Tip> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tip 实例对象
     * @return 实例对象
     */
    Tip insert(Tip tip);

    /**
     * 修改数据
     *
     * @param tip 实例对象
     * @return 实例对象
     */
    Tip update(Tip tip);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Tip> findLastFive();

    PageInfo<Tip> findAll(int page, int limit);

}