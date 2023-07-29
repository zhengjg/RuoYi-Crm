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
import com.ruoyi.stock.domain.HipStockInDetail;
import com.ruoyi.stock.service.IHipStockInDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 入库明细Controller
 *
 * @author kevin
 * @date 2023-07-25
 */
@RestController
@RequestMapping("/stock/inDetail")
public class HipStockInDetailController extends BaseController
{
    @Autowired
    private IHipStockInDetailService hipStockInDetailService;

    /**
     * 查询入库明细列表
     */
    @PreAuthorize("@ss.hasPermi('stock:inDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipStockInDetail hipStockInDetail)
    {
        startPage();
        List<HipStockInDetail> list = hipStockInDetailService.selectHipStockInDetailList(hipStockInDetail);
        return getDataTable(list);
    }

    /**
     * 导出入库明细列表
     */
    @PreAuthorize("@ss.hasPermi('stock:inDetail:export')")
    @Log(title = "入库明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipStockInDetail hipStockInDetail)
    {
        List<HipStockInDetail> list = hipStockInDetailService.selectHipStockInDetailList(hipStockInDetail);
        ExcelUtil<HipStockInDetail> util = new ExcelUtil<HipStockInDetail>(HipStockInDetail.class);
        util.exportExcel(response, list, "入库明细数据");
    }

    /**
     * 获取入库明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('stock:inDetail:query')")
    @GetMapping(value = "/{stockInDetailId}")
    public AjaxResult getInfo(@PathVariable("stockInDetailId") Integer stockInDetailId)
    {
        return success(hipStockInDetailService.selectHipStockInDetailByStockInDetailId(stockInDetailId));
    }

    /**
     * 新增入库明细
     */
    @PreAuthorize("@ss.hasPermi('stock:inDetail:add')")
    @Log(title = "入库明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipStockInDetail hipStockInDetail)
    {
        return toAjax(hipStockInDetailService.insertHipStockInDetail(hipStockInDetail));
    }

    /**
     * 修改入库明细
     */
    @PreAuthorize("@ss.hasPermi('stock:inDetail:edit')")
    @Log(title = "入库明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipStockInDetail hipStockInDetail)
    {
        return toAjax(hipStockInDetailService.updateHipStockInDetail(hipStockInDetail));
    }

    /**
     * 删除入库明细
     */
    @PreAuthorize("@ss.hasPermi('stock:inDetail:remove')")
    @Log(title = "入库明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stockInDetailIds}")
    public AjaxResult remove(@PathVariable Integer[] stockInDetailIds)
    {
        return toAjax(hipStockInDetailService.deleteHipStockInDetailByStockInDetailIds(stockInDetailIds));
    }
}
