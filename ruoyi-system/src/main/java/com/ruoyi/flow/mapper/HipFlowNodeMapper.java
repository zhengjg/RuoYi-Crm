package com.ruoyi.flow.mapper;

import java.util.List;
import com.ruoyi.flow.domain.HipFlowNode;

/**
 * 流程节点Mapper接口
 * 
 * @author kevin
 * @date 2023-07-28
 */
public interface HipFlowNodeMapper 
{
    /**
     * 查询流程节点
     * 
     * @param flowNodeId 流程节点主键
     * @return 流程节点
     */
    public HipFlowNode selectHipFlowNodeByFlowNodeId(Integer flowNodeId);

    /**
     * 查询流程节点列表
     * 
     * @param hipFlowNode 流程节点
     * @return 流程节点集合
     */
    public List<HipFlowNode> selectHipFlowNodeList(HipFlowNode hipFlowNode);

    /**
     * 新增流程节点
     * 
     * @param hipFlowNode 流程节点
     * @return 结果
     */
    public int insertHipFlowNode(HipFlowNode hipFlowNode);

    /**
     * 修改流程节点
     * 
     * @param hipFlowNode 流程节点
     * @return 结果
     */
    public int updateHipFlowNode(HipFlowNode hipFlowNode);

    /**
     * 删除流程节点
     * 
     * @param flowNodeId 流程节点主键
     * @return 结果
     */
    public int deleteHipFlowNodeByFlowNodeId(Integer flowNodeId);

    /**
     * 批量删除流程节点
     * 
     * @param flowNodeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipFlowNodeByFlowNodeIds(Integer[] flowNodeIds);
}
