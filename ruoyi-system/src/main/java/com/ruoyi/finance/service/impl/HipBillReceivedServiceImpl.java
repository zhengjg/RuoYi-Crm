package com.ruoyi.finance.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.finance.mapper.HipBillReceivedMapper;
import com.ruoyi.finance.domain.HipBillReceived;
import com.ruoyi.finance.service.IHipBillReceivedService;

/**
 * 销售收款Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-25
 */
@Service
public class HipBillReceivedServiceImpl implements IHipBillReceivedService 
{
    @Autowired
    private HipBillReceivedMapper hipBillReceivedMapper;

    /**
     * 查询销售收款
     * 
     * @param receivedId 销售收款主键
     * @return 销售收款
     */
    @Override
    public HipBillReceived selectHipBillReceivedByReceivedId(Integer receivedId)
    {
        return hipBillReceivedMapper.selectHipBillReceivedByReceivedId(receivedId);
    }

    /**
     * 查询销售收款列表
     * 
     * @param hipBillReceived 销售收款
     * @return 销售收款
     */
    @Override
    public List<HipBillReceived> selectHipBillReceivedList(HipBillReceived hipBillReceived)
    {
        return hipBillReceivedMapper.selectHipBillReceivedList(hipBillReceived);
    }

    /**
     * 新增销售收款
     * 
     * @param hipBillReceived 销售收款
     * @return 结果
     */
    @Override
    public int insertHipBillReceived(HipBillReceived hipBillReceived)
    {
        hipBillReceived.setCreateTime(DateUtils.getNowDate());
        return hipBillReceivedMapper.insertHipBillReceived(hipBillReceived);
    }

    /**
     * 修改销售收款
     * 
     * @param hipBillReceived 销售收款
     * @return 结果
     */
    @Override
    public int updateHipBillReceived(HipBillReceived hipBillReceived)
    {
        return hipBillReceivedMapper.updateHipBillReceived(hipBillReceived);
    }

    /**
     * 批量删除销售收款
     * 
     * @param receivedIds 需要删除的销售收款主键
     * @return 结果
     */
    @Override
    public int deleteHipBillReceivedByReceivedIds(Integer[] receivedIds)
    {
        return hipBillReceivedMapper.deleteHipBillReceivedByReceivedIds(receivedIds);
    }

    /**
     * 删除销售收款信息
     * 
     * @param receivedId 销售收款主键
     * @return 结果
     */
    @Override
    public int deleteHipBillReceivedByReceivedId(Integer receivedId)
    {
        return hipBillReceivedMapper.deleteHipBillReceivedByReceivedId(receivedId);
    }
}
