package com.ruoyi.product.mapper;

import com.ruoyi.product.domain.HipStockIn;

import java.util.List;

/**
 * 产品入库Mapper接口
 *
 * @author kevin
 * @date 2023-07-24
 */
public interface HipStockInMapper
{
    /**
     * 查询产品入库
     *
     * @param stockInId 产品入库主键
     * @return 产品入库
     */
    public HipStockIn selectHipStockInByStockInId(Integer stockInId);

    /**
     * 查询产品入库列表
     *
     * @param hipStockIn 产品入库
     * @return 产品入库集合
     */
    public List<HipStockIn> selectHipStockInList(HipStockIn hipStockIn);

    /**
     * 新增产品入库
     *
     * @param hipStockIn 产品入库
     * @return 结果
     */
    public int insertHipStockIn(HipStockIn hipStockIn);

    /**
     * 修改产品入库
     *
     * @param hipStockIn 产品入库
     * @return 结果
     */
    public int updateHipStockIn(HipStockIn hipStockIn);

    /**
     * 删除产品入库
     *
     * @param stockInId 产品入库主键
     * @return 结果
     */
    public int deleteHipStockInByStockInId(Integer stockInId);

    /**
     * 批量删除产品入库
     *
     * @param stockInIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipStockInByStockInIds(Integer[] stockInIds);
}
