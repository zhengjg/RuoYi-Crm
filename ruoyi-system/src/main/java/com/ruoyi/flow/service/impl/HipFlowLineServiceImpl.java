package com.ruoyi.flow.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.flow.mapper.HipFlowLineMapper;
import com.ruoyi.flow.domain.HipFlowLine;
import com.ruoyi.flow.service.IHipFlowLineService;

/**
 * 流程线Service业务层处理
 * 
 * @author kevin
 * @date 2023-07-28
 */
@Service
public class HipFlowLineServiceImpl implements IHipFlowLineService 
{
    @Autowired
    private HipFlowLineMapper hipFlowLineMapper;

    /**
     * 查询流程线
     * 
     * @param flowLineId 流程线主键
     * @return 流程线
     */
    @Override
    public HipFlowLine selectHipFlowLineByFlowLineId(Integer flowLineId)
    {
        return hipFlowLineMapper.selectHipFlowLineByFlowLineId(flowLineId);
    }

    /**
     * 查询流程线列表
     * 
     * @param hipFlowLine 流程线
     * @return 流程线
     */
    @Override
    public List<HipFlowLine> selectHipFlowLineList(HipFlowLine hipFlowLine)
    {
        return hipFlowLineMapper.selectHipFlowLineList(hipFlowLine);
    }

    /**
     * 新增流程线
     * 
     * @param hipFlowLine 流程线
     * @return 结果
     */
    @Override
    public int insertHipFlowLine(HipFlowLine hipFlowLine)
    {
        return hipFlowLineMapper.insertHipFlowLine(hipFlowLine);
    }

    /**
     * 修改流程线
     * 
     * @param hipFlowLine 流程线
     * @return 结果
     */
    @Override
    public int updateHipFlowLine(HipFlowLine hipFlowLine)
    {
        return hipFlowLineMapper.updateHipFlowLine(hipFlowLine);
    }

    /**
     * 批量删除流程线
     * 
     * @param flowLineIds 需要删除的流程线主键
     * @return 结果
     */
    @Override
    public int deleteHipFlowLineByFlowLineIds(Integer[] flowLineIds)
    {
        return hipFlowLineMapper.deleteHipFlowLineByFlowLineIds(flowLineIds);
    }

    /**
     * 删除流程线信息
     * 
     * @param flowLineId 流程线主键
     * @return 结果
     */
    @Override
    public int deleteHipFlowLineByFlowLineId(Integer flowLineId)
    {
        return hipFlowLineMapper.deleteHipFlowLineByFlowLineId(flowLineId);
    }
}
