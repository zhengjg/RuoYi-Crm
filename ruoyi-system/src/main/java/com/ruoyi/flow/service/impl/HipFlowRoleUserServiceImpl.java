package com.ruoyi.flow.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.flow.mapper.HipFlowRoleUserMapper;
import com.ruoyi.flow.domain.HipFlowRoleUser;
import com.ruoyi.flow.service.IHipFlowRoleUserService;

/**
 * 流程角色用户Service业务层处理
 * 
 * @author kevin
 * @date 2023-07-28
 */
@Service
public class HipFlowRoleUserServiceImpl implements IHipFlowRoleUserService 
{
    @Autowired
    private HipFlowRoleUserMapper hipFlowRoleUserMapper;

    /**
     * 查询流程角色用户
     * 
     * @param userId 流程角色用户主键
     * @return 流程角色用户
     */
    @Override
    public HipFlowRoleUser selectHipFlowRoleUserByUserId(Integer userId)
    {
        return hipFlowRoleUserMapper.selectHipFlowRoleUserByUserId(userId);
    }

    /**
     * 查询流程角色用户列表
     * 
     * @param hipFlowRoleUser 流程角色用户
     * @return 流程角色用户
     */
    @Override
    public List<HipFlowRoleUser> selectHipFlowRoleUserList(HipFlowRoleUser hipFlowRoleUser)
    {
        return hipFlowRoleUserMapper.selectHipFlowRoleUserList(hipFlowRoleUser);
    }

    /**
     * 新增流程角色用户
     * 
     * @param hipFlowRoleUser 流程角色用户
     * @return 结果
     */
    @Override
    public int insertHipFlowRoleUser(HipFlowRoleUser hipFlowRoleUser)
    {
        return hipFlowRoleUserMapper.insertHipFlowRoleUser(hipFlowRoleUser);
    }

    /**
     * 修改流程角色用户
     * 
     * @param hipFlowRoleUser 流程角色用户
     * @return 结果
     */
    @Override
    public int updateHipFlowRoleUser(HipFlowRoleUser hipFlowRoleUser)
    {
        return hipFlowRoleUserMapper.updateHipFlowRoleUser(hipFlowRoleUser);
    }

    /**
     * 批量删除流程角色用户
     * 
     * @param userIds 需要删除的流程角色用户主键
     * @return 结果
     */
    @Override
    public int deleteHipFlowRoleUserByUserIds(Integer[] userIds)
    {
        return hipFlowRoleUserMapper.deleteHipFlowRoleUserByUserIds(userIds);
    }

    /**
     * 删除流程角色用户信息
     * 
     * @param userId 流程角色用户主键
     * @return 结果
     */
    @Override
    public int deleteHipFlowRoleUserByUserId(Integer userId)
    {
        return hipFlowRoleUserMapper.deleteHipFlowRoleUserByUserId(userId);
    }
}
