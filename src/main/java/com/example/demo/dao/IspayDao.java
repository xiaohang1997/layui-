package com.example.demo.dao;

import com.example.demo.entity.Ispay;
import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Ispay)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-21 14:44:34
 */
public interface IspayDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Ispay queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Ispay> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ispay 实例对象
     * @return 对象列表
     */
    List<Ispay> queryAll(Ispay ispay);

    /**
     * 新增数据
     *
     * @param ispay 实例对象
     * @return 影响行数
     */
    int insert(Ispay ispay);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Ispay> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Ispay> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Ispay> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Ispay> entities);

    /**
     * 修改数据
     *
     * @param ispay 实例对象
     * @return 影响行数
     */
    int update(Ispay ispay);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteByOrderId(Integer orderId);



}