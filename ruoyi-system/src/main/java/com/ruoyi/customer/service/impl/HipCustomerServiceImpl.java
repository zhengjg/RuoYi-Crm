package com.ruoyi.customer.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.customer.domain.HipCustomer;
import com.ruoyi.customer.mapper.HipCustomerMapper;
import com.ruoyi.customer.service.IHipCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 新建客户Service业务层处理
 *
 * @author kevin
 * @date 2023-07-24
 */
@Service
public class HipCustomerServiceImpl implements IHipCustomerService
{
    @Autowired
    private HipCustomerMapper hipCustomerMapper;

    /**
     * 查询新建客户
     *
     * @param customerId 新建客户主键
     * @return 新建客户
     */
    @Override
    public HipCustomer selectHipCustomerByCustomerId(Integer customerId)
    {
        return hipCustomerMapper.selectHipCustomerByCustomerId(customerId);
    }

    /**
     * 查询新建客户列表
     *
     * @param hipCustomer 新建客户
     * @return 新建客户
     */
    @Override
    public List<HipCustomer> selectHipCustomerList(HipCustomer hipCustomer)
    {
        return hipCustomerMapper.selectHipCustomerList(hipCustomer);
    }

    /**
     * 新增新建客户
     *
     * @param hipCustomer 新建客户
     * @return 结果
     */
    @Override
    public int insertHipCustomer(HipCustomer hipCustomer)
    {
        hipCustomer.setCreateTime(DateUtils.getNowDate());
        return hipCustomerMapper.insertHipCustomer(hipCustomer);
    }

    /**
     * 修改新建客户
     *
     * @param hipCustomer 新建客户
     * @return 结果
     */
    @Override
    public int updateHipCustomer(HipCustomer hipCustomer)
    {
        hipCustomer.setUpdateTime(DateUtils.getNowDate());
        return hipCustomerMapper.updateHipCustomer(hipCustomer);
    }

    /**
     * 批量删除新建客户
     *
     * @param customerIds 需要删除的新建客户主键
     * @return 结果
     */
    @Override
    public int deleteHipCustomerByCustomerIds(Integer[] customerIds)
    {
        return hipCustomerMapper.deleteHipCustomerByCustomerIds(customerIds);
    }

    /**
     * 删除新建客户信息
     *
     * @param customerId 新建客户主键
     * @return 结果
     */
    @Override
    public int deleteHipCustomerByCustomerId(Integer customerId)
    {
        return hipCustomerMapper.deleteHipCustomerByCustomerId(customerId);
    }
}
