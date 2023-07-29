package com.ruoyi.flow.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 流程节点对象 hip_flow_node
 *
 * @author kevin
 * @date 2023-07-28
 */
public class HipFlowNode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流程节点编号，主键 */
    private Integer flowNodeId;

    /** 流程号，与流程表对应 */
    @Excel(name = "流程号，与流程表对应")
    private Integer flowNo;

    /** 流程节点名称 */
    @Excel(name = "流程节点名称")
    private String flowNodeName;

    /** 流程角色 */
    @Excel(name = "流程角色")
    private Integer flowNodeRole;

    public void setFlowNodeId(Integer flowNodeId)
    {
        this.flowNodeId = flowNodeId;
    }

    public Integer getFlowNodeId()
    {
        return flowNodeId;
    }
    public void setFlowNo(Integer flowNo)
    {
        this.flowNo = flowNo;
    }

    public Integer getFlowNo()
    {
        return flowNo;
    }
    public void setFlowNodeName(String flowNodeName)
    {
        this.flowNodeName = flowNodeName;
    }

    public String getFlowNodeName()
    {
        return flowNodeName;
    }
    public void setFlowNodeRole(Integer flowNodeRole)
    {
        this.flowNodeRole = flowNodeRole;
    }

    public Integer getFlowNodeRole()
    {
        return flowNodeRole;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("flowNodeId", getFlowNodeId())
            .append("flowNo", getFlowNo())
            .append("flowNodeName", getFlowNodeName())
            .append("flowNodeRole", getFlowNodeRole())
            .append("remark", getRemark())
            .toString();
    }
}
