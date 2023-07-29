package com.ruoyi.web.controller.finance;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.finance.domain.HipBill;
import com.ruoyi.finance.service.IHipBillService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * financeController
 *
 * @author kevin
 * @date 2023-07-24
 */
@RestController
@RequestMapping("/finance/receivable")
public class HipBillController extends BaseController
{
    @Autowired
    private IHipBillService hipBillService;

    /**
     * 查询finance列表
     */
    @PreAuthorize("@ss.hasPermi('finance:receivable:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipBill hipBill)
    {
        startPage();
        List<HipBill> list = hipBillService.selectHipBillList(hipBill);
        return getDataTable(list);
    }

    /**
     * 导出finance列表
     */
    @PreAuthorize("@ss.hasPermi('finance:receivable:export')")
    @Log(title = "finance", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipBill hipBill)
    {
        List<HipBill> list = hipBillService.selectHipBillList(hipBill);
        ExcelUtil<HipBill> util = new ExcelUtil<HipBill>(HipBill.class);
        util.exportExcel(response, list, "finance数据");
    }

    /**
     * 获取finance详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:receivable:query')")
    @GetMapping(value = "/{billId}")
    public AjaxResult getInfo(@PathVariable("billId") Integer billId)
    {
        return success(hipBillService.selectHipBillByBillId(billId));
    }

    /**
     * 新增finance
     */
    @PreAuthorize("@ss.hasPermi('finance:receivable:add')")
    @Log(title = "finance", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipBill hipBill)
    {
        return toAjax(hipBillService.insertHipBill(hipBill));
    }

    /**
     * 修改finance
     */
    @PreAuthorize("@ss.hasPermi('finance:receivable:edit')")
    @Log(title = "finance", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipBill hipBill)
    {
        return toAjax(hipBillService.updateHipBill(hipBill));
    }

    /**
     * 删除finance
     */
    @PreAuthorize("@ss.hasPermi('finance:receivable:remove')")
    @Log(title = "finance", businessType = BusinessType.DELETE)
	@DeleteMapping("/{billIds}")
    public AjaxResult remove(@PathVariable Integer[] billIds)
    {
        return toAjax(hipBillService.deleteHipBillByBillIds(billIds));
    }
}
