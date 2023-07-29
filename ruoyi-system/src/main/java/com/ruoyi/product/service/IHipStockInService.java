package com.ruoyi.product.service;

import com.ruoyi.product.domain.HipStockIn;

import java.util.List;

/**
 * 产品入库Service接口
 *
 * @author kevin
 * @date 2023-07-24
 */
public interface IHipStockInService
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
     * 批量删除产品入库
     *
     * @param stockInIds 需要删除的产品入库主键集合
     * @return 结果
     */
    public int deleteHipStockInByStockInIds(Integer[] stockInIds);

    /**
     * 删除产品入库信息
     *
     * @param stockInId 产品入库主键
     * @return 结果
     */
    public int deleteHipStockInByStockInId(Integer stockInId);
}
