package com.ruoyi.customer.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.customer.mapper.HipContractOrderMapper;
import com.ruoyi.flow.domain.HipFlowNode;
import com.ruoyi.flow.service.IHipFlowNodeService;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.customer.domain.HipContractOrder;
import com.ruoyi.customer.mapper.HipContractMapper;
import com.ruoyi.customer.domain.HipContract;
import com.ruoyi.customer.service.IHipContractService;

/**
 * 合同Service业务层处理
 *
 * @author kevin
 * @date 2023-07-28
 */
@Service
public class HipContractServiceImpl implements IHipContractService
{
    @Autowired
    private HipContractMapper hipContractMapper;

    @Autowired
    private HipContractOrderMapper hipContractOrderMapper;


    @Autowired
    private IHipFlowNodeService hipFlowNodeService;

    @Override
    public List<HipContract> getOrderByCustomerId(String customerId) {
        List<HipContract> hipContracts = hipContractMapper.getOrderByCustomerId(customerId);
        if(!Collections.isEmpty(hipContracts)) {
            for(HipContract hipContract: hipContracts){
                List<HipContractOrder> contractOrders = hipContractOrderMapper.getContractProducts(hipContract.getContractNo());
                if(!Collections.isEmpty(contractOrders)) {
                    hipContract.setHipContractOrderList(contractOrders);
                }
            }
//            hipContracts.stream().forEach(e ->{
//                List<HipContractOrder> contractOrders = hipContractOrderMapper.getContractProducts(Integer.parseInt(e.getContractNo()));
//                if(!Collections.isEmpty(contractOrders)) {
//                    e.setHipContractOrderList(contractOrders);
//                }
//            });
        }
        return hipContracts;
    }

    /**
     * 查询合同
     *
     * @param contractId 合同主键
     * @return 合同
     */
    @Override
    public HipContract selectHipContractByContractId(Integer contractId)
    {
        return hipContractMapper.selectHipContractByContractId(contractId);
    }

    /**
     * 查询合同列表
     *
     * @param hipContract 合同
     * @return 合同
     */
    @Override
    public List<HipContract> selectHipContractList(HipContract hipContract)
    {
        return hipContractMapper.selectHipContractList(hipContract);
    }

    /**
     * 新增合同
     *
     * @param hipContract 合同
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHipContract(HipContract hipContract)
    {
        hipContract.setCreateTime(DateUtils.getNowDate());
        int rows = hipContractMapper.insertHipContract(hipContract);
        insertHipContractOrder(hipContract);

        HipFlowNode flowNode = new HipFlowNode();
        flowNode.setFlowNo(2);
        flowNode.setFlowNodeId(1);
        flowNode.setFlowNodeRole(1);
        flowNode.setFlowNodeName("合同申请");
        hipFlowNodeService.insertHipFlowNode(flowNode);
        return rows;
    }

    /**
     * 修改合同
     *
     * @param hipContract 合同
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHipContract(HipContract hipContract)
    {
        hipContract.setUpdateTime(DateUtils.getNowDate());
        hipContractMapper.deleteHipContractOrderByContractNo(hipContract.getContractId());
        insertHipContractOrder(hipContract);
        return hipContractMapper.updateHipContract(hipContract);
    }

    /**
     * 批量删除合同
     *
     * @param contractIds 需要删除的合同主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHipContractByContractIds(Integer[] contractIds)
    {
        hipContractMapper.deleteHipContractOrderByContractNos(contractIds);
        return hipContractMapper.deleteHipContractByContractIds(contractIds);
    }

    /**
     * 删除合同信息
     *
     * @param contractId 合同主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHipContractByContractId(Integer contractId)
    {
        hipContractMapper.deleteHipContractOrderByContractNo(contractId);
        return hipContractMapper.deleteHipContractByContractId(contractId);
    }

    /**
     * 新增合同信息
     *
     * @param hipContract 合同对象
     */
    public void insertHipContractOrder(HipContract hipContract)
    {
        List<HipContractOrder> hipContractOrderList = hipContract.getHipContractOrderList();
        String contractNo = hipContract.getContractNo();
        if (StringUtils.isNotNull(hipContractOrderList))
        {
            List<HipContractOrder> list = new ArrayList<HipContractOrder>();
            for (HipContractOrder hipContractOrder : hipContractOrderList)
            {
                hipContractOrder.setContractNo(contractNo);
                hipContractOrder.setProductId(1);
                list.add(hipContractOrder);
            }
            if (list.size() > 0)
            {
                hipContractMapper.batchHipContractOrder(list);
            }
        }
    }
}
