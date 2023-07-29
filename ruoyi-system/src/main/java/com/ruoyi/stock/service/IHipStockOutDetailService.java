package com.ruoyi.stock.service;

import java.util.List;
import com.ruoyi.stock.domain.HipStockOutDetail;

/**
 * 出库明细Service接口
 * 
 * @author kevin
 * @date 2023-07-25
 */
public interface IHipStockOutDetailService 
{
    /**
     * 查询出库明细
     * 
     * @param stockOutDetailId 出库明细主键
     * @return 出库明细
     */
    public HipStockOutDetail selectHipStockOutDetailByStockOutDetailId(Integer stockOutDetailId);

    /**
     * 查询出库明细列表
     * 
     * @param hipStockOutDetail 出库明细
     * @return 出库明细集合
     */
    public List<HipStockOutDetail> selectHipStockOutDetailList(HipStockOutDetail hipStockOutDetail);

    /**
     * 新增出库明细
     * 
     * @param hipStockOutDetail 出库明细
     * @return 结果
     */
    public int insertHipStockOutDetail(HipStockOutDetail hipStockOutDetail);

    /**
     * 修改出库明细
     * 
     * @param hipStockOutDetail 出库明细
     * @return 结果
     */
    public int updateHipStockOutDetail(HipStockOutDetail hipStockOutDetail);

    /**
     * 批量删除出库明细
     * 
     * @param stockOutDetailIds 需要删除的出库明细主键集合
     * @return 结果
     */
    public int deleteHipStockOutDetailByStockOutDetailIds(Integer[] stockOutDetailIds);

    /**
     * 删除出库明细信息
     * 
     * @param stockOutDetailId 出库明细主键
     * @return 结果
     */
    public int deleteHipStockOutDetailByStockOutDetailId(Integer stockOutDetailId);
}
