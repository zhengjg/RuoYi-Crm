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
import com.ruoyi.product.domain.HipStockIn;
import com.ruoyi.product.service.IHipStockInService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品入库Controller
 *
 * @author kevin
 * @date 2023-07-24
 */
@RestController
@RequestMapping("/product/stockIn")
public class HipStockInController extends BaseController
{
    @Autowired
    private IHipStockInService hipStockInService;

    /**
     * 查询产品入库列表
     */
    @PreAuthorize("@ss.hasPermi('product:stockIn:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipStockIn hipStockIn)
    {
        startPage();
        List<HipStockIn> list = hipStockInService.selectHipStockInList(hipStockIn);
        return getDataTable(list);
    }

    /**
     * 导出产品入库列表
     */
    @PreAuthorize("@ss.hasPermi('product:stockIn:export')")
    @Log(title = "产品入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipStockIn hipStockIn)
    {
        List<HipStockIn> list = hipStockInService.selectHipStockInList(hipStockIn);
        ExcelUtil<HipStockIn> util = new ExcelUtil<HipStockIn>(HipStockIn.class);
        util.exportExcel(response, list, "产品入库数据");
    }

    /**
     * 获取产品入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:stockIn:query')")
    @GetMapping(value = "/{stockInId}")
    public AjaxResult getInfo(@PathVariable("stockInId") Integer stockInId)
    {
        return success(hipStockInService.selectHipStockInByStockInId(stockInId));
    }

    /**
     * 新增产品入库
     */
    @PreAuthorize("@ss.hasPermi('product:stockIn:add')")
    @Log(title = "产品入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipStockIn hipStockIn)
    {
        return toAjax(hipStockInService.insertHipStockIn(hipStockIn));
    }

    /**
     * 修改产品入库
     */
    @PreAuthorize("@ss.hasPermi('product:stockIn:edit')")
    @Log(title = "产品入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipStockIn hipStockIn)
    {
        return toAjax(hipStockInService.updateHipStockIn(hipStockIn));
    }

    /**
     * 删除产品入库
     */
    @PreAuthorize("@ss.hasPermi('product:stockIn:remove')")
    @Log(title = "产品入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stockInIds}")
    public AjaxResult remove(@PathVariable Integer[] stockInIds)
    {
        return toAjax(hipStockInService.deleteHipStockInByStockInIds(stockInIds));
    }
}
