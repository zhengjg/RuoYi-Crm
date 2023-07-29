package com.ruoyi.flow.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.flow.mapper.HipFlowMapper;
import com.ruoyi.flow.domain.HipFlow;
import com.ruoyi.flow.service.IHipFlowService;

/**
 * 流程Service业务层处理
 * 
 * @author kevin
 * @date 2023-07-28
 */
@Service
public class HipFlowServiceImpl implements IHipFlowService 
{
    @Autowired
    private HipFlowMapper hipFlowMapper;

    /**
     * 查询流程
     * 
     * @param flowId 流程主键
     * @return 流程
     */
    @Override
    public HipFlow selectHipFlowByFlowId(Integer flowId)
    {
        return hipFlowMapper.selectHipFlowByFlowId(flowId);
    }

    /**
     * 查询流程列表
     * 
     * @param hipFlow 流程
     * @return 流程
     */
    @Override
    public List<HipFlow> selectHipFlowList(HipFlow hipFlow)
    {
        return hipFlowMapper.selectHipFlowList(hipFlow);
    }

    /**
     * 新增流程
     * 
     * @param hipFlow 流程
     * @return 结果
     */
    @Override
    public int insertHipFlow(HipFlow hipFlow)
    {
        return hipFlowMapper.insertHipFlow(hipFlow);
    }

    /**
     * 修改流程
     * 
     * @param hipFlow 流程
     * @return 结果
     */
    @Override
    public int updateHipFlow(HipFlow hipFlow)
    {
        return hipFlowMapper.updateHipFlow(hipFlow);
    }

    /**
     * 批量删除流程
     * 
     * @param flowIds 需要删除的流程主键
     * @return 结果
     */
    @Override
    public int deleteHipFlowByFlowIds(Integer[] flowIds)
    {
        return hipFlowMapper.deleteHipFlowByFlowIds(flowIds);
    }

    /**
     * 删除流程信息
     * 
     * @param flowId 流程主键
     * @return 结果
     */
    @Override
    public int deleteHipFlowByFlowId(Integer flowId)
    {
        return hipFlowMapper.deleteHipFlowByFlowId(flowId);
    }
}
