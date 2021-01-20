package com.example.demo.dao;

import com.example.demo.entity.Tip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Tip)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-16 09:35:54
 */
public interface TipDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Tip queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Tip> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tip 实例对象
     * @return 对象列表
     */
    List<Tip> queryAll(Tip tip);

    /**
     * 新增数据
     *
     * @param tip 实例对象
     * @return 影响行数
     */
    int insert(Tip tip);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Tip> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Tip> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Tip> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Tip> entities);

    /**
     * 修改数据
     *
     * @param tip 实例对象
     * @return 影响行数
     */
    int update(Tip tip);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Tip> findLastFive();



}