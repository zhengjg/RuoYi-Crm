package com.ruoyi.sales.service;

import java.util.List;
import com.ruoyi.sales.domain.HipSalesQuotationDetail;

/**
 * 销售报价产品Service接口
 * 
 * @author ruoyi
 * @date 2023-07-25
 */
public interface IHipSalesQuotationDetailService 
{
    /**
     * 查询销售报价产品
     * 
     * @param quotationDetailId 销售报价产品主键
     * @return 销售报价产品
     */
    public HipSalesQuotationDetail selectHipSalesQuotationDetailByQuotationDetailId(Integer quotationDetailId);

    /**
     * 查询销售报价产品列表
     * 
     * @param hipSalesQuotationDetail 销售报价产品
     * @return 销售报价产品集合
     */
    public List<HipSalesQuotationDetail> selectHipSalesQuotationDetailList(HipSalesQuotationDetail hipSalesQuotationDetail);

    /**
     * 新增销售报价产品
     * 
     * @param hipSalesQuotationDetail 销售报价产品
     * @return 结果
     */
    public int insertHipSalesQuotationDetail(HipSalesQuotationDetail hipSalesQuotationDetail);

    /**
     * 修改销售报价产品
     * 
     * @param hipSalesQuotationDetail 销售报价产品
     * @return 结果
     */
    public int updateHipSalesQuotationDetail(HipSalesQuotationDetail hipSalesQuotationDetail);

    /**
     * 批量删除销售报价产品
     * 
     * @param quotationDetailIds 需要删除的销售报价产品主键集合
     * @return 结果
     */
    public int deleteHipSalesQuotationDetailByQuotationDetailIds(Integer[] quotationDetailIds);

    /**
     * 删除销售报价产品信息
     * 
     * @param quotationDetailId 销售报价产品主键
     * @return 结果
     */
    public int deleteHipSalesQuotationDetailByQuotationDetailId(Integer quotationDetailId);
}
