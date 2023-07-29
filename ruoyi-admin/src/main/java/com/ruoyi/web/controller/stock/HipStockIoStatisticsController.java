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
import com.ruoyi.stock.domain.HipStockIoStatistics;
import com.ruoyi.stock.service.IHipStockIoStatisticsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出入库汇总Controller
 *
 * @author kevin
 * @date 2023-07-25
 */
@RestController
@RequestMapping("/stock/statistics")
public class HipStockIoStatisticsController extends BaseController
{
    @Autowired
    private IHipStockIoStatisticsService hipStockIoStatisticsService;

    /**
     * 查询出入库汇总列表
     */
    @PreAuthorize("@ss.hasPermi('stock:statistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipStockIoStatistics hipStockIoStatistics)
    {
        startPage();
        List<HipStockIoStatistics> list = hipStockIoStatisticsService.selectHipStockIoStatisticsList(hipStockIoStatistics);
        return getDataTable(list);
    }

    /**
     * 导出出入库汇总列表
     */
    @PreAuthorize("@ss.hasPermi('stock:statistics:export')")
    @Log(title = "出入库汇总", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipStockIoStatistics hipStockIoStatistics)
    {
        List<HipStockIoStatistics> list = hipStockIoStatisticsService.selectHipStockIoStatisticsList(hipStockIoStatistics);
        ExcelUtil<HipStockIoStatistics> util = new ExcelUtil<HipStockIoStatistics>(HipStockIoStatistics.class);
        util.exportExcel(response, list, "出入库汇总数据");
    }

    /**
     * 获取出入库汇总详细信息
     */
    @PreAuthorize("@ss.hasPermi('stock:statistics:query')")
    @GetMapping(value = "/{ioStatisticsId}")
    public AjaxResult getInfo(@PathVariable("ioStatisticsId") Integer ioStatisticsId)
    {
        return success(hipStockIoStatisticsService.selectHipStockIoStatisticsByIoStatisticsId(ioStatisticsId));
    }

    /**
     * 新增出入库汇总
     */
    @PreAuthorize("@ss.hasPermi('stock:statistics:add')")
    @Log(title = "出入库汇总", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipStockIoStatistics hipStockIoStatistics)
    {
        return toAjax(hipStockIoStatisticsService.insertHipStockIoStatistics(hipStockIoStatistics));
    }

    /**
     * 修改出入库汇总
     */
    @PreAuthorize("@ss.hasPermi('stock:statistics:edit')")
    @Log(title = "出入库汇总", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipStockIoStatistics hipStockIoStatistics)
    {
        return toAjax(hipStockIoStatisticsService.updateHipStockIoStatistics(hipStockIoStatistics));
    }

    /**
     * 删除出入库汇总
     */
    @PreAuthorize("@ss.hasPermi('stock:statistics:remove')")
    @Log(title = "出入库汇总", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ioStatisticsIds}")
    public AjaxResult remove(@PathVariable Integer[] ioStatisticsIds)
    {
        return toAjax(hipStockIoStatisticsService.deleteHipStockIoStatisticsByIoStatisticsIds(ioStatisticsIds));
    }
}
