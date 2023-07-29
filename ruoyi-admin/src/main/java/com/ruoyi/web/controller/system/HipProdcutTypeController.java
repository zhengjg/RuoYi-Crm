package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.domain.HipProdcutType;
import com.ruoyi.system.service.IHipProdcutTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 产品类别Controller
 *
 * @author kevin
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/system/productType")
public class HipProdcutTypeController extends BaseController
{
    @Autowired
    private IHipProdcutTypeService hipProdcutTypeService;

    /**
     * 查询产品类别列表
     */
    @PreAuthorize("@ss.hasPermi('system:productType:list')")
    @GetMapping("/list")
    public AjaxResult list(HipProdcutType hipProdcutType)
    {
        List<HipProdcutType> list = hipProdcutTypeService.selectHipProdcutTypeList(hipProdcutType);
        return success(list);
    }

    /**
     * 导出产品类别列表
     */
    @PreAuthorize("@ss.hasPermi('system:productType:export')")
    @Log(title = "产品类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipProdcutType hipProdcutType)
    {
        List<HipProdcutType> list = hipProdcutTypeService.selectHipProdcutTypeList(hipProdcutType);
        ExcelUtil<HipProdcutType> util = new ExcelUtil<HipProdcutType>(HipProdcutType.class);
        util.exportExcel(response, list, "产品类别数据");
    }

    /**
     * 获取产品类别详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:productType:query')")
    @GetMapping(value = "/{typeId}")
    public AjaxResult getInfo(@PathVariable("typeId") Integer typeId)
    {
        return success(hipProdcutTypeService.selectHipProdcutTypeByTypeId(typeId));
    }

    /**
     * 新增产品类别
     */
    @PreAuthorize("@ss.hasPermi('system:productType:add')")
    @Log(title = "产品类别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipProdcutType hipProdcutType)
    {
        return toAjax(hipProdcutTypeService.insertHipProdcutType(hipProdcutType));
    }

    /**
     * 修改产品类别
     */
    @PreAuthorize("@ss.hasPermi('system:productType:edit')")
    @Log(title = "产品类别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipProdcutType hipProdcutType)
    {
        return toAjax(hipProdcutTypeService.updateHipProdcutType(hipProdcutType));
    }

    /**
     * 删除产品类别
     */
    @PreAuthorize("@ss.hasPermi('system:productType:remove')")
    @Log(title = "产品类别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{typeIds}")
    public AjaxResult remove(@PathVariable Integer[] typeIds)
    {
        return toAjax(hipProdcutTypeService.deleteHipProdcutTypeByTypeIds(typeIds));
    }
}
