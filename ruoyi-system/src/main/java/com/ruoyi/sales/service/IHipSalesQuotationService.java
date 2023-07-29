package com.ruoyi.sales.service;

import java.util.List;
import com.ruoyi.sales.domain.HipSalesQuotation;

/**
 * 销售报价Service接口
 * 
 * @author kevin
 * @date 2023-07-25
 */
public interface IHipSalesQuotationService 
{
    /**
     * 查询销售报价
     * 
     * @param quotationId 销售报价主键
     * @return 销售报价
     */
    public HipSalesQuotation selectHipSalesQuotationByQuotationId(Integer quotationId);

    /**
     * 查询销售报价列表
     * 
     * @param hipSalesQuotation 销售报价
     * @return 销售报价集合
     */
    public List<HipSalesQuotation> selectHipSalesQuotationList(HipSalesQuotation hipSalesQuotation);

    /**
     * 新增销售报价
     * 
     * @param hipSalesQuotation 销售报价
     * @return 结果
     */
    public int insertHipSalesQuotation(HipSalesQuotation hipSalesQuotation);

    /**
     * 修改销售报价
     * 
     * @param hipSalesQuotation 销售报价
     * @return 结果
     */
    public int updateHipSalesQuotation(HipSalesQuotation hipSalesQuotation);

    /**
     * 批量删除销售报价
     * 
     * @param quotationIds 需要删除的销售报价主键集合
     * @return 结果
     */
    public int deleteHipSalesQuotationByQuotationIds(Integer[] quotationIds);

    /**
     * 删除销售报价信息
     * 
     * @param quotationId 销售报价主键
     * @return 结果
     */
    public int deleteHipSalesQuotationByQuotationId(Integer quotationId);
}
