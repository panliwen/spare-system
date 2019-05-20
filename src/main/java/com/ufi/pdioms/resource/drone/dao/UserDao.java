package com.ufi.pdioms.resource.drone.dao;

import com.ufi.pdioms.resource.drone.model.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * mapper访问层接口，使用通用mapper访问持久层。
 */
@org.apache.ibatis.annotations.Mapper
public interface UserDao  extends Mapper<User>{
}
