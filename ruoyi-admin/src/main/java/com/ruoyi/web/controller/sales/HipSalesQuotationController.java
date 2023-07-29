package com.ruoyi.web.controller.sales;

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
import com.ruoyi.sales.domain.HipSalesQuotation;
import com.ruoyi.sales.service.IHipSalesQuotationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售报价Controller
 *
 * @author kevin
 * @date 2023-07-25
 */
@RestController
@RequestMapping("/sales/quotation")
public class HipSalesQuotationController extends BaseController
{
    @Autowired
    private IHipSalesQuotationService hipSalesQuotationService;

    /**
     * 查询销售报价列表
     */
    @PreAuthorize("@ss.hasPermi('sales:quotation:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipSalesQuotation hipSalesQuotation)
    {
        startPage();
        List<HipSalesQuotation> list = hipSalesQuotationService.selectHipSalesQuotationList(hipSalesQuotation);
        return getDataTable(list);
    }

    /**
     * 导出销售报价列表
     */
    @PreAuthorize("@ss.hasPermi('sales:quotation:export')")
    @Log(title = "销售报价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipSalesQuotation hipSalesQuotation)
    {
        List<HipSalesQuotation> list = hipSalesQuotationService.selectHipSalesQuotationList(hipSalesQuotation);
        ExcelUtil<HipSalesQuotation> util = new ExcelUtil<HipSalesQuotation>(HipSalesQuotation.class);
        util.exportExcel(response, list, "销售报价数据");
    }

    /**
     * 获取销售报价详细信息
     */
    @PreAuthorize("@ss.hasPermi('sales:quotation:query')")
    @GetMapping(value = "/{quotationId}")
    public AjaxResult getInfo(@PathVariable("quotationId") Integer quotationId)
    {
        return success(hipSalesQuotationService.selectHipSalesQuotationByQuotationId(quotationId));
    }

    /**
     * 新增销售报价
     */
    @PreAuthorize("@ss.hasPermi('sales:quotation:add')")
    @Log(title = "销售报价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipSalesQuotation hipSalesQuotation)
    {
        return toAjax(hipSalesQuotationService.insertHipSalesQuotation(hipSalesQuotation));
    }

    /**
     * 修改销售报价
     */
    @PreAuthorize("@ss.hasPermi('sales:quotation:edit')")
    @Log(title = "销售报价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipSalesQuotation hipSalesQuotation)
    {
        return toAjax(hipSalesQuotationService.updateHipSalesQuotation(hipSalesQuotation));
    }

    /**
     * 删除销售报价
     */
    @PreAuthorize("@ss.hasPermi('sales:quotation:remove')")
    @Log(title = "销售报价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{quotationIds}")
    public AjaxResult remove(@PathVariable Integer[] quotationIds)
    {
        return toAjax(hipSalesQuotationService.deleteHipSalesQuotationByQuotationIds(quotationIds));
    }
}
