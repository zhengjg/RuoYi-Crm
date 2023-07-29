package com.ruoyi.flow.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 流程审批对象 hip_leave_audit
 *
 * @author kevin
 * @date 2023-07-28
 */
public class HipLeaveAudit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审批编号 */
    private Integer auditId;

    /** 合同id对应 */
    @Excel(name = "合同id对应")
    private Integer leaveId;

    /** 节点编号 */
    @Excel(name = "节点编号")
    private Integer flowNodeId;

    /** 审批人Id */
    @Excel(name = "审批人Id")
    private Integer userId;

    /** 审批结果 */
    @Excel(name = "审批结果")
    private Integer auditResult;

    /** 审批人姓名 */
    @Excel(name = "审批人姓名")
    private String userName;

    /** 审批人意见 */
    @Excel(name = "审批人意见")
    private String auditInfo;

    /** 审批日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审批日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditDate;

    public void setAuditId(Integer auditId)
    {
        this.auditId = auditId;
    }

    public Integer getAuditId()
    {
        return auditId;
    }
    public void setLeaveId(Integer leaveId)
    {
        this.leaveId = leaveId;
    }

    public Integer getLeaveId()
    {
        return leaveId;
    }
    public void setFlowNodeId(Integer flowNodeId)
    {
        this.flowNodeId = flowNodeId;
    }

    public Integer getFlowNodeId()
    {
        return flowNodeId;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }
    public void setAuditResult(Integer auditResult)
    {
        this.auditResult = auditResult;
    }

    public Integer getAuditResult()
    {
        return auditResult;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setAuditInfo(String auditInfo)
    {
        this.auditInfo = auditInfo;
    }

    public String getAuditInfo()
    {
        return auditInfo;
    }
    public void setAuditDate(Date auditDate)
    {
        this.auditDate = auditDate;
    }

    public Date getAuditDate()
    {
        return auditDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("auditId", getAuditId())
                .append("leaveId", getLeaveId())
                .append("flowNodeId", getFlowNodeId())
                .append("userId", getUserId())
                .append("auditResult", getAuditResult())
                .append("userName", getUserName())
                .append("auditInfo", getAuditInfo())
                .append("auditDate", getAuditDate())
                .toString();
    }
}
