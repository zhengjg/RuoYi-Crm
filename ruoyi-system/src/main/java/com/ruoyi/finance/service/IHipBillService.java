package com.ruoyi.finance.service;

import com.ruoyi.finance.domain.HipBill;

import java.util.List;

/**
 * financeService接口
 *
 * @author kevin
 * @date 2023-07-24
 */
public interface IHipBillService
{
    /**
     * 查询finance
     *
     * @param billId finance主键
     * @return finance
     */
    public HipBill selectHipBillByBillId(Integer billId);

    /**
     * 查询finance列表
     *
     * @param hipBill finance
     * @return finance集合
     */
    public List<HipBill> selectHipBillList(HipBill hipBill);

    /**
     * 新增finance
     *
     * @param hipBill finance
     * @return 结果
     */
    public int insertHipBill(HipBill hipBill);

    /**
     * 修改finance
     *
     * @param hipBill finance
     * @return 结果
     */
    public int updateHipBill(HipBill hipBill);

    /**
     * 批量删除finance
     *
     * @param billIds 需要删除的finance主键集合
     * @return 结果
     */
    public int deleteHipBillByBillIds(Integer[] billIds);

    /**
     * 删除finance信息
     *
     * @param billId finance主键
     * @return 结果
     */
    public int deleteHipBillByBillId(Integer billId);
}
