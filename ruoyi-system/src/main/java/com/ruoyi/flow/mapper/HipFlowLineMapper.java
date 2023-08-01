package com.ruoyi.flow.mapper;

import java.util.List;
import com.ruoyi.flow.domain.HipFlowLine;

/**
 * 流程线Mapper接口
 * 
 * @author kevin
 * @date 2023-07-28
 */
public interface HipFlowLineMapper 
{
    /**
     * 查询流程线
     * 
     * @param flowLineId 流程线主键
     * @return 流程线
     */
    public HipFlowLine selectHipFlowLineByFlowLineId(Integer flowLineId);

    /**
     * 查询流程线列表
     * 
     * @param hipFlowLine 流程线
     * @return 流程线集合
     */
    public List<HipFlowLine> selectHipFlowLineList(HipFlowLine hipFlowLine);

    /**
     * 新增流程线
     * 
     * @param hipFlowLine 流程线
     * @return 结果
     */
    public int insertHipFlowLine(HipFlowLine hipFlowLine);

    /**
     * 修改流程线
     * 
     * @param hipFlowLine 流程线
     * @return 结果
     */
    public int updateHipFlowLine(HipFlowLine hipFlowLine);

    /**
     * 删除流程线
     * 
     * @param flowLineId 流程线主键
     * @return 结果
     */
    public int deleteHipFlowLineByFlowLineId(Integer flowLineId);

    /**
     * 批量删除流程线
     * 
     * @param flowLineIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipFlowLineByFlowLineIds(Integer[] flowLineIds);
}
