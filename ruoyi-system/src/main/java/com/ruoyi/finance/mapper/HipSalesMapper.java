package com.ruoyi.finance.mapper;

import com.ruoyi.finance.domain.HipSales;

import java.util.List;

/**
 * 对账单Mapper接口
 *
 * @author kevin
 * @date 2023-07-24
 */
public interface HipSalesMapper
{
    /**
     * 查询对账单
     *
     * @param salesId 对账单主键
     * @return 对账单
     */
    public HipSales selectHipSalesBySalesId(Integer salesId);

    /**
     * 查询对账单列表
     *
     * @param hipSales 对账单
     * @return 对账单集合
     */
    public List<HipSales> selectHipSalesList(HipSales hipSales);

    /**
     * 新增对账单
     *
     * @param hipSales 对账单
     * @return 结果
     */
    public int insertHipSales(HipSales hipSales);

    /**
     * 修改对账单
     *
     * @param hipSales 对账单
     * @return 结果
     */
    public int updateHipSales(HipSales hipSales);

    /**
     * 删除对账单
     *
     * @param salesId 对账单主键
     * @return 结果
     */
    public int deleteHipSalesBySalesId(Integer salesId);

    /**
     * 批量删除对账单
     *
     * @param salesIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipSalesBySalesIds(Integer[] salesIds);
}
