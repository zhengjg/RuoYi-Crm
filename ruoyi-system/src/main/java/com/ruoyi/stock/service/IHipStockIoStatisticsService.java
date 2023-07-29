package com.ruoyi.stock.service;

import java.util.List;
import com.ruoyi.stock.domain.HipStockIoStatistics;

/**
 * 出入库汇总Service接口
 * 
 * @author kevin
 * @date 2023-07-25
 */
public interface IHipStockIoStatisticsService 
{
    /**
     * 查询出入库汇总
     * 
     * @param ioStatisticsId 出入库汇总主键
     * @return 出入库汇总
     */
    public HipStockIoStatistics selectHipStockIoStatisticsByIoStatisticsId(Integer ioStatisticsId);

    /**
     * 查询出入库汇总列表
     * 
     * @param hipStockIoStatistics 出入库汇总
     * @return 出入库汇总集合
     */
    public List<HipStockIoStatistics> selectHipStockIoStatisticsList(HipStockIoStatistics hipStockIoStatistics);

    /**
     * 新增出入库汇总
     * 
     * @param hipStockIoStatistics 出入库汇总
     * @return 结果
     */
    public int insertHipStockIoStatistics(HipStockIoStatistics hipStockIoStatistics);

    /**
     * 修改出入库汇总
     * 
     * @param hipStockIoStatistics 出入库汇总
     * @return 结果
     */
    public int updateHipStockIoStatistics(HipStockIoStatistics hipStockIoStatistics);

    /**
     * 批量删除出入库汇总
     * 
     * @param ioStatisticsIds 需要删除的出入库汇总主键集合
     * @return 结果
     */
    public int deleteHipStockIoStatisticsByIoStatisticsIds(Integer[] ioStatisticsIds);

    /**
     * 删除出入库汇总信息
     * 
     * @param ioStatisticsId 出入库汇总主键
     * @return 结果
     */
    public int deleteHipStockIoStatisticsByIoStatisticsId(Integer ioStatisticsId);
}
