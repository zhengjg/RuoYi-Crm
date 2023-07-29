package com.ruoyi.product.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.product.mapper.HipProductMapper;
import com.ruoyi.product.domain.HipProduct;
import com.ruoyi.product.service.IHipProductService;

/**
 * 产品维护Service业务层处理
 * 
 * @author keivn
 * @date 2023-07-24
 */
@Service
public class HipProductServiceImpl implements IHipProductService 
{
    @Autowired
    private HipProductMapper hipProductMapper;

    /**
     * 查询产品维护
     * 
     * @param productId 产品维护主键
     * @return 产品维护
     */
    @Override
    public HipProduct selectHipProductByProductId(Integer productId)
    {
        return hipProductMapper.selectHipProductByProductId(productId);
    }

    /**
     * 查询产品维护列表
     * 
     * @param hipProduct 产品维护
     * @return 产品维护
     */
    @Override
    public List<HipProduct> selectHipProductList(HipProduct hipProduct)
    {
        return hipProductMapper.selectHipProductList(hipProduct);
    }

    /**
     * 新增产品维护
     * 
     * @param hipProduct 产品维护
     * @return 结果
     */
    @Override
    public int insertHipProduct(HipProduct hipProduct)
    {
        hipProduct.setCreateTime(DateUtils.getNowDate());
        return hipProductMapper.insertHipProduct(hipProduct);
    }

    /**
     * 修改产品维护
     * 
     * @param hipProduct 产品维护
     * @return 结果
     */
    @Override
    public int updateHipProduct(HipProduct hipProduct)
    {
        hipProduct.setUpdateTime(DateUtils.getNowDate());
        return hipProductMapper.updateHipProduct(hipProduct);
    }

    /**
     * 批量删除产品维护
     * 
     * @param productIds 需要删除的产品维护主键
     * @return 结果
     */
    @Override
    public int deleteHipProductByProductIds(Integer[] productIds)
    {
        return hipProductMapper.deleteHipProductByProductIds(productIds);
    }

    /**
     * 删除产品维护信息
     * 
     * @param productId 产品维护主键
     * @return 结果
     */
    @Override
    public int deleteHipProductByProductId(Integer productId)
    {
        return hipProductMapper.deleteHipProductByProductId(productId);
    }
}
