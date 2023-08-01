package com.ruoyi.stock.mapper;

import java.util.List;
import com.ruoyi.stock.domain.HipStockOutDetail;

/**
 * 出库明细Mapper接口
 * 
 * @author kevin
 * @date 2023-07-25
 */
public interface HipStockOutDetailMapper 
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
     * 删除出库明细
     * 
     * @param stockOutDetailId 出库明细主键
     * @return 结果
     */
    public int deleteHipStockOutDetailByStockOutDetailId(Integer stockOutDetailId);

    /**
     * 批量删除出库明细
     * 
     * @param stockOutDetailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipStockOutDetailByStockOutDetailIds(Integer[] stockOutDetailIds);
}
