package com.ruoyi.flow.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.flow.mapper.HipFlowNodeMapper;
import com.ruoyi.flow.domain.HipFlowNode;
import com.ruoyi.flow.service.IHipFlowNodeService;

/**
 * 流程节点Service业务层处理
 * 
 * @author kevin
 * @date 2023-07-28
 */
@Service
public class HipFlowNodeServiceImpl implements IHipFlowNodeService 
{
    @Autowired
    private HipFlowNodeMapper hipFlowNodeMapper;

    /**
     * 查询流程节点
     * 
     * @param flowNodeId 流程节点主键
     * @return 流程节点
     */
    @Override
    public HipFlowNode selectHipFlowNodeByFlowNodeId(Integer flowNodeId)
    {
        return hipFlowNodeMapper.selectHipFlowNodeByFlowNodeId(flowNodeId);
    }

    /**
     * 查询流程节点列表
     * 
     * @param hipFlowNode 流程节点
     * @return 流程节点
     */
    @Override
    public List<HipFlowNode> selectHipFlowNodeList(HipFlowNode hipFlowNode)
    {
        return hipFlowNodeMapper.selectHipFlowNodeList(hipFlowNode);
    }

    /**
     * 新增流程节点
     * 
     * @param hipFlowNode 流程节点
     * @return 结果
     */
    @Override
    public int insertHipFlowNode(HipFlowNode hipFlowNode)
    {
        return hipFlowNodeMapper.insertHipFlowNode(hipFlowNode);
    }

    /**
     * 修改流程节点
     * 
     * @param hipFlowNode 流程节点
     * @return 结果
     */
    @Override
    public int updateHipFlowNode(HipFlowNode hipFlowNode)
    {
        return hipFlowNodeMapper.updateHipFlowNode(hipFlowNode);
    }

    /**
     * 批量删除流程节点
     * 
     * @param flowNodeIds 需要删除的流程节点主键
     * @return 结果
     */
    @Override
    public int deleteHipFlowNodeByFlowNodeIds(Integer[] flowNodeIds)
    {
        return hipFlowNodeMapper.deleteHipFlowNodeByFlowNodeIds(flowNodeIds);
    }

    /**
     * 删除流程节点信息
     * 
     * @param flowNodeId 流程节点主键
     * @return 结果
     */
    @Override
    public int deleteHipFlowNodeByFlowNodeId(Integer flowNodeId)
    {
        return hipFlowNodeMapper.deleteHipFlowNodeByFlowNodeId(flowNodeId);
    }
}
