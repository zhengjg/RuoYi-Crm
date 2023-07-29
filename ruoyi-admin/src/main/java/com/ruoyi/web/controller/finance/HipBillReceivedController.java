package com.ruoyi.web.controller.finance;

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
import com.ruoyi.finance.domain.HipBillReceived;
import com.ruoyi.finance.service.IHipBillReceivedService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售收款Controller
 *
 * @author ruoyi
 * @date 2023-07-25
 */
@RestController
@RequestMapping("/finance/received")
public class HipBillReceivedController extends BaseController
{
    @Autowired
    private IHipBillReceivedService hipBillReceivedService;

    /**
     * 查询销售收款列表
     */
    @PreAuthorize("@ss.hasPermi('finance:received:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipBillReceived hipBillReceived)
    {
        startPage();
        List<HipBillReceived> list = hipBillReceivedService.selectHipBillReceivedList(hipBillReceived);
        return getDataTable(list);
    }

    /**
     * 导出销售收款列表
     */
    @PreAuthorize("@ss.hasPermi('finance:received:export')")
    @Log(title = "销售收款", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipBillReceived hipBillReceived)
    {
        List<HipBillReceived> list = hipBillReceivedService.selectHipBillReceivedList(hipBillReceived);
        ExcelUtil<HipBillReceived> util = new ExcelUtil<HipBillReceived>(HipBillReceived.class);
        util.exportExcel(response, list, "销售收款数据");
    }

    /**
     * 获取销售收款详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:received:query')")
    @GetMapping(value = "/{receivedId}")
    public AjaxResult getInfo(@PathVariable("receivedId") Integer receivedId)
    {
        return success(hipBillReceivedService.selectHipBillReceivedByReceivedId(receivedId));
    }

    /**
     * 新增销售收款
     */
    @PreAuthorize("@ss.hasPermi('finance:received:add')")
    @Log(title = "销售收款", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipBillReceived hipBillReceived)
    {
        return toAjax(hipBillReceivedService.insertHipBillReceived(hipBillReceived));
    }

    /**
     * 修改销售收款
     */
    @PreAuthorize("@ss.hasPermi('finance:received:edit')")
    @Log(title = "销售收款", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipBillReceived hipBillReceived)
    {
        return toAjax(hipBillReceivedService.updateHipBillReceived(hipBillReceived));
    }

    /**
     * 删除销售收款
     */
    @PreAuthorize("@ss.hasPermi('finance:received:remove')")
    @Log(title = "销售收款", businessType = BusinessType.DELETE)
	@DeleteMapping("/{receivedIds}")
    public AjaxResult remove(@PathVariable Integer[] receivedIds)
    {
        return toAjax(hipBillReceivedService.deleteHipBillReceivedByReceivedIds(receivedIds));
    }
}
