package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HipProdcutType;

/**
 * 产品类别Mapper接口
 * 
 * @author kevin
 * @date 2023-07-28
 */
public interface HipProdcutTypeMapper 
{
    /**
     * 查询产品类别
     * 
     * @param typeId 产品类别主键
     * @return 产品类别
     */
    public HipProdcutType selectHipProdcutTypeByTypeId(Integer typeId);

    /**
     * 查询产品类别列表
     * 
     * @param hipProdcutType 产品类别
     * @return 产品类别集合
     */
    public List<HipProdcutType> selectHipProdcutTypeList(HipProdcutType hipProdcutType);

    /**
     * 新增产品类别
     * 
     * @param hipProdcutType 产品类别
     * @return 结果
     */
    public int insertHipProdcutType(HipProdcutType hipProdcutType);

    /**
     * 修改产品类别
     * 
     * @param hipProdcutType 产品类别
     * @return 结果
     */
    public int updateHipProdcutType(HipProdcutType hipProdcutType);

    /**
     * 删除产品类别
     * 
     * @param typeId 产品类别主键
     * @return 结果
     */
    public int deleteHipProdcutTypeByTypeId(Integer typeId);

    /**
     * 批量删除产品类别
     * 
     * @param typeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipProdcutTypeByTypeIds(Integer[] typeIds);
}
