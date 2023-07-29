package com.ruoyi.finance.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.finance.domain.HipBill;
import com.ruoyi.finance.mapper.HipBillMapper;
import com.ruoyi.finance.service.IHipBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * financeService业务层处理
 *
 * @author kevin
 * @date 2023-07-24
 */
@Service
public class HipBillServiceImpl implements IHipBillService
{
    @Autowired
    private HipBillMapper hipBillMapper;

    /**
     * 查询finance
     *
     * @param billId finance主键
     * @return finance
     */
    @Override
    public HipBill selectHipBillByBillId(Integer billId)
    {
        return hipBillMapper.selectHipBillByBillId(billId);
    }

    /**
     * 查询finance列表
     *
     * @param hipBill finance
     * @return finance
     */
    @Override
    public List<HipBill> selectHipBillList(HipBill hipBill)
    {
        return hipBillMapper.selectHipBillList(hipBill);
    }

    /**
     * 新增finance
     *
     * @param hipBill finance
     * @return 结果
     */
    @Override
    public int insertHipBill(HipBill hipBill)
    {
        hipBill.setCreateTime(DateUtils.getNowDate());
        return hipBillMapper.insertHipBill(hipBill);
    }

    /**
     * 修改finance
     *
     * @param hipBill finance
     * @return 结果
     */
    @Override
    public int updateHipBill(HipBill hipBill)
    {
        hipBill.setUpdateTime(DateUtils.getNowDate());
        return hipBillMapper.updateHipBill(hipBill);
    }

    /**
     * 批量删除finance
     *
     * @param billIds 需要删除的finance主键
     * @return 结果
     */
    @Override
    public int deleteHipBillByBillIds(Integer[] billIds)
    {
        return hipBillMapper.deleteHipBillByBillIds(billIds);
    }

    /**
     * 删除finance信息
     *
     * @param billId finance主键
     * @return 结果
     */
    @Override
    public int deleteHipBillByBillId(Integer billId)
    {
        return hipBillMapper.deleteHipBillByBillId(billId);
    }
}
