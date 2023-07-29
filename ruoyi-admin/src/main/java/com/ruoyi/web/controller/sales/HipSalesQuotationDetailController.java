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
import com.ruoyi.sales.domain.HipSalesQuotationDetail;
import com.ruoyi.sales.service.IHipSalesQuotationDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售报价产品Controller
 *
 * @author ruoyi
 * @date 2023-07-25
 */
@RestController
@RequestMapping("/sales/productList")
public class HipSalesQuotationDetailController extends BaseController
{
    @Autowired
    private IHipSalesQuotationDetailService hipSalesQuotationDetailService;

    /**
     * 查询销售报价产品列表
     */
    @PreAuthorize("@ss.hasPermi('sales:productList:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipSalesQuotationDetail hipSalesQuotationDetail)
    {
        startPage();
        List<HipSalesQuotationDetail> list = hipSalesQuotationDetailService.selectHipSalesQuotationDetailList(hipSalesQuotationDetail);
        return getDataTable(list);
    }

    /**
     * 导出销售报价产品列表
     */
    @PreAuthorize("@ss.hasPermi('sales:productList:export')")
    @Log(title = "销售报价产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipSalesQuotationDetail hipSalesQuotationDetail)
    {
        List<HipSalesQuotationDetail> list = hipSalesQuotationDetailService.selectHipSalesQuotationDetailList(hipSalesQuotationDetail);
        ExcelUtil<HipSalesQuotationDetail> util = new ExcelUtil<HipSalesQuotationDetail>(HipSalesQuotationDetail.class);
        util.exportExcel(response, list, "销售报价产品数据");
    }

    /**
     * 获取销售报价产品详细信息
     */
    @PreAuthorize("@ss.hasPermi('sales:productList:query')")
    @GetMapping(value = "/{quotationDetailId}")
    public AjaxResult getInfo(@PathVariable("quotationDetailId") Integer quotationDetailId)
    {
        return success(hipSalesQuotationDetailService.selectHipSalesQuotationDetailByQuotationDetailId(quotationDetailId));
    }

    /**
     * 新增销售报价产品
     */
    @PreAuthorize("@ss.hasPermi('sales:productList:add')")
    @Log(title = "销售报价产品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipSalesQuotationDetail hipSalesQuotationDetail)
    {
        return toAjax(hipSalesQuotationDetailService.insertHipSalesQuotationDetail(hipSalesQuotationDetail));
    }

    /**
     * 修改销售报价产品
     */
    @PreAuthorize("@ss.hasPermi('sales:productList:edit')")
    @Log(title = "销售报价产品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipSalesQuotationDetail hipSalesQuotationDetail)
    {
        return toAjax(hipSalesQuotationDetailService.updateHipSalesQuotationDetail(hipSalesQuotationDetail));
    }

    /**
     * 删除销售报价产品
     */
    @PreAuthorize("@ss.hasPermi('sales:productList:remove')")
    @Log(title = "销售报价产品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{quotationDetailIds}")
    public AjaxResult remove(@PathVariable Integer[] quotationDetailIds)
    {
        return toAjax(hipSalesQuotationDetailService.deleteHipSalesQuotationDetailByQuotationDetailIds(quotationDetailIds));
    }
}
