package com.ruoyi.product.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.product.domain.HipStockOut;
import com.ruoyi.product.mapper.HipStockOutMapper;
import com.ruoyi.product.service.IHipStockOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 产品出库Service业务层处理
 *
 * @author kevin
 * @date 2023-07-24
 */
@Service
public class HipStockOutServiceImpl implements IHipStockOutService
{
    @Autowired
    private HipStockOutMapper hipStockOutMapper;

    /**
     * 查询产品出库
     *
     * @param stockOutId 产品出库主键
     * @return 产品出库
     */
    @Override
    public HipStockOut selectHipStockOutByStockOutId(Integer stockOutId)
    {
        return hipStockOutMapper.selectHipStockOutByStockOutId(stockOutId);
    }

    /**
     * 查询产品出库列表
     *
     * @param hipStockOut 产品出库
     * @return 产品出库
     */
    @Override
    public List<HipStockOut> selectHipStockOutList(HipStockOut hipStockOut)
    {
        return hipStockOutMapper.selectHipStockOutList(hipStockOut);
    }

    /**
     * 新增产品出库
     *
     * @param hipStockOut 产品出库
     * @return 结果
     */
    @Override
    public int insertHipStockOut(HipStockOut hipStockOut)
    {
        hipStockOut.setCreateTime(DateUtils.getNowDate());
        return hipStockOutMapper.insertHipStockOut(hipStockOut);
    }

    /**
     * 修改产品出库
     *
     * @param hipStockOut 产品出库
     * @return 结果
     */
    @Override
    public int updateHipStockOut(HipStockOut hipStockOut)
    {
        hipStockOut.setUpdateTime(DateUtils.getNowDate());
        return hipStockOutMapper.updateHipStockOut(hipStockOut);
    }

    /**
     * 批量删除产品出库
     *
     * @param stockOutIds 需要删除的产品出库主键
     * @return 结果
     */
    @Override
    public int deleteHipStockOutByStockOutIds(Integer[] stockOutIds)
    {
        return hipStockOutMapper.deleteHipStockOutByStockOutIds(stockOutIds);
    }

    /**
     * 删除产品出库信息
     *
     * @param stockOutId 产品出库主键
     * @return 结果
     */
    @Override
    public int deleteHipStockOutByStockOutId(Integer stockOutId)
    {
        return hipStockOutMapper.deleteHipStockOutByStockOutId(stockOutId);
    }
}
