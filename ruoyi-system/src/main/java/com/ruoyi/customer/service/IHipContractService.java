package com.ruoyi.customer.service;

import java.util.List;
import com.ruoyi.customer.domain.HipContract;

/**
 * 合同Service接口
 *
 * @author kevin
 * @date 2023-07-28
 */
public interface IHipContractService
{

    /**
     * 合同已同意，生成待出库
     *
     * @param customerId 合同
     * @return 合同集合
     */
    public List<HipContract> getOrderByCustomerId(String customerId);

    /**
     * 查询合同
     *
     * @param contractId 合同主键
     * @return 合同
     */
    public HipContract selectHipContractByContractId(Integer contractId);

    /**
     * 查询合同列表
     *
     * @param hipContract 合同
     * @return 合同集合
     */
    public List<HipContract> selectHipContractList(HipContract hipContract);

    /**
     * 新增合同
     *
     * @param hipContract 合同
     * @return 结果
     */
    public int insertHipContract(HipContract hipContract);

    /**
     * 修改合同
     *
     * @param hipContract 合同
     * @return 结果
     */
    public int updateHipContract(HipContract hipContract);

    /**
     * 批量删除合同
     *
     * @param contractIds 需要删除的合同主键集合
     * @return 结果
     */
    public int deleteHipContractByContractIds(Integer[] contractIds);

    /**
     * 删除合同信息
     *
     * @param contractId 合同主键
     * @return 结果
     */
    public int deleteHipContractByContractId(Integer contractId);
}
