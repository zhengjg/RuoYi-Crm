package com.ruoyi.web.controller.customer;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.customer.domain.HipContacts;
import com.ruoyi.customer.service.IHipContactsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * 联系人Controller
 *
 * @author kevin
 * @date 2023-07-24
 */
@Api("联系人")
@RestController
@RequestMapping("/customer/contacts")
public class HipContactsController extends BaseController
{
    @Autowired
    private IHipContactsService hipContactsService;

    /**
     * 查询联系人列表
     */
    @ApiOperation("获取联系人列表")
    @PreAuthorize("@ss.hasPermi('customer:contacts:list')")
    @GetMapping("/list")
    public TableDataInfo list(HipContacts hipContacts)
    {
        startPage();
        List<HipContacts> list = hipContactsService.selectHipContactsList(hipContacts);
        return getDataTable(list);
    }

    /**
     * 导出联系人列表
     */
    @PreAuthorize("@ss.hasPermi('customer:contacts:export')")
    @Log(title = "联系人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HipContacts hipContacts)
    {
        List<HipContacts> list = hipContactsService.selectHipContactsList(hipContacts);
        ExcelUtil<HipContacts> util = new ExcelUtil<HipContacts>(HipContacts.class);
        util.exportExcel(response, list, "联系人数据");
    }

    /**
     * 获取联系人详细信息
     */
    @PreAuthorize("@ss.hasPermi('customer:contacts:query')")
    @GetMapping(value = "/{contactsId}")
    public AjaxResult getInfo(@PathVariable("contactsId") Integer contactsId)
    {
        return success(hipContactsService.selectHipContactsByContactsId(contactsId));
    }

    /**
     * 新增联系人
     */
    @PreAuthorize("@ss.hasPermi('customer:contacts:add')")
    @Log(title = "联系人", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HipContacts hipContacts)
    {
        return toAjax(hipContactsService.insertHipContacts(hipContacts));
    }

    /**
     * 修改联系人
     */
    @PreAuthorize("@ss.hasPermi('customer:contacts:edit')")
    @Log(title = "联系人", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HipContacts hipContacts)
    {
        return toAjax(hipContactsService.updateHipContacts(hipContacts));
    }

    /**
     * 删除联系人
     */
    @PreAuthorize("@ss.hasPermi('customer:contacts:remove')")
    @Log(title = "联系人", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contactsIds}")
    public AjaxResult remove(@PathVariable Integer[] contactsIds)
    {
        return toAjax(hipContactsService.deleteHipContactsByContactsIds(contactsIds));
    }
}
