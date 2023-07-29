package com.ruoyi.flow.mapper;

import java.util.List;
import com.ruoyi.flow.domain.HipLeaveAudit;

/**
 * 流程审批Mapper接口
 *
 * @author kevin
 * @date 2023-07-28
 */
public interface HipLeaveAuditMapper
{
    /**
     * 查询流程审批
     *
     * @param auditId 流程审批主键
     * @return 流程审批
     */
    public HipLeaveAudit selectHipLeaveAuditByAuditId(Integer auditId);

    /**
     * 查询流程审批列表
     *
     * @param hipLeaveAudit 流程审批
     * @return 流程审批集合
     */
    public List<HipLeaveAudit> selectHipLeaveAuditList(HipLeaveAudit hipLeaveAudit);

    /**
     * 新增流程审批
     *
     * @param hipLeaveAudit 流程审批
     * @return 结果
     */
    public int insertHipLeaveAudit(HipLeaveAudit hipLeaveAudit);

    /**
     * 修改流程审批
     *
     * @param hipLeaveAudit 流程审批
     * @return 结果
     */
    public int updateHipLeaveAudit(HipLeaveAudit hipLeaveAudit);

    /**
     * 删除流程审批
     *
     * @param auditId 流程审批主键
     * @return 结果
     */
    public int deleteHipLeaveAuditByAuditId(Integer auditId);

    /**
     * 批量删除流程审批
     *
     * @param auditIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipLeaveAuditByAuditIds(Integer[] auditIds);
}
