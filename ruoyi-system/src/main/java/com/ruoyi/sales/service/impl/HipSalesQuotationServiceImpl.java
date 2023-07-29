package com.ruoyi.sales.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.sales.domain.HipSalesQuotationDetail;
import com.ruoyi.sales.mapper.HipSalesQuotationMapper;
import com.ruoyi.sales.domain.HipSalesQuotation;
import com.ruoyi.sales.service.IHipSalesQuotationService;

/**
 * 销售报价Service业务层处理
 * 
 * @author kevin
 * @date 2023-07-25
 */
@Service
public class HipSalesQuotationServiceImpl implements IHipSalesQuotationService 
{
    @Autowired
    private HipSalesQuotationMapper hipSalesQuotationMapper;

    /**
     * 查询销售报价
     * 
     * @param quotationId 销售报价主键
     * @return 销售报价
     */
    @Override
    public HipSalesQuotation selectHipSalesQuotationByQuotationId(Integer quotationId)
    {
        return hipSalesQuotationMapper.selectHipSalesQuotationByQuotationId(quotationId);
    }

    /**
     * 查询销售报价列表
     * 
     * @param hipSalesQuotation 销售报价
     * @return 销售报价
     */
    @Override
    public List<HipSalesQuotation> selectHipSalesQuotationList(HipSalesQuotation hipSalesQuotation)
    {
        return hipSalesQuotationMapper.selectHipSalesQuotationList(hipSalesQuotation);
    }

    /**
     * 新增销售报价
     * 
     * @param hipSalesQuotation 销售报价
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHipSalesQuotation(HipSalesQuotation hipSalesQuotation)
    {
        hipSalesQuotation.setCreateTime(DateUtils.getNowDate());
        int rows = hipSalesQuotationMapper.insertHipSalesQuotation(hipSalesQuotation);
        insertHipSalesQuotationDetail(hipSalesQuotation);
        return rows;
    }

    /**
     * 修改销售报价
     * 
     * @param hipSalesQuotation 销售报价
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHipSalesQuotation(HipSalesQuotation hipSalesQuotation)
    {
        hipSalesQuotation.setUpdateTime(DateUtils.getNowDate());
        hipSalesQuotationMapper.deleteHipSalesQuotationDetailByQuotationId(hipSalesQuotation.getQuotationId());
        insertHipSalesQuotationDetail(hipSalesQuotation);
        return hipSalesQuotationMapper.updateHipSalesQuotation(hipSalesQuotation);
    }

    /**
     * 批量删除销售报价
     * 
     * @param quotationIds 需要删除的销售报价主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHipSalesQuotationByQuotationIds(Integer[] quotationIds)
    {
        hipSalesQuotationMapper.deleteHipSalesQuotationDetailByQuotationIds(quotationIds);
        return hipSalesQuotationMapper.deleteHipSalesQuotationByQuotationIds(quotationIds);
    }

    /**
     * 删除销售报价信息
     * 
     * @param quotationId 销售报价主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHipSalesQuotationByQuotationId(Integer quotationId)
    {
        hipSalesQuotationMapper.deleteHipSalesQuotationDetailByQuotationId(quotationId);
        return hipSalesQuotationMapper.deleteHipSalesQuotationByQuotationId(quotationId);
    }

    /**
     * 新增销售报价产品信息
     * 
     * @param hipSalesQuotation 销售报价对象
     */
    public void insertHipSalesQuotationDetail(HipSalesQuotation hipSalesQuotation)
    {
        List<HipSalesQuotationDetail> hipSalesQuotationDetailList = hipSalesQuotation.getHipSalesQuotationDetailList();
        Integer quotationId = hipSalesQuotation.getQuotationId();
        if (StringUtils.isNotNull(hipSalesQuotationDetailList))
        {
            List<HipSalesQuotationDetail> list = new ArrayList<HipSalesQuotationDetail>();
            for (HipSalesQuotationDetail hipSalesQuotationDetail : hipSalesQuotationDetailList)
            {
                hipSalesQuotationDetail.setQuotationId(quotationId);
                list.add(hipSalesQuotationDetail);
            }
            if (list.size() > 0)
            {
                hipSalesQuotationMapper.batchHipSalesQuotationDetail(list);
            }
        }
    }
}
