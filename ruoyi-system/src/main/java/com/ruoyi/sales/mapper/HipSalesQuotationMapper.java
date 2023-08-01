package com.ruoyi.sales.mapper;

import java.util.List;
import com.ruoyi.sales.domain.HipSalesQuotation;
import com.ruoyi.sales.domain.HipSalesQuotationDetail;

/**
 * 销售报价Mapper接口
 * 
 * @author kevin
 * @date 2023-07-25
 */
public interface HipSalesQuotationMapper 
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
     * 删除销售报价
     * 
     * @param quotationId 销售报价主键
     * @return 结果
     */
    public int deleteHipSalesQuotationByQuotationId(Integer quotationId);

    /**
     * 批量删除销售报价
     * 
     * @param quotationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipSalesQuotationByQuotationIds(Integer[] quotationIds);

    /**
     * 批量删除销售报价产品
     * 
     * @param quotationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipSalesQuotationDetailByQuotationIds(Integer[] quotationIds);
    
    /**
     * 批量新增销售报价产品
     * 
     * @param hipSalesQuotationDetailList 销售报价产品列表
     * @return 结果
     */
    public int batchHipSalesQuotationDetail(List<HipSalesQuotationDetail> hipSalesQuotationDetailList);
    

    /**
     * 通过销售报价主键删除销售报价产品信息
     * 
     * @param quotationId 销售报价ID
     * @return 结果
     */
    public int deleteHipSalesQuotationDetailByQuotationId(Integer quotationId);
}
