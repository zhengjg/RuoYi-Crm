package com.ruoyi.web.controller.product;

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
import com.ruoyi.product.domain.HipStockOut;
import com.ruoyi.product.service.IHipStockOutService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品出库Controller
 *
 * @author kevin
 * @date 2023-07-24
 */
@RestController
@RequestMapping("/product/stockout")
public class HipStockOutController extends BaseController
{
    @Autowired
    private IHipStockOutService hipStockOutService;

    /**
     * 查询产品出库列表
     */
    @PreAuthorize("@ss.hasPermi('product:stockout:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipStockOut hipStockOut)
    {
        startPage();
        List<HipStockOut> list = hipStockOutService.selectHipStockOutList(hipStockOut);
        return getDataTable(list);
    }

    /**
     * 导出产品出库列表
     */
    @PreAuthorize("@ss.hasPermi('product:stockout:export')")
    @Log(title = "产品出库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipStockOut hipStockOut)
    {
        List<HipStockOut> list = hipStockOutService.selectHipStockOutList(hipStockOut);
        ExcelUtil<HipStockOut> util = new ExcelUtil<HipStockOut>(HipStockOut.class);
        util.exportExcel(response, list, "产品出库数据");
    }

    /**
     * 获取产品出库详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:stockout:query')")
    @GetMapping(value = "/{stockOutId}")
    public AjaxResult getInfo(@PathVariable("stockOutId") Integer stockOutId)
    {
        return success(hipStockOutService.selectHipStockOutByStockOutId(stockOutId));
    }

    /**
     * 新增产品出库
     */
    @PreAuthorize("@ss.hasPermi('product:stockout:add')")
    @Log(title = "产品出库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipStockOut hipStockOut)
    {
        return toAjax(hipStockOutService.insertHipStockOut(hipStockOut));
    }

    /**
     * 修改产品出库
     */
    @PreAuthorize("@ss.hasPermi('product:stockout:edit')")
    @Log(title = "产品出库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipStockOut hipStockOut)
    {
        return toAjax(hipStockOutService.updateHipStockOut(hipStockOut));
    }

    /**
     * 删除产品出库
     */
    @PreAuthorize("@ss.hasPermi('product:stockout:remove')")
    @Log(title = "产品出库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stockOutIds}")
    public AjaxResult remove(@PathVariable Integer[] stockOutIds)
    {
        return toAjax(hipStockOutService.deleteHipStockOutByStockOutIds(stockOutIds));
    }
}
