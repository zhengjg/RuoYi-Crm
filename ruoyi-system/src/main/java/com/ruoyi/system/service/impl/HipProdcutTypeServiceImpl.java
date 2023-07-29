package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HipProdcutTypeMapper;
import com.ruoyi.system.domain.HipProdcutType;
import com.ruoyi.system.service.IHipProdcutTypeService;

/**
 * 产品类别Service业务层处理
 * 
 * @author kevin
 * @date 2023-07-28
 */
@Service
public class HipProdcutTypeServiceImpl implements IHipProdcutTypeService 
{
    @Autowired
    private HipProdcutTypeMapper hipProdcutTypeMapper;

    /**
     * 查询产品类别
     * 
     * @param typeId 产品类别主键
     * @return 产品类别
     */
    @Override
    public HipProdcutType selectHipProdcutTypeByTypeId(Integer typeId)
    {
        return hipProdcutTypeMapper.selectHipProdcutTypeByTypeId(typeId);
    }

    /**
     * 查询产品类别列表
     * 
     * @param hipProdcutType 产品类别
     * @return 产品类别
     */
    @Override
    public List<HipProdcutType> selectHipProdcutTypeList(HipProdcutType hipProdcutType)
    {
        return hipProdcutTypeMapper.selectHipProdcutTypeList(hipProdcutType);
    }

    /**
     * 新增产品类别
     * 
     * @param hipProdcutType 产品类别
     * @return 结果
     */
    @Override
    public int insertHipProdcutType(HipProdcutType hipProdcutType)
    {
        hipProdcutType.setCreateTime(DateUtils.getNowDate());
        return hipProdcutTypeMapper.insertHipProdcutType(hipProdcutType);
    }

    /**
     * 修改产品类别
     * 
     * @param hipProdcutType 产品类别
     * @return 结果
     */
    @Override
    public int updateHipProdcutType(HipProdcutType hipProdcutType)
    {
        return hipProdcutTypeMapper.updateHipProdcutType(hipProdcutType);
    }

    /**
     * 批量删除产品类别
     * 
     * @param typeIds 需要删除的产品类别主键
     * @return 结果
     */
    @Override
    public int deleteHipProdcutTypeByTypeIds(Integer[] typeIds)
    {
        return hipProdcutTypeMapper.deleteHipProdcutTypeByTypeIds(typeIds);
    }

    /**
     * 删除产品类别信息
     * 
     * @param typeId 产品类别主键
     * @return 结果
     */
    @Override
    public int deleteHipProdcutTypeByTypeId(Integer typeId)
    {
        return hipProdcutTypeMapper.deleteHipProdcutTypeByTypeId(typeId);
    }
}
