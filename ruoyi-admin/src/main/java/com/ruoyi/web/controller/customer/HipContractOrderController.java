package com.ruoyi.web.controller.customer;

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
import com.ruoyi.customer.domain.HipContractOrder;
import com.ruoyi.customer.service.IHipContractOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同Controller
 *
 * @author kevin
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/customer/order")
public class HipContractOrderController extends BaseController
{
    @Autowired
    private IHipContractOrderService hipContractOrderService;

    /**
     * 查询合同列表
     */
    @PreAuthorize("@ss.hasPermi('customer:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipContractOrder hipContractOrder)
    {
        startPage();
        List<HipContractOrder> list = hipContractOrderService.selectHipContractOrderList(hipContractOrder);
        return getDataTable(list);
    }

    /**
     * 导出合同列表
     */
    @PreAuthorize("@ss.hasPermi('customer:order:export')")
    @Log(title = "合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipContractOrder hipContractOrder)
    {
        List<HipContractOrder> list = hipContractOrderService.selectHipContractOrderList(hipContractOrder);
        ExcelUtil<HipContractOrder> util = new ExcelUtil<HipContractOrder>(HipContractOrder.class);
        util.exportExcel(response, list, "合同数据");
    }

    /**
     * 获取合同详细信息
     */
    @PreAuthorize("@ss.hasPermi('customer:order:query')")
    @GetMapping(value = "/{contractOrderId}")
    public AjaxResult getInfo(@PathVariable("contractOrderId") Integer contractOrderId)
    {
        return success(hipContractOrderService.selectHipContractOrderByContractOrderId(contractOrderId));
    }

    /**
     * 新增合同
     */
    @PreAuthorize("@ss.hasPermi('customer:order:add')")
    @Log(title = "合同", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipContractOrder hipContractOrder)
    {
        return toAjax(hipContractOrderService.insertHipContractOrder(hipContractOrder));
    }

    /**
     * 修改合同
     */
    @PreAuthorize("@ss.hasPermi('customer:order:edit')")
    @Log(title = "合同", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipContractOrder hipContractOrder)
    {
        return toAjax(hipContractOrderService.updateHipContractOrder(hipContractOrder));
    }

    /**
     * 删除合同
     */
    @PreAuthorize("@ss.hasPermi('customer:order:remove')")
    @Log(title = "合同", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contractOrderIds}")
    public AjaxResult remove(@PathVariable Integer[] contractOrderIds)
    {
        return toAjax(hipContractOrderService.deleteHipContractOrderByContractOrderIds(contractOrderIds));
    }
}
