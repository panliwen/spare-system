package com.ufi.pdioms.resource.manufacturer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ufi.pdioms.resource.common.model.ErrorCode;
import com.ufi.pdioms.resource.common.model.GeneralResult;
import com.ufi.pdioms.resource.common.model.PageResult;
import com.ufi.pdioms.resource.manufacturer.dao.ManufacturerDao;
import com.ufi.pdioms.resource.manufacturer.model.Manufacturer;
import com.ufi.pdioms.resource.manufacturer.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * 厂家业务层实现类
 */
@Service
public class ManufacturerServcieImpl implements ManufacturerService
{

    @Autowired
    private ManufacturerDao manufacturerDao;

    /**
     * 获得厂家所有列表信息
     *
     * @param pageNo       分页起始页
     * @param pageSize     分页页大小
     * @param manufacturer 条件搜索的厂家名称
     * @return 返回搜索结果集
     */
    @Override
    public PageResult getManufacturerInfo(Integer pageNo, Integer pageSize, String manufacturer)
    {
        PageHelper.startPage(pageNo,pageSize); //分页参数设置
        if (StringUtil.isEmpty(manufacturer)) {
            Example example = new Example(Manufacturer.class);
            example.createCriteria().andEqualTo("isDelete",0);
            List<Manufacturer> manufacturers = manufacturerDao.selectByExample(example);
            PageInfo<Manufacturer> pageInfo = new PageInfo<>(manufacturers);
            PageResult result = new PageResult(pageInfo.getTotal(), pageInfo.getList(), pageInfo.getPages(), pageInfo.getSize(), pageInfo.getPageNum());
            return result;
        }
        //厂家搜索名称《不》等于空的情况下，进行搜索分页查询
        Example example = new Example(Manufacturer.class);
        example.createCriteria().andEqualTo("manufacturer",manufacturer);
        example.createCriteria().andEqualTo("isDelete",0);
        List<Manufacturer> manufacturers = manufacturerDao.selectByExample(example);
        PageInfo<Manufacturer> pageInfo = new PageInfo<>(manufacturers);
        PageResult result = new PageResult(pageInfo.getTotal(), pageInfo.getList(), pageInfo.getPages(), pageInfo.getSize(), pageInfo.getPageNum());
        return result;
    }

    /**
     * 新增厂家信息
     *
     * @param manufacturer 厂家对象信息
     * @param result       结果说明
     */
    @Transactional
    public void addManufacturerInfo(Manufacturer manufacturer, GeneralResult result)
    {
        Example example = new Example(Manufacturer.class);
        example.createCriteria().andEqualTo("isDelete",0);
        List<Manufacturer> manufacturers = manufacturerDao.selectByExample(example);
        for (Manufacturer manufacturer1 : manufacturers) {
            if (manufacturer1.getManufacturer().equals(manufacturer.getManufacturer())) {
                result.setErr(ErrorCode.NAME_AND_EXIST);
                return;
            }
        }
        manufacturerDao.insert(manufacturer);
        return;
    }

    /**
     * @param manufacturerId 厂家id值
     * @param result         结果说明
     */
    @Transactional
    public void deleteManufacturerInfo(long manufacturerId, GeneralResult result)
    {
        Manufacturer manufacturer= new Manufacturer();
        manufacturer.setId(manufacturerId);
        manufacturer.setIsDelete(1);
        manufacturerDao.updateByPrimaryKeySelective(manufacturer);
    }
}
