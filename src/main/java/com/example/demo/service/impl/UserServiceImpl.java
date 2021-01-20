package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.until.JsonResult;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-01-13 14:51:23
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }


    @Override
    public List<User> queryAll(User userAdmin) {
        return userDao.queryAll(userAdmin);
    }


    public PageInfo findAll(int page, int limit){
        PageHelper.startPage(page, limit);
        List  list = userDao.queryAll(null);
        PageInfo result = new PageInfo(list);
        return result;
    }

    public int update(User user){
        return userDao.update(user);
    }

    public int insert(User user){
        return userDao.insert(user);
    }

    public int deleteById(Integer id){
        return userDao.deleteById(id);
    }

    @Override
    public PageInfo<User> findByName(int page, int limit, String name) {
        PageHelper.startPage(page, limit);
        User user = new User();
        user.setName(name);
        List  list = userDao.queryAll(user);
        PageInfo result = new PageInfo(list);
        return result;
    }
}