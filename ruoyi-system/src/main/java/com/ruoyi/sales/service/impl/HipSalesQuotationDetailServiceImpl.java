package com.ruoyi.sales.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sales.mapper.HipSalesQuotationDetailMapper;
import com.ruoyi.sales.domain.HipSalesQuotationDetail;
import com.ruoyi.sales.service.IHipSalesQuotationDetailService;

/**
 * 销售报价产品Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-25
 */
@Service
public class HipSalesQuotationDetailServiceImpl implements IHipSalesQuotationDetailService 
{
    @Autowired
    private HipSalesQuotationDetailMapper hipSalesQuotationDetailMapper;

    /**
     * 查询销售报价产品
     * 
     * @param quotationDetailId 销售报价产品主键
     * @return 销售报价产品
     */
    @Override
    public HipSalesQuotationDetail selectHipSalesQuotationDetailByQuotationDetailId(Integer quotationDetailId)
    {
        return hipSalesQuotationDetailMapper.selectHipSalesQuotationDetailByQuotationDetailId(quotationDetailId);
    }

    /**
     * 查询销售报价产品列表
     * 
     * @param hipSalesQuotationDetail 销售报价产品
     * @return 销售报价产品
     */
    @Override
    public List<HipSalesQuotationDetail> selectHipSalesQuotationDetailList(HipSalesQuotationDetail hipSalesQuotationDetail)
    {
        return hipSalesQuotationDetailMapper.selectHipSalesQuotationDetailList(hipSalesQuotationDetail);
    }

    /**
     * 新增销售报价产品
     * 
     * @param hipSalesQuotationDetail 销售报价产品
     * @return 结果
     */
    @Override
    public int insertHipSalesQuotationDetail(HipSalesQuotationDetail hipSalesQuotationDetail)
    {
        hipSalesQuotationDetail.setCreateTime(DateUtils.getNowDate());
        return hipSalesQuotationDetailMapper.insertHipSalesQuotationDetail(hipSalesQuotationDetail);
    }

    /**
     * 修改销售报价产品
     * 
     * @param hipSalesQuotationDetail 销售报价产品
     * @return 结果
     */
    @Override
    public int updateHipSalesQuotationDetail(HipSalesQuotationDetail hipSalesQuotationDetail)
    {
        hipSalesQuotationDetail.setUpdateTime(DateUtils.getNowDate());
        return hipSalesQuotationDetailMapper.updateHipSalesQuotationDetail(hipSalesQuotationDetail);
    }

    /**
     * 批量删除销售报价产品
     * 
     * @param quotationDetailIds 需要删除的销售报价产品主键
     * @return 结果
     */
    @Override
    public int deleteHipSalesQuotationDetailByQuotationDetailIds(Integer[] quotationDetailIds)
    {
        return hipSalesQuotationDetailMapper.deleteHipSalesQuotationDetailByQuotationDetailIds(quotationDetailIds);
    }

    /**
     * 删除销售报价产品信息
     * 
     * @param quotationDetailId 销售报价产品主键
     * @return 结果
     */
    @Override
    public int deleteHipSalesQuotationDetailByQuotationDetailId(Integer quotationDetailId)
    {
        return hipSalesQuotationDetailMapper.deleteHipSalesQuotationDetailByQuotationDetailId(quotationDetailId);
    }
}
