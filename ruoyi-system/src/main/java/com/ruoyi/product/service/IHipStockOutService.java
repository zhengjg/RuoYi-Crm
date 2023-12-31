package com.ruoyi.product.service;

import com.ruoyi.product.domain.HipStockOut;

import java.util.List;

/**
 * 产品出库Service接口
 *
 * @author kevin
 * @date 2023-07-24
 */
public interface IHipStockOutService
{
    /**
     * 查询产品出库
     *
     * @param stockOutId 产品出库主键
     * @return 产品出库
     */
    public HipStockOut selectHipStockOutByStockOutId(Integer stockOutId);

    /**
     * 查询产品出库列表
     *
     * @param hipStockOut 产品出库
     * @return 产品出库集合
     */
    public List<HipStockOut> selectHipStockOutList(HipStockOut hipStockOut);

    /**
     * 新增产品出库
     *
     * @param hipStockOut 产品出库
     * @return 结果
     */
    public int insertHipStockOut(HipStockOut hipStockOut);

    /**
     * 修改产品出库
     *
     * @param hipStockOut 产品出库
     * @return 结果
     */
    public int updateHipStockOut(HipStockOut hipStockOut);

    /**
     * 批量删除产品出库
     *
     * @param stockOutIds 需要删除的产品出库主键集合
     * @return 结果
     */
    public int deleteHipStockOutByStockOutIds(Integer[] stockOutIds);

    /**
     * 删除产品出库信息
     *
     * @param stockOutId 产品出库主键
     * @return 结果
     */
    public int deleteHipStockOutByStockOutId(Integer stockOutId);
}
