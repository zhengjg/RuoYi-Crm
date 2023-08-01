package com.ruoyi.finance.mapper;

import java.util.List;
import com.ruoyi.finance.domain.HipBillReceived;

/**
 * 销售收款Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-25
 */
public interface HipBillReceivedMapper 
{
    /**
     * 查询销售收款
     * 
     * @param receivedId 销售收款主键
     * @return 销售收款
     */
    public HipBillReceived selectHipBillReceivedByReceivedId(Integer receivedId);

    /**
     * 查询销售收款列表
     * 
     * @param hipBillReceived 销售收款
     * @return 销售收款集合
     */
    public List<HipBillReceived> selectHipBillReceivedList(HipBillReceived hipBillReceived);

    /**
     * 新增销售收款
     * 
     * @param hipBillReceived 销售收款
     * @return 结果
     */
    public int insertHipBillReceived(HipBillReceived hipBillReceived);

    /**
     * 修改销售收款
     * 
     * @param hipBillReceived 销售收款
     * @return 结果
     */
    public int updateHipBillReceived(HipBillReceived hipBillReceived);

    /**
     * 删除销售收款
     * 
     * @param receivedId 销售收款主键
     * @return 结果
     */
    public int deleteHipBillReceivedByReceivedId(Integer receivedId);

    /**
     * 批量删除销售收款
     * 
     * @param receivedIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipBillReceivedByReceivedIds(Integer[] receivedIds);
}
