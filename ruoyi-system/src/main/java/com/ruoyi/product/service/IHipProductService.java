package com.ruoyi.product.service;

import java.util.List;
import com.ruoyi.product.domain.HipProduct;

/**
 * 产品维护Service接口
 * 
 * @author keivn
 * @date 2023-07-24
 */
public interface IHipProductService 
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
     * 批量删除产品维护
     * 
     * @param productIds 需要删除的产品维护主键集合
     * @return 结果
     */
    public int deleteHipProductByProductIds(Integer[] productIds);

    /**
     * 删除产品维护信息
     * 
     * @param productId 产品维护主键
     * @return 结果
     */
    public int deleteHipProductByProductId(Integer productId);
}
