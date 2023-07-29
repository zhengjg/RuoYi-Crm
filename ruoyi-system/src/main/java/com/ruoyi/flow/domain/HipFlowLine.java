package com.ruoyi.flow.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 流程线对象 hip_flow_line
 * 
 * @author kevin
 * @date 2023-07-28
 */
public class HipFlowLine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流程节点编号，主键 */
    private Integer flowLineId;

    /** 流程号，与流程表对应 */
    @Excel(name = "流程号，与流程表对应")
    private Integer flowNo;

    /** 前一节点编号 */
    @Excel(name = "前一节点编号")
    private Integer prevNodeId;

    /** 后一节点编号 */
    @Excel(name = "后一节点编号")
    private Integer nextNodeId;

    public void setFlowLineId(Integer flowLineId) 
    {
        this.flowLineId = flowLineId;
    }

    public Integer getFlowLineId() 
    {
        return flowLineId;
    }
    public void setFlowNo(Integer flowNo) 
    {
        this.flowNo = flowNo;
    }

    public Integer getFlowNo() 
    {
        return flowNo;
    }
    public void setPrevNodeId(Integer prevNodeId) 
    {
        this.prevNodeId = prevNodeId;
    }

    public Integer getPrevNodeId() 
    {
        return prevNodeId;
    }
    public void setNextNodeId(Integer nextNodeId) 
    {
        this.nextNodeId = nextNodeId;
    }

    public Integer getNextNodeId() 
    {
        return nextNodeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("flowLineId", getFlowLineId())
            .append("flowNo", getFlowNo())
            .append("prevNodeId", getPrevNodeId())
            .append("nextNodeId", getNextNodeId())
            .append("remark", getRemark())
            .toString();
    }
}
