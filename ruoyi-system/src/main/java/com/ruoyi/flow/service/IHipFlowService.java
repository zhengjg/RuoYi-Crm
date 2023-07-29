package com.ruoyi.flow.service;

import java.util.List;
import com.ruoyi.flow.domain.HipFlow;
import com.ruoyi.flow.domain.HipFlowLine;
import com.ruoyi.flow.domain.HipFlowNode;

/**
 * 流程Service接口
 *
 * @author kevin
 * @date 2023-07-28
 */
public interface IHipFlowService
{
    /**
     * 查询流程
     *
     * @param flowId 流程主键
     * @return 流程
     */
    public HipFlow selectHipFlowByFlowId(Integer flowId);

    /**
     * 查询流程列表
     *
     * @param hipFlow 流程
     * @return 流程集合
     */
    public List<HipFlow> selectHipFlowList(HipFlow hipFlow);

    /**
     * 新增流程
     *
     * @param hipFlow 流程
     * @return 结果
     */
    public int insertHipFlow(HipFlow hipFlow);

    /**
     * 修改流程
     *
     * @param hipFlow 流程
     * @return 结果
     */
    public int updateHipFlow(HipFlow hipFlow);

    /**
     * 批量删除流程
     *
     * @param flowIds 需要删除的流程主键集合
     * @return 结果
     */
    public int deleteHipFlowByFlowIds(Integer[] flowIds);

    /**
     * 删除流程信息
     *
     * @param flowId 流程主键
     * @return 结果
     */
    public int deleteHipFlowByFlowId(Integer flowId);


//    public int apply(HipFlowNode hipFlowNode, HipFlowLine hipFlowLine);
//
//    public int audit(Integer flowId);



}
