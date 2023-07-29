package com.ruoyi.web.controller.stock;

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
import com.ruoyi.stock.domain.HipStockOutDetail;
import com.ruoyi.stock.service.IHipStockOutDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出库明细Controller
 *
 * @author kevin
 * @date 2023-07-25
 */
@RestController
@RequestMapping("/stock/outDetail")
public class HipStockOutDetailController extends BaseController
{
    @Autowired
    private IHipStockOutDetailService hipStockOutDetailService;

    /**
     * 查询出库明细列表
     */
    @PreAuthorize("@ss.hasPermi('stock:outDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipStockOutDetail hipStockOutDetail)
    {
        startPage();
        List<HipStockOutDetail> list = hipStockOutDetailService.selectHipStockOutDetailList(hipStockOutDetail);
        return getDataTable(list);
    }

    /**
     * 导出出库明细列表
     */
    @PreAuthorize("@ss.hasPermi('stock:outDetail:export')")
    @Log(title = "出库明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipStockOutDetail hipStockOutDetail)
    {
        List<HipStockOutDetail> list = hipStockOutDetailService.selectHipStockOutDetailList(hipStockOutDetail);
        ExcelUtil<HipStockOutDetail> util = new ExcelUtil<HipStockOutDetail>(HipStockOutDetail.class);
        util.exportExcel(response, list, "出库明细数据");
    }

    /**
     * 获取出库明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('stock:outDetail:query')")
    @GetMapping(value = "/{stockOutDetailId}")
    public AjaxResult getInfo(@PathVariable("stockOutDetailId") Integer stockOutDetailId)
    {
        return success(hipStockOutDetailService.selectHipStockOutDetailByStockOutDetailId(stockOutDetailId));
    }

    /**
     * 新增出库明细
     */
    @PreAuthorize("@ss.hasPermi('stock:outDetail:add')")
    @Log(title = "出库明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipStockOutDetail hipStockOutDetail)
    {
        return toAjax(hipStockOutDetailService.insertHipStockOutDetail(hipStockOutDetail));
    }

    /**
     * 修改出库明细
     */
    @PreAuthorize("@ss.hasPermi('stock:outDetail:edit')")
    @Log(title = "出库明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipStockOutDetail hipStockOutDetail)
    {
        return toAjax(hipStockOutDetailService.updateHipStockOutDetail(hipStockOutDetail));
    }

    /**
     * 删除出库明细
     */
    @PreAuthorize("@ss.hasPermi('stock:outDetail:remove')")
    @Log(title = "出库明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stockOutDetailIds}")
    public AjaxResult remove(@PathVariable Integer[] stockOutDetailIds)
    {
        return toAjax(hipStockOutDetailService.deleteHipStockOutDetailByStockOutDetailIds(stockOutDetailIds));
    }
}
