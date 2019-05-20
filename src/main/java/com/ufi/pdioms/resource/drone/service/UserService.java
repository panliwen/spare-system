package com.ufi.pdioms.resource.drone.service;
import com.ufi.pdioms.resource.base.PageResult;
import com.ufi.pdioms.resource.drone.model.User;

import java.util.List;

/**
 * 测试使用User业务接口
 */
public interface UserService {
    /**获取所有用户信息列表*/
    List<User> getUserAll();

    PageResult getUserAllPage(Integer pageNo, Integer pageSize);
}
