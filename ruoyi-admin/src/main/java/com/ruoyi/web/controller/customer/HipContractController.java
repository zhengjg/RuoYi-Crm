package com.ruoyi.web.controller.customer;

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
import com.ruoyi.customer.domain.HipContract;
import com.ruoyi.customer.service.IHipContractService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同Controller
 *
 * @author kevin
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/customer/contract")
public class HipContractController extends BaseController
{
    @Autowired
    private IHipContractService hipContractService;



    /**
     * 合同已同意，生成待出库
     */
    @GetMapping("/getOrderByCustomerId")
    public TableDataInfo getOrderByCustomerId(String customerId)
    {
        startPage();
        List<HipContract> list = hipContractService.getOrderByCustomerId(customerId);
        return getDataTable(list);
    }


    /**
     * 查询合同列表
     */
    @PreAuthorize("@ss.hasPermi('customer:contract:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipContract hipContract)
    {
        startPage();
        List<HipContract> list = hipContractService.selectHipContractList(hipContract);
        return getDataTable(list);
    }

    /**
     * 导出合同列表
     */
    @PreAuthorize("@ss.hasPermi('customer:contract:export')")
    @Log(title = "合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipContract hipContract)
    {
        List<HipContract> list = hipContractService.selectHipContractList(hipContract);
        ExcelUtil<HipContract> util = new ExcelUtil<HipContract>(HipContract.class);
        util.exportExcel(response, list, "合同数据");
    }

    /**
     * 获取合同详细信息
     */
    @PreAuthorize("@ss.hasPermi('customer:contract:query')")
    @GetMapping(value = "/{contractId}")
    public AjaxResult getInfo(@PathVariable("contractId") Integer contractId)
    {
        return success(hipContractService.selectHipContractByContractId(contractId));
    }

    /**
     * 新增合同
     */
    @PreAuthorize("@ss.hasPermi('customer:contract:add')")
    @Log(title = "合同", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipContract hipContract)
    {
        return toAjax(hipContractService.insertHipContract(hipContract));
    }

    /**
     * 修改合同
     */
    @PreAuthorize("@ss.hasPermi('customer:contract:edit')")
    @Log(title = "合同", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipContract hipContract)
    {
        return toAjax(hipContractService.updateHipContract(hipContract));
    }

    /**
     * 删除合同
     */
    @PreAuthorize("@ss.hasPermi('customer:contract:remove')")
    @Log(title = "合同", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contractIds}")
    public AjaxResult remove(@PathVariable Integer[] contractIds)
    {
        return toAjax(hipContractService.deleteHipContractByContractIds(contractIds));
    }
}
