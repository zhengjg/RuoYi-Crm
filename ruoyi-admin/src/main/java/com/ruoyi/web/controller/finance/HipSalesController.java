package com.ruoyi.web.controller.finance;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.finance.domain.HipSales;
import com.ruoyi.finance.service.IHipSalesService;
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
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 对账单Controller
 *
 * @author kevin
 * @date 2023-07-24
 */
@RestController
@RequestMapping("/finance/statementAccount")
public class HipSalesController extends BaseController
{
    @Autowired
    private IHipSalesService hipSalesService;

    /**
     * 查询对账单列表
     */
    @PreAuthorize("@ss.hasPermi('finance:statementAccount:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipSales hipSales)
    {
        startPage();
        List<HipSales> list = hipSalesService.selectHipSalesList(hipSales);
        return getDataTable(list);
    }

    /**
     * 导出对账单列表
     */
    @PreAuthorize("@ss.hasPermi('finance:statementAccount:export')")
    @Log(title = "对账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipSales hipSales)
    {
        List<HipSales> list = hipSalesService.selectHipSalesList(hipSales);
        ExcelUtil<HipSales> util = new ExcelUtil<HipSales>(HipSales.class);
        util.exportExcel(response, list, "对账单数据");
    }

    /**
     * 获取对账单详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:statementAccount:query')")
    @GetMapping(value = "/{salesId}")
    public AjaxResult getInfo(@PathVariable("salesId") Integer salesId)
    {
        return success(hipSalesService.selectHipSalesBySalesId(salesId));
    }

    /**
     * 新增对账单
     */
    @PreAuthorize("@ss.hasPermi('finance:statementAccount:add')")
    @Log(title = "对账单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipSales hipSales)
    {
        return toAjax(hipSalesService.insertHipSales(hipSales));
    }

    /**
     * 修改对账单
     */
    @PreAuthorize("@ss.hasPermi('finance:statementAccount:edit')")
    @Log(title = "对账单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipSales hipSales)
    {
        return toAjax(hipSalesService.updateHipSales(hipSales));
    }

    /**
     * 删除对账单
     */
    @PreAuthorize("@ss.hasPermi('finance:statementAccount:remove')")
    @Log(title = "对账单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{salesIds}")
    public AjaxResult remove(@PathVariable Integer[] salesIds)
    {
        return toAjax(hipSalesService.deleteHipSalesBySalesIds(salesIds));
    }
}
