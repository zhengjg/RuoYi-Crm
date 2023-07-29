package com.ruoyi.web.controller.flow;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.flow.domain.HipFlow;
import com.ruoyi.flow.service.IHipFlowService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 流程Controller
 *
 * @author kevin
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/flow/flow")
public class HipFlowController extends BaseController
{
    @Autowired
    private IHipFlowService hipFlowService;

    /**
     * 查询流程列表
     */
    @PreAuthorize("@ss.hasPermi('flow:flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipFlow hipFlow)
    {
        startPage();
        List<HipFlow> list = hipFlowService.selectHipFlowList(hipFlow);
        return getDataTable(list);
    }

    /**
     * 导出流程列表
     */
    @PreAuthorize("@ss.hasPermi('flow:flow:export')")
    @Log(title = "流程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipFlow hipFlow)
    {
        List<HipFlow> list = hipFlowService.selectHipFlowList(hipFlow);
        ExcelUtil<HipFlow> util = new ExcelUtil<HipFlow>(HipFlow.class);
        util.exportExcel(response, list, "流程数据");
    }

    /**
     * 获取流程详细信息
     */
    @PreAuthorize("@ss.hasPermi('flow:flow:query')")
    @GetMapping(value = "/{flowId}")
    public AjaxResult getInfo(@PathVariable("flowId") Integer flowId)
    {
        return success(hipFlowService.selectHipFlowByFlowId(flowId));
    }

    /**
     * 新增流程
     */
    @PreAuthorize("@ss.hasPermi('flow:flow:add')")
    @Log(title = "流程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipFlow hipFlow)
    {
        return toAjax(hipFlowService.insertHipFlow(hipFlow));
    }

    /**
     * 修改流程
     */
    @PreAuthorize("@ss.hasPermi('flow:flow:edit')")
    @Log(title = "流程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipFlow hipFlow)
    {
        return toAjax(hipFlowService.updateHipFlow(hipFlow));
    }

    /**
     * 删除流程
     */
    @PreAuthorize("@ss.hasPermi('flow:flow:remove')")
    @Log(title = "流程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{flowIds}")
    public AjaxResult remove(@PathVariable Integer[] flowIds)
    {
        return toAjax(hipFlowService.deleteHipFlowByFlowIds(flowIds));
    }
}
