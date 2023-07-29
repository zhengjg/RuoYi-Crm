package com.ruoyi.product.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.product.domain.HipStockIn;
import com.ruoyi.product.mapper.HipStockInMapper;
import com.ruoyi.product.service.IHipStockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 产品入库Service业务层处理
 *
 * @author kevin
 * @date 2023-07-24
 */
@Service
public class HipStockInServiceImpl implements IHipStockInService
{
    @Autowired
    private HipStockInMapper hipStockInMapper;

    /**
     * 查询产品入库
     *
     * @param stockInId 产品入库主键
     * @return 产品入库
     */
    @Override
    public HipStockIn selectHipStockInByStockInId(Integer stockInId)
    {
        return hipStockInMapper.selectHipStockInByStockInId(stockInId);
    }

    /**
     * 查询产品入库列表
     *
     * @param hipStockIn 产品入库
     * @return 产品入库
     */
    @Override
    public List<HipStockIn> selectHipStockInList(HipStockIn hipStockIn)
    {
        return hipStockInMapper.selectHipStockInList(hipStockIn);
    }

    /**
     * 新增产品入库
     *
     * @param hipStockIn 产品入库
     * @return 结果
     */
    @Override
    public int insertHipStockIn(HipStockIn hipStockIn)
    {
        hipStockIn.setCreateTime(DateUtils.getNowDate());
        return hipStockInMapper.insertHipStockIn(hipStockIn);
    }

    /**
     * 修改产品入库
     *
     * @param hipStockIn 产品入库
     * @return 结果
     */
    @Override
    public int updateHipStockIn(HipStockIn hipStockIn)
    {
        hipStockIn.setUpdateTime(DateUtils.getNowDate());
        return hipStockInMapper.updateHipStockIn(hipStockIn);
    }

    /**
     * 批量删除产品入库
     *
     * @param stockInIds 需要删除的产品入库主键
     * @return 结果
     */
    @Override
    public int deleteHipStockInByStockInIds(Integer[] stockInIds)
    {
        return hipStockInMapper.deleteHipStockInByStockInIds(stockInIds);
    }

    /**
     * 删除产品入库信息
     *
     * @param stockInId 产品入库主键
     * @return 结果
     */
    @Override
    public int deleteHipStockInByStockInId(Integer stockInId)
    {
        return hipStockInMapper.deleteHipStockInByStockInId(stockInId);
    }
}
