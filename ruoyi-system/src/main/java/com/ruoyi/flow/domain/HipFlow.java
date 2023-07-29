package com.ruoyi.flow.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 流程对象 hip_flow
 * 
 * @author kevin
 * @date 2023-07-28
 */
public class HipFlow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流程编号，主键 */
    private Integer flowId;

    /** 流程号 */
    @Excel(name = "流程号")
    private Integer flowNo;

    /** 流程名 */
    @Excel(name = "流程名")
    private String flowName;

    public void setFlowId(Integer flowId) 
    {
        this.flowId = flowId;
    }

    public Integer getFlowId() 
    {
        return flowId;
    }
    public void setFlowNo(Integer flowNo) 
    {
        this.flowNo = flowNo;
    }

    public Integer getFlowNo() 
    {
        return flowNo;
    }
    public void setFlowName(String flowName) 
    {
        this.flowName = flowName;
    }

    public String getFlowName() 
    {
        return flowName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("flowId", getFlowId())
            .append("flowNo", getFlowNo())
            .append("flowName", getFlowName())
            .append("remark", getRemark())
            .toString();
    }
}
