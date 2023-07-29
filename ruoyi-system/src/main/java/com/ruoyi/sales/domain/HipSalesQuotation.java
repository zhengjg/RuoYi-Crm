package com.ruoyi.sales.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售报价对象 hip_sales_quotation
 * 
 * @author kevin
 * @date 2023-07-25
 */
public class HipSalesQuotation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 销售ID */
    private Integer quotationId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String sysOrgCode;

    /** 报价单号 */
    @Excel(name = "报价单号")
    private String quotationNo;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 报价日期 */
    @Excel(name = "报价日期")
    private String quotationDate;

    /** 有效日期 */
    @Excel(name = "有效日期")
    private String validDate;

    /** 是否可用 */
    @Excel(name = "是否可用")
    private String isEnable;

    /** 税率 */
    @Excel(name = "税率")
    private String taxRate;

    /** 客户Id */
    @Excel(name = "客户Id")
    private String customerId;

    /** 销售代表 */
    @Excel(name = "销售代表")
    private String saleMan;

    /** 报价方案 */
    @Excel(name = "报价方案")
    private String quotationSolution;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 销售报价产品信息 */
    private List<HipSalesQuotationDetail> hipSalesQuotationDetailList;

    public void setQuotationId(Integer quotationId) 
    {
        this.quotationId = quotationId;
    }

    public Integer getQuotationId() 
    {
        return quotationId;
    }
    public void setSysOrgCode(String sysOrgCode) 
    {
        this.sysOrgCode = sysOrgCode;
    }

    public String getSysOrgCode() 
    {
        return sysOrgCode;
    }
    public void setQuotationNo(String quotationNo) 
    {
        this.quotationNo = quotationNo;
    }

    public String getQuotationNo() 
    {
        return quotationNo;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setQuotationDate(String quotationDate) 
    {
        this.quotationDate = quotationDate;
    }

    public String getQuotationDate() 
    {
        return quotationDate;
    }
    public void setValidDate(String validDate) 
    {
        this.validDate = validDate;
    }

    public String getValidDate() 
    {
        return validDate;
    }
    public void setIsEnable(String isEnable) 
    {
        this.isEnable = isEnable;
    }

    public String getIsEnable() 
    {
        return isEnable;
    }
    public void setTaxRate(String taxRate) 
    {
        this.taxRate = taxRate;
    }

    public String getTaxRate() 
    {
        return taxRate;
    }
    public void setCustomerId(String customerId) 
    {
        this.customerId = customerId;
    }

    public String getCustomerId() 
    {
        return customerId;
    }
    public void setSaleMan(String saleMan) 
    {
        this.saleMan = saleMan;
    }

    public String getSaleMan() 
    {
        return saleMan;
    }
    public void setQuotationSolution(String quotationSolution) 
    {
        this.quotationSolution = quotationSolution;
    }

    public String getQuotationSolution() 
    {
        return quotationSolution;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }

    public List<HipSalesQuotationDetail> getHipSalesQuotationDetailList()
    {
        return hipSalesQuotationDetailList;
    }

    public void setHipSalesQuotationDetailList(List<HipSalesQuotationDetail> hipSalesQuotationDetailList)
    {
        this.hipSalesQuotationDetailList = hipSalesQuotationDetailList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("quotationId", getQuotationId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("sysOrgCode", getSysOrgCode())
            .append("quotationNo", getQuotationNo())
            .append("projectName", getProjectName())
            .append("quotationDate", getQuotationDate())
            .append("validDate", getValidDate())
            .append("isEnable", getIsEnable())
            .append("taxRate", getTaxRate())
            .append("customerId", getCustomerId())
            .append("saleMan", getSaleMan())
            .append("quotationSolution", getQuotationSolution())
            .append("remarks", getRemarks())
            .append("customerName", getCustomerName())
            .append("hipSalesQuotationDetailList", getHipSalesQuotationDetailList())
            .toString();
    }
}
