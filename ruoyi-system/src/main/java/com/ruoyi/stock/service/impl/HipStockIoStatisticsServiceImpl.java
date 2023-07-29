package com.ruoyi.stock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stock.mapper.HipStockIoStatisticsMapper;
import com.ruoyi.stock.domain.HipStockIoStatistics;
import com.ruoyi.stock.service.IHipStockIoStatisticsService;

/**
 * 出入库汇总Service业务层处理
 * 
 * @author kevin
 * @date 2023-07-25
 */
@Service
public class HipStockIoStatisticsServiceImpl implements IHipStockIoStatisticsService 
{
    @Autowired
    private HipStockIoStatisticsMapper hipStockIoStatisticsMapper;

    /**
     * 查询出入库汇总
     * 
     * @param ioStatisticsId 出入库汇总主键
     * @return 出入库汇总
     */
    @Override
    public HipStockIoStatistics selectHipStockIoStatisticsByIoStatisticsId(Integer ioStatisticsId)
    {
        return hipStockIoStatisticsMapper.selectHipStockIoStatisticsByIoStatisticsId(ioStatisticsId);
    }

    /**
     * 查询出入库汇总列表
     * 
     * @param hipStockIoStatistics 出入库汇总
     * @return 出入库汇总
     */
    @Override
    public List<HipStockIoStatistics> selectHipStockIoStatisticsList(HipStockIoStatistics hipStockIoStatistics)
    {
        return hipStockIoStatisticsMapper.selectHipStockIoStatisticsList(hipStockIoStatistics);
    }

    /**
     * 新增出入库汇总
     * 
     * @param hipStockIoStatistics 出入库汇总
     * @return 结果
     */
    @Override
    public int insertHipStockIoStatistics(HipStockIoStatistics hipStockIoStatistics)
    {
        return hipStockIoStatisticsMapper.insertHipStockIoStatistics(hipStockIoStatistics);
    }

    /**
     * 修改出入库汇总
     * 
     * @param hipStockIoStatistics 出入库汇总
     * @return 结果
     */
    @Override
    public int updateHipStockIoStatistics(HipStockIoStatistics hipStockIoStatistics)
    {
        return hipStockIoStatisticsMapper.updateHipStockIoStatistics(hipStockIoStatistics);
    }

    /**
     * 批量删除出入库汇总
     * 
     * @param ioStatisticsIds 需要删除的出入库汇总主键
     * @return 结果
     */
    @Override
    public int deleteHipStockIoStatisticsByIoStatisticsIds(Integer[] ioStatisticsIds)
    {
        return hipStockIoStatisticsMapper.deleteHipStockIoStatisticsByIoStatisticsIds(ioStatisticsIds);
    }

    /**
     * 删除出入库汇总信息
     * 
     * @param ioStatisticsId 出入库汇总主键
     * @return 结果
     */
    @Override
    public int deleteHipStockIoStatisticsByIoStatisticsId(Integer ioStatisticsId)
    {
        return hipStockIoStatisticsMapper.deleteHipStockIoStatisticsByIoStatisticsId(ioStatisticsId);
    }
}
