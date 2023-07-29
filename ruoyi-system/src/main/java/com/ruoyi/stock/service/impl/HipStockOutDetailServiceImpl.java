package com.ruoyi.stock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stock.mapper.HipStockOutDetailMapper;
import com.ruoyi.stock.domain.HipStockOutDetail;
import com.ruoyi.stock.service.IHipStockOutDetailService;

/**
 * 出库明细Service业务层处理
 * 
 * @author kevin
 * @date 2023-07-25
 */
@Service
public class HipStockOutDetailServiceImpl implements IHipStockOutDetailService 
{
    @Autowired
    private HipStockOutDetailMapper hipStockOutDetailMapper;

    /**
     * 查询出库明细
     * 
     * @param stockOutDetailId 出库明细主键
     * @return 出库明细
     */
    @Override
    public HipStockOutDetail selectHipStockOutDetailByStockOutDetailId(Integer stockOutDetailId)
    {
        return hipStockOutDetailMapper.selectHipStockOutDetailByStockOutDetailId(stockOutDetailId);
    }

    /**
     * 查询出库明细列表
     * 
     * @param hipStockOutDetail 出库明细
     * @return 出库明细
     */
    @Override
    public List<HipStockOutDetail> selectHipStockOutDetailList(HipStockOutDetail hipStockOutDetail)
    {
        return hipStockOutDetailMapper.selectHipStockOutDetailList(hipStockOutDetail);
    }

    /**
     * 新增出库明细
     * 
     * @param hipStockOutDetail 出库明细
     * @return 结果
     */
    @Override
    public int insertHipStockOutDetail(HipStockOutDetail hipStockOutDetail)
    {
        return hipStockOutDetailMapper.insertHipStockOutDetail(hipStockOutDetail);
    }

    /**
     * 修改出库明细
     * 
     * @param hipStockOutDetail 出库明细
     * @return 结果
     */
    @Override
    public int updateHipStockOutDetail(HipStockOutDetail hipStockOutDetail)
    {
        return hipStockOutDetailMapper.updateHipStockOutDetail(hipStockOutDetail);
    }

    /**
     * 批量删除出库明细
     * 
     * @param stockOutDetailIds 需要删除的出库明细主键
     * @return 结果
     */
    @Override
    public int deleteHipStockOutDetailByStockOutDetailIds(Integer[] stockOutDetailIds)
    {
        return hipStockOutDetailMapper.deleteHipStockOutDetailByStockOutDetailIds(stockOutDetailIds);
    }

    /**
     * 删除出库明细信息
     * 
     * @param stockOutDetailId 出库明细主键
     * @return 结果
     */
    @Override
    public int deleteHipStockOutDetailByStockOutDetailId(Integer stockOutDetailId)
    {
        return hipStockOutDetailMapper.deleteHipStockOutDetailByStockOutDetailId(stockOutDetailId);
    }
}
