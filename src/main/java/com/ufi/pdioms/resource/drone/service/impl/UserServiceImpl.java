package com.ufi.pdioms.resource.drone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ufi.pdioms.resource.common.model.PageResult;
import com.ufi.pdioms.resource.drone.dao.UserDao;
import com.ufi.pdioms.resource.drone.model.User;
import com.ufi.pdioms.resource.drone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试使用user业务Service层实现类
 */
@Service
public class UserServiceImpl implements UserService {

        @Autowired
        private UserDao userDao;
    /**
     * 获取所有用户信息列表
     */
    @Override
    public List<User> getUserAll() {
        return userDao.selectAll();
    }

    @Override
    public PageResult getUserAllPage(Integer pageNo, Integer pageSize) {
        //分页设置
        PageHelper.startPage(pageNo,pageSize);
        //查询所有数据信息
        List<User> list = userDao.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        PageResult result = new PageResult(pageInfo.getTotal(), pageInfo.getList(),pageInfo.getPages(),pageInfo.getSize(),pageInfo.getPageNum());
        return result;
   }
}
