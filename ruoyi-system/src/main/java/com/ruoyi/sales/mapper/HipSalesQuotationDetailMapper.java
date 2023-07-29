package com.ruoyi.sales.mapper;

import java.util.List;
import com.ruoyi.sales.domain.HipSalesQuotationDetail;

/**
 * 销售报价产品Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-25
 */
public interface HipSalesQuotationDetailMapper 
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
     * 删除销售报价产品
     * 
     * @param quotationDetailId 销售报价产品主键
     * @return 结果
     */
    public int deleteHipSalesQuotationDetailByQuotationDetailId(Integer quotationDetailId);

    /**
     * 批量删除销售报价产品
     * 
     * @param quotationDetailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipSalesQuotationDetailByQuotationDetailIds(Integer[] quotationDetailIds);
}
