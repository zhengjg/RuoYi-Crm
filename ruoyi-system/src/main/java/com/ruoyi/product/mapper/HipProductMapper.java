package com.ruoyi.product.mapper;

import java.util.List;
import com.ruoyi.product.domain.HipProduct;

/**
 * 产品维护Mapper接口
 * 
 * @author keivn
 * @date 2023-07-24
 */
public interface HipProductMapper 
{
    /**
     * 查询产品维护
     * 
     * @param productId 产品维护主键
     * @return 产品维护
     */
    public HipProduct selectHipProductByProductId(Integer productId);

    /**
     * 查询产品维护列表
     * 
     * @param hipProduct 产品维护
     * @return 产品维护集合
     */
    public List<HipProduct> selectHipProductList(HipProduct hipProduct);

    /**
     * 新增产品维护
     * 
     * @param hipProduct 产品维护
     * @return 结果
     */
    public int insertHipProduct(HipProduct hipProduct);

    /**
     * 修改产品维护
     * 
     * @param hipProduct 产品维护
     * @return 结果
     */
    public int updateHipProduct(HipProduct hipProduct);

    /**
     * 删除产品维护
     * 
     * @param productId 产品维护主键
     * @return 结果
     */
    public int deleteHipProductByProductId(Integer productId);

    /**
     * 批量删除产品维护
     * 
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipProductByProductIds(Integer[] productIds);
}
