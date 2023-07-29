package com.ruoyi.stock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stock.mapper.HipStockInDetailMapper;
import com.ruoyi.stock.domain.HipStockInDetail;
import com.ruoyi.stock.service.IHipStockInDetailService;

/**
 * 入库明细Service业务层处理
 * 
 * @author kevin
 * @date 2023-07-25
 */
@Service
public class HipStockInDetailServiceImpl implements IHipStockInDetailService 
{
    @Autowired
    private HipStockInDetailMapper hipStockInDetailMapper;

    /**
     * 查询入库明细
     * 
     * @param stockInDetailId 入库明细主键
     * @return 入库明细
     */
    @Override
    public HipStockInDetail selectHipStockInDetailByStockInDetailId(Integer stockInDetailId)
    {
        return hipStockInDetailMapper.selectHipStockInDetailByStockInDetailId(stockInDetailId);
    }

    /**
     * 查询入库明细列表
     * 
     * @param hipStockInDetail 入库明细
     * @return 入库明细
     */
    @Override
    public List<HipStockInDetail> selectHipStockInDetailList(HipStockInDetail hipStockInDetail)
    {
        return hipStockInDetailMapper.selectHipStockInDetailList(hipStockInDetail);
    }

    /**
     * 新增入库明细
     * 
     * @param hipStockInDetail 入库明细
     * @return 结果
     */
    @Override
    public int insertHipStockInDetail(HipStockInDetail hipStockInDetail)
    {
        return hipStockInDetailMapper.insertHipStockInDetail(hipStockInDetail);
    }

    /**
     * 修改入库明细
     * 
     * @param hipStockInDetail 入库明细
     * @return 结果
     */
    @Override
    public int updateHipStockInDetail(HipStockInDetail hipStockInDetail)
    {
        return hipStockInDetailMapper.updateHipStockInDetail(hipStockInDetail);
    }

    /**
     * 批量删除入库明细
     * 
     * @param stockInDetailIds 需要删除的入库明细主键
     * @return 结果
     */
    @Override
    public int deleteHipStockInDetailByStockInDetailIds(Integer[] stockInDetailIds)
    {
        return hipStockInDetailMapper.deleteHipStockInDetailByStockInDetailIds(stockInDetailIds);
    }

    /**
     * 删除入库明细信息
     * 
     * @param stockInDetailId 入库明细主键
     * @return 结果
     */
    @Override
    public int deleteHipStockInDetailByStockInDetailId(Integer stockInDetailId)
    {
        return hipStockInDetailMapper.deleteHipStockInDetailByStockInDetailId(stockInDetailId);
    }
}
