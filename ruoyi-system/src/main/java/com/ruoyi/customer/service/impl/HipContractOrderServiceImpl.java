package com.ruoyi.customer.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.customer.mapper.HipContractOrderMapper;
import com.ruoyi.customer.domain.HipContractOrder;
import com.ruoyi.customer.service.IHipContractOrderService;

/**
 * 合同Service业务层处理
 * 
 * @author kevin
 * @date 2023-07-28
 */
@Service
public class HipContractOrderServiceImpl implements IHipContractOrderService 
{
    @Autowired
    private HipContractOrderMapper hipContractOrderMapper;

    /**
     * 查询合同
     * 
     * @param contractOrderId 合同主键
     * @return 合同
     */
    @Override
    public HipContractOrder selectHipContractOrderByContractOrderId(Integer contractOrderId)
    {
        return hipContractOrderMapper.selectHipContractOrderByContractOrderId(contractOrderId);
    }

    /**
     * 查询合同列表
     * 
     * @param hipContractOrder 合同
     * @return 合同
     */
    @Override
    public List<HipContractOrder> selectHipContractOrderList(HipContractOrder hipContractOrder)
    {
        return hipContractOrderMapper.selectHipContractOrderList(hipContractOrder);
    }

    /**
     * 新增合同
     * 
     * @param hipContractOrder 合同
     * @return 结果
     */
    @Override
    public int insertHipContractOrder(HipContractOrder hipContractOrder)
    {
        hipContractOrder.setCreateTime(DateUtils.getNowDate());
        return hipContractOrderMapper.insertHipContractOrder(hipContractOrder);
    }

    /**
     * 修改合同
     * 
     * @param hipContractOrder 合同
     * @return 结果
     */
    @Override
    public int updateHipContractOrder(HipContractOrder hipContractOrder)
    {
        return hipContractOrderMapper.updateHipContractOrder(hipContractOrder);
    }

    /**
     * 批量删除合同
     * 
     * @param contractOrderIds 需要删除的合同主键
     * @return 结果
     */
    @Override
    public int deleteHipContractOrderByContractOrderIds(Integer[] contractOrderIds)
    {
        return hipContractOrderMapper.deleteHipContractOrderByContractOrderIds(contractOrderIds);
    }

    /**
     * 删除合同信息
     * 
     * @param contractOrderId 合同主键
     * @return 结果
     */
    @Override
    public int deleteHipContractOrderByContractOrderId(Integer contractOrderId)
    {
        return hipContractOrderMapper.deleteHipContractOrderByContractOrderId(contractOrderId);
    }
}
