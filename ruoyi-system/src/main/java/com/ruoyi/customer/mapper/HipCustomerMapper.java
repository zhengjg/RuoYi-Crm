package com.ruoyi.customer.mapper;

import com.ruoyi.customer.domain.HipCustomer;

import java.util.List;


/**
 * 新建客户Mapper接口
 *
 * @author kevin
 * @date 2023-07-24
 */
public interface HipCustomerMapper
{
    /**
     * 查询新建客户
     *
     * @param customerId 新建客户主键
     * @return 新建客户
     */
    public HipCustomer selectHipCustomerByCustomerId(Integer customerId);

    /**
     * 查询新建客户列表
     *
     * @param hipCustomer 新建客户
     * @return 新建客户集合
     */
    public List<HipCustomer> selectHipCustomerList(HipCustomer hipCustomer);

    /**
     * 新增新建客户
     *
     * @param hipCustomer 新建客户
     * @return 结果
     */
    public int insertHipCustomer(HipCustomer hipCustomer);

    /**
     * 修改新建客户
     *
     * @param hipCustomer 新建客户
     * @return 结果
     */
    public int updateHipCustomer(HipCustomer hipCustomer);

    /**
     * 删除新建客户
     *
     * @param customerId 新建客户主键
     * @return 结果
     */
    public int deleteHipCustomerByCustomerId(Integer customerId);

    /**
     * 批量删除新建客户
     *
     * @param customerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipCustomerByCustomerIds(Integer[] customerIds);
}
