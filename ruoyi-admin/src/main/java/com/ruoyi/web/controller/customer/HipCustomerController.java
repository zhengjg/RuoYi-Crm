package com.ruoyi.web.controller.customer;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.customer.domain.HipCustomer;
import com.ruoyi.customer.service.IHipCustomerService;
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

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新建客户Controller
 *
 * @author kevin
 * @date 2023-07-24
 */
@RestController
@RequestMapping("/customer/customer")
public class HipCustomerController extends BaseController
{
    @Autowired
    private IHipCustomerService hipCustomerService;

    /**
     * 查询新建客户列表
     */
    @PreAuthorize("@ss.hasPermi('customer:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipCustomer hipCustomer)
    {
        startPage();
        List<HipCustomer> list = hipCustomerService.selectHipCustomerList(hipCustomer);
        return getDataTable(list);
    }

    /**
     * 导出新建客户列表
     */
    @PreAuthorize("@ss.hasPermi('customer:customer:export')")
    @Log(title = "新建客户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipCustomer hipCustomer)
    {
        List<HipCustomer> list = hipCustomerService.selectHipCustomerList(hipCustomer);
        ExcelUtil<HipCustomer> util = new ExcelUtil<HipCustomer>(HipCustomer.class);
        util.exportExcel(response, list, "新建客户数据");
    }

    /**
     * 获取新建客户详细信息
     */
    @PreAuthorize("@ss.hasPermi('customer:customer:query')")
    @GetMapping(value = "/{customerId}")
    public AjaxResult getInfo(@PathVariable("customerId") Integer customerId)
    {
        return success(hipCustomerService.selectHipCustomerByCustomerId(customerId));
    }

    /**
     * 新增新建客户
     */
    @PreAuthorize("@ss.hasPermi('customer:customer:add')")
    @Log(title = "新建客户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipCustomer hipCustomer)
    {
        return toAjax(hipCustomerService.insertHipCustomer(hipCustomer));
    }

    /**
     * 修改新建客户
     */
    @PreAuthorize("@ss.hasPermi('customer:customer:edit')")
    @Log(title = "新建客户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipCustomer hipCustomer)
    {
        return toAjax(hipCustomerService.updateHipCustomer(hipCustomer));
    }

    /**
     * 删除新建客户
     */
    @PreAuthorize("@ss.hasPermi('customer:customer:remove')")
    @Log(title = "新建客户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{customerIds}")
    public AjaxResult remove(@PathVariable Integer[] customerIds)
    {
        return toAjax(hipCustomerService.deleteHipCustomerByCustomerIds(customerIds));
    }
}
