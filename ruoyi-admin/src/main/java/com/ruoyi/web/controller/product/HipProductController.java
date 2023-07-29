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
import com.ruoyi.product.domain.HipProduct;
import com.ruoyi.product.service.IHipProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品维护Controller
 *
 * @author keivn
 * @date 2023-07-24
 */
@RestController
@RequestMapping("/product/product")
public class HipProductController extends BaseController
{
    @Autowired
    private IHipProductService hipProductService;

    /**
     * 查询产品维护列表
     */
    @PreAuthorize("@ss.hasPermi('product:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipProduct hipProduct)
    {
        startPage();
        List<HipProduct> list = hipProductService.selectHipProductList(hipProduct);
        return getDataTable(list);
    }

    /**
     * 导出产品维护列表
     */
    @PreAuthorize("@ss.hasPermi('product:product:export')")
    @Log(title = "产品维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipProduct hipProduct)
    {
        List<HipProduct> list = hipProductService.selectHipProductList(hipProduct);
        ExcelUtil<HipProduct> util = new ExcelUtil<HipProduct>(HipProduct.class);
        util.exportExcel(response, list, "产品维护数据");
    }

    /**
     * 获取产品维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Integer productId)
    {
        return success(hipProductService.selectHipProductByProductId(productId));
    }

    /**
     * 新增产品维护
     */
    @PreAuthorize("@ss.hasPermi('product:product:add')")
    @Log(title = "产品维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipProduct hipProduct)
    {
        return toAjax(hipProductService.insertHipProduct(hipProduct));
    }

    /**
     * 修改产品维护
     */
    @PreAuthorize("@ss.hasPermi('product:product:edit')")
    @Log(title = "产品维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipProduct hipProduct)
    {
        return toAjax(hipProductService.updateHipProduct(hipProduct));
    }

    /**
     * 删除产品维护
     */
    @PreAuthorize("@ss.hasPermi('product:product:remove')")
    @Log(title = "产品维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Integer[] productIds)
    {
        return toAjax(hipProductService.deleteHipProductByProductIds(productIds));
    }
}
