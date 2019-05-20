package com.ufi.pdioms.resource.base.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ufi.pdioms.resource.base.BaseService;
import com.ufi.pdioms.resource.base.PageResult;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 基础BaseService
 *
 * @author xufuzhou
 */
public abstract class BaseServiceImpl<T, M extends Mapper<T>> implements BaseService<T> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected M mapper;

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public T selectByPrimaryKey(Object o) {
        return mapper.selectByPrimaryKey(o);
    }

    @Override
    public int selectCount(T t) {
        return mapper.selectCount(t);
    }

    @Override
    public List<T> select(T t) {
        return mapper.select(t);
    }

    @Override
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    @Override
    public List<T> selectByExample(Object o) {
        return mapper.selectByExample(o);
    }

    @Override
    public int selectCountByExample(Object o) {
        return mapper.selectCountByExample(o);
    }

    @Override
    public T selectOneByExample(Object o) {
        return mapper.selectOneByExample(o);
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return mapper.selectByExampleAndRowBounds(o, rowBounds);
    }

    @Override
    public List<T> selectByRowBounds(T t, RowBounds rowBounds) {
        return mapper.selectByRowBounds(t, rowBounds);
    }

    @Override
    @Transactional
    public Object insert(T t) {
        return mapper.insert(t);
    }

    @Override
    @Transactional
    public int insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Object o) {
        return mapper.deleteByPrimaryKey(o);
    }

    @Override
    @Transactional
    public int delete(T t) {
        return mapper.delete(t);
    }

    @Override
    @Transactional
    public int deleteByExample(Object o) {
        return mapper.deleteByExample(o);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    @Transactional
    public int updateByExample(T t, Object o) {
        return mapper.updateByExample(t, o);
    }

    @Override
    @Transactional
    public int updateByExampleSelective(T t, Object o) {
        return mapper.updateByExampleSelective(t, o);
    }

    @Override
    public boolean existsWithPrimaryKey(Object o) {
        return mapper.existsWithPrimaryKey(o);
    }

    @Override
    public PageResult selectPage(Integer page, Integer pageSize) {
        //设置分页
        PageHelper.startPage(page, pageSize);
        //查询
        List<T> list = mapper.selectAll();
        //创建分页信息对象
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList(),pageInfo.getPages(),pageInfo.getPageSize(),pageInfo.getPrePage());
    }

    @Override
    public PageResult selectPageObject(Integer page, Integer pageSize, T t) {
        //设置分页
        PageHelper.startPage(page, pageSize);
        //查询
        List<T> list = mapper.select(t);
        //创建分页信息对象
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList(),pageInfo.getPages(),pageInfo.getPageSize(),pageInfo.getPrePage());
    }

}
