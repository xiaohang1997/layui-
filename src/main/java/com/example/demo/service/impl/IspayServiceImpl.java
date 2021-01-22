package com.example.demo.service.impl;

import com.example.demo.dao.IspayDao;
import com.example.demo.entity.Ispay;
import com.example.demo.service.IspayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Ispay)表服务实现类
 *
 * @author makejava
 * @since 2021-01-21 14:44:36
 */
@Service("ispayService")
public class IspayServiceImpl implements IspayService {
    @Resource
    private IspayDao ispayDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Ispay queryById(Integer id) {
        return this.ispayDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Ispay> queryAllByLimit(int offset, int limit) {
        return this.ispayDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ispay 实例对象
     * @return 实例对象
     */
    @Override
    public Ispay insert(Ispay ispay) {
        this.ispayDao.insert(ispay);
        return ispay;
    }

    /**
     * 修改数据
     *
     * @param ispay 实例对象
     * @return 实例对象
     */
    @Override
    public Ispay update(Ispay ispay) {
        this.ispayDao.update(ispay);
        return this.queryById(ispay.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByOrderId(Integer orderId) {
        return this.ispayDao.deleteByOrderId(orderId) > 0;
    }

    @Override
    public PageInfo<Ispay> findAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        List  list = ispayDao.queryAll(null);
        PageInfo result = new PageInfo(list);
        return result;
    }
}