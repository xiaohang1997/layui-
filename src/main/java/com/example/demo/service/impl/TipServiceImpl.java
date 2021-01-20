package com.example.demo.service.impl;

import com.example.demo.dao.TipDao;
import com.example.demo.entity.Tip;
import com.example.demo.service.TipService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tip)表服务实现类
 *
 * @author makejava
 * @since 2021-01-16 09:35:54
 */
@Service("tipService")
public class TipServiceImpl implements TipService {
    @Resource
    private TipDao tipDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Tip queryById(Integer id) {
        return this.tipDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Tip> queryAllByLimit(int offset, int limit) {
        return this.tipDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tip 实例对象
     * @return 实例对象
     */
    @Override
    public Tip insert(Tip tip) {
        this.tipDao.insert(tip);
        return tip;
    }

    /**
     * 修改数据
     *
     * @param tip 实例对象
     * @return 实例对象
     */
    @Override
    public Tip update(Tip tip) {
        this.tipDao.update(tip);
        return this.queryById(tip.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tipDao.deleteById(id) > 0;
    }

    @Override
    public List<Tip> findLastFive() {
        return tipDao.findLastFive();
    }

    @Override
    public PageInfo<Tip> findAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        List  list = tipDao.queryAll(null);
        PageInfo result = new PageInfo(list);
        return result;
    }
}