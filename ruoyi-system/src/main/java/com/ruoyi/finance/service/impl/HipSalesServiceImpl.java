package com.ruoyi.finance.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.finance.domain.HipSales;
import com.ruoyi.finance.mapper.HipSalesMapper;
import com.ruoyi.finance.service.IHipSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 对账单Service业务层处理
 *
 * @author kevin
 * @date 2023-07-24
 */
@Service
public class HipSalesServiceImpl implements IHipSalesService
{
    @Autowired
    private HipSalesMapper hipSalesMapper;

    /**
     * 查询对账单
     *
     * @param salesId 对账单主键
     * @return 对账单
     */
    @Override
    public HipSales selectHipSalesBySalesId(Integer salesId)
    {
        return hipSalesMapper.selectHipSalesBySalesId(salesId);
    }

    /**
     * 查询对账单列表
     *
     * @param hipSales 对账单
     * @return 对账单
     */
    @Override
    public List<HipSales> selectHipSalesList(HipSales hipSales)
    {
        return hipSalesMapper.selectHipSalesList(hipSales);
    }

    /**
     * 新增对账单
     *
     * @param hipSales 对账单
     * @return 结果
     */
    @Override
    public int insertHipSales(HipSales hipSales)
    {
        hipSales.setCreateTime(DateUtils.getNowDate());
        return hipSalesMapper.insertHipSales(hipSales);
    }

    /**
     * 修改对账单
     *
     * @param hipSales 对账单
     * @return 结果
     */
    @Override
    public int updateHipSales(HipSales hipSales)
    {
        hipSales.setUpdateTime(DateUtils.getNowDate());
        return hipSalesMapper.updateHipSales(hipSales);
    }

    /**
     * 批量删除对账单
     *
     * @param salesIds 需要删除的对账单主键
     * @return 结果
     */
    @Override
    public int deleteHipSalesBySalesIds(Integer[] salesIds)
    {
        return hipSalesMapper.deleteHipSalesBySalesIds(salesIds);
    }

    /**
     * 删除对账单信息
     *
     * @param salesId 对账单主键
     * @return 结果
     */
    @Override
    public int deleteHipSalesBySalesId(Integer salesId)
    {
        return hipSalesMapper.deleteHipSalesBySalesId(salesId);
    }
}
