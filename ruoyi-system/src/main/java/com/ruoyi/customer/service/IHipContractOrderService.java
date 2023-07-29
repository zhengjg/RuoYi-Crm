package com.ruoyi.customer.service;

import java.util.List;
import com.ruoyi.customer.domain.HipContractOrder;

/**
 * 合同Service接口
 * 
 * @author kevin
 * @date 2023-07-28
 */
public interface IHipContractOrderService 
{
    /**
     * 查询合同
     * 
     * @param contractOrderId 合同主键
     * @return 合同
     */
    public HipContractOrder selectHipContractOrderByContractOrderId(Integer contractOrderId);

    /**
     * 查询合同列表
     * 
     * @param hipContractOrder 合同
     * @return 合同集合
     */
    public List<HipContractOrder> selectHipContractOrderList(HipContractOrder hipContractOrder);

    /**
     * 新增合同
     * 
     * @param hipContractOrder 合同
     * @return 结果
     */
    public int insertHipContractOrder(HipContractOrder hipContractOrder);

    /**
     * 修改合同
     * 
     * @param hipContractOrder 合同
     * @return 结果
     */
    public int updateHipContractOrder(HipContractOrder hipContractOrder);

    /**
     * 批量删除合同
     * 
     * @param contractOrderIds 需要删除的合同主键集合
     * @return 结果
     */
    public int deleteHipContractOrderByContractOrderIds(Integer[] contractOrderIds);

    /**
     * 删除合同信息
     * 
     * @param contractOrderId 合同主键
     * @return 结果
     */
    public int deleteHipContractOrderByContractOrderId(Integer contractOrderId);
}
