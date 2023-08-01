package com.ruoyi.flow.mapper;

import java.util.List;
import com.ruoyi.flow.domain.HipFlowRoleUser;

/**
 * 流程角色用户Mapper接口
 * 
 * @author kevin
 * @date 2023-07-28
 */
public interface HipFlowRoleUserMapper 
{
    /**
     * 查询流程角色用户
     * 
     * @param userId 流程角色用户主键
     * @return 流程角色用户
     */
    public HipFlowRoleUser selectHipFlowRoleUserByUserId(Integer userId);

    /**
     * 查询流程角色用户列表
     * 
     * @param hipFlowRoleUser 流程角色用户
     * @return 流程角色用户集合
     */
    public List<HipFlowRoleUser> selectHipFlowRoleUserList(HipFlowRoleUser hipFlowRoleUser);

    /**
     * 新增流程角色用户
     * 
     * @param hipFlowRoleUser 流程角色用户
     * @return 结果
     */
    public int insertHipFlowRoleUser(HipFlowRoleUser hipFlowRoleUser);

    /**
     * 修改流程角色用户
     * 
     * @param hipFlowRoleUser 流程角色用户
     * @return 结果
     */
    public int updateHipFlowRoleUser(HipFlowRoleUser hipFlowRoleUser);

    /**
     * 删除流程角色用户
     * 
     * @param userId 流程角色用户主键
     * @return 结果
     */
    public int deleteHipFlowRoleUserByUserId(Integer userId);

    /**
     * 批量删除流程角色用户
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipFlowRoleUserByUserIds(Integer[] userIds);
}
