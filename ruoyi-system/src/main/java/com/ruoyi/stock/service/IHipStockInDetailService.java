package com.ruoyi.stock.service;

import java.util.List;
import com.ruoyi.stock.domain.HipStockInDetail;

/**
 * 入库明细Service接口
 * 
 * @author kevin
 * @date 2023-07-25
 */
public interface IHipStockInDetailService 
{
    /**
     * 查询入库明细
     * 
     * @param stockInDetailId 入库明细主键
     * @return 入库明细
     */
    public HipStockInDetail selectHipStockInDetailByStockInDetailId(Integer stockInDetailId);

    /**
     * 查询入库明细列表
     * 
     * @param hipStockInDetail 入库明细
     * @return 入库明细集合
     */
    public List<HipStockInDetail> selectHipStockInDetailList(HipStockInDetail hipStockInDetail);

    /**
     * 新增入库明细
     * 
     * @param hipStockInDetail 入库明细
     * @return 结果
     */
    public int insertHipStockInDetail(HipStockInDetail hipStockInDetail);

    /**
     * 修改入库明细
     * 
     * @param hipStockInDetail 入库明细
     * @return 结果
     */
    public int updateHipStockInDetail(HipStockInDetail hipStockInDetail);

    /**
     * 批量删除入库明细
     * 
     * @param stockInDetailIds 需要删除的入库明细主键集合
     * @return 结果
     */
    public int deleteHipStockInDetailByStockInDetailIds(Integer[] stockInDetailIds);

    /**
     * 删除入库明细信息
     * 
     * @param stockInDetailId 入库明细主键
     * @return 结果
     */
    public int deleteHipStockInDetailByStockInDetailId(Integer stockInDetailId);
}
