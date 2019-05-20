package com.ufi.pdioms.resource.base;

import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 基础BaseService
 *
 * @author xufuzhou
 */
public interface BaseService<T> {

    List<T> selectAll();

    T selectByPrimaryKey(Object o);

    int selectCount(T t);

    List<T> select(T t);

    T selectOne(T t);

    List<T> selectByExample(Object o);

    int selectCountByExample(Object o);

    T selectOneByExample(Object o);

    List<T> selectByExampleAndRowBounds(Object o, RowBounds rowBounds);

    List<T> selectByRowBounds(T t, RowBounds rowBounds);

     Object insert(T t);

    int insertSelective(T t);

    int deleteByPrimaryKey(Object o);

    int delete(T t);

    int deleteByExample(Object o);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

    int updateByExample(T t, Object o);

    int updateByExampleSelective(T t, Object o);

    boolean existsWithPrimaryKey(Object o);
}
