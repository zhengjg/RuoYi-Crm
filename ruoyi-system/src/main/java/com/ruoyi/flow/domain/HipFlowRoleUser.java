package com.ruoyi.flow.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 流程角色用户对象 hip_flow_role_user
 * 
 * @author kevin
 * @date 2023-07-28
 */
public class HipFlowRoleUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户Id */
    @Excel(name = "用户Id")
    private Integer userId;

    /** 角色Id */
    @Excel(name = "角色Id")
    private Integer roleId;

    /** 角色名称 */
    @Excel(name = "角色名称")
    private String flowRoleName;

    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setRoleId(Integer roleId) 
    {
        this.roleId = roleId;
    }

    public Integer getRoleId() 
    {
        return roleId;
    }
    public void setFlowRoleName(String flowRoleName) 
    {
        this.flowRoleName = flowRoleName;
    }

    public String getFlowRoleName() 
    {
        return flowRoleName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("roleId", getRoleId())
            .append("flowRoleName", getFlowRoleName())
            .toString();
    }
}
