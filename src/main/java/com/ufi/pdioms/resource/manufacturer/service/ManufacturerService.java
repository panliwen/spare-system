package com.ufi.pdioms.resource.manufacturer.service;

import com.ufi.pdioms.resource.common.model.GeneralResult;
import com.ufi.pdioms.resource.common.model.PageResult;
import com.ufi.pdioms.resource.manufacturer.model.Manufacturer;

/**
 * 厂家业务层接口
 */
public interface ManufacturerService
{
    /**
     *获得厂家所有列表信息
     * @param pageNo  分页起始页
     * @param pageSize  分页页大小
     * @param manufacturer  条件搜索的厂家名称
     * @return  返回搜索结果集
     */
    PageResult getManufacturerInfo(Integer pageNo, Integer pageSize, String manufacturer);

    /**
     * 新增厂家信息
     * @param manufacturer  厂家对象信息
     * @param result  结果说明
     */
    void addManufacturerInfo(Manufacturer manufacturer, GeneralResult result);

    /**
     *
     * @param manufacturerId  厂家id值
     * @param result  结果说明
     */
    void deleteManufacturerInfo(long manufacturerId, GeneralResult result);
}
