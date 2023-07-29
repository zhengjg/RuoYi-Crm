package com.ruoyi.customer.mapper;

import java.util.List;
import com.ruoyi.customer.domain.HipContractOrder;

/**
 * 合同Mapper接口
 *
 * @author kevin
 * @date 2023-07-28
 */
public interface HipContractOrderMapper
{

    /**
     *
     *
     * @param contractNo
     * @return
     */
    public List<HipContractOrder> getContractProducts(String contractNo);

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
     * 删除合同
     *
     * @param contractOrderId 合同主键
     * @return 结果
     */
    public int deleteHipContractOrderByContractOrderId(Integer contractOrderId);

    /**
     * 批量删除合同
     *
     * @param contractOrderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipContractOrderByContractOrderIds(Integer[] contractOrderIds);
}
