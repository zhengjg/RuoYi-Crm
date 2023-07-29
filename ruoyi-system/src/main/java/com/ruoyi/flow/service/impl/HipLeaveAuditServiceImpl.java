package com.ruoyi.flow.service.impl;

import java.util.List;

import com.ruoyi.flow.domain.HipFlowNode;
import com.ruoyi.flow.service.IHipFlowNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.flow.mapper.HipLeaveAuditMapper;
import com.ruoyi.flow.domain.HipLeaveAudit;
import com.ruoyi.flow.service.IHipLeaveAuditService;

/**
 * 流程审批Service业务层处理
 *
 * @author kevin
 * @date 2023-07-28
 */
@Service
public class HipLeaveAuditServiceImpl implements IHipLeaveAuditService
{
    @Autowired
    private HipLeaveAuditMapper hipLeaveAuditMapper;

    @Autowired
    IHipFlowNodeService hipFlowNodeService;

//    @Autowired
//    IHipContractService iHipContractService;

    /**
     * 查询流程审批
     *
     * @param auditId 流程审批主键
     * @return 流程审批
     */
    @Override
    public HipLeaveAudit selectHipLeaveAuditByAuditId(Integer auditId)
    {
        return hipLeaveAuditMapper.selectHipLeaveAuditByAuditId(auditId);
    }

    /**
     * 查询流程审批列表
     *
     * @param hipLeaveAudit 流程审批
     * @return 流程审批
     */
    @Override
    public List<HipLeaveAudit> selectHipLeaveAuditList(HipLeaveAudit hipLeaveAudit)
    {
        return hipLeaveAuditMapper.selectHipLeaveAuditList(hipLeaveAudit);
    }

    /**
     * 新增流程审批
     *
     * @param hipLeaveAudit 流程审批
     * @return 结果
     */
    @Override
    public int insertHipLeaveAudit(HipLeaveAudit hipLeaveAudit)
    {
//        // 在流程节点里，新增审批记录
//        HipFlowNode hipFlowNode = new HipFlowNode();
//        hipFlowNode.setFlowNo(2);
//        hipFlowNode.setFlowNodeName("合同申请");
//        hipFlowNode.setFlowNodeRole(2);
//        hipFlowNode.setRemark("合同申请单");
//        hipFlowNodeService.insertHipFlowNode(hipFlowNode);
//        // 更新申请合同的流程状态为完成
////        iHipContractService.selectHipContractByContractId(hipLeaveAudit.getLeaveId());
//        HipContract hipContract = iHipContractService.selectHipContractByContractId(1);
//        hipContract.setStatus("2");
//        iHipContractService.updateHipContract(hipContract);

        // 生成

        return hipLeaveAuditMapper.insertHipLeaveAudit(hipLeaveAudit);
    }

    /**
     * 修改流程审批
     *
     * @param hipLeaveAudit 流程审批
     * @return 结果
     */
    @Override
    public int updateHipLeaveAudit(HipLeaveAudit hipLeaveAudit)
    {
        return hipLeaveAuditMapper.updateHipLeaveAudit(hipLeaveAudit);
    }

    /**
     * 批量删除流程审批
     *
     * @param auditIds 需要删除的流程审批主键
     * @return 结果
     */
    @Override
    public int deleteHipLeaveAuditByAuditIds(Integer[] auditIds)
    {
        return hipLeaveAuditMapper.deleteHipLeaveAuditByAuditIds(auditIds);
    }

    /**
     * 删除流程审批信息
     *
     * @param auditId 流程审批主键
     * @return 结果
     */
    @Override
    public int deleteHipLeaveAuditByAuditId(Integer auditId)
    {
        return hipLeaveAuditMapper.deleteHipLeaveAuditByAuditId(auditId);
    }
}
