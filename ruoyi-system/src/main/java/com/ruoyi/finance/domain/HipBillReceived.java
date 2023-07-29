package com.ruoyi.finance.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售收款对象 hip_bill_received
 * 
 * @author ruoyi
 * @date 2023-07-25
 */
public class HipBillReceived extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收款记录ID */
    private Integer receivedId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String sysOrgCode;

    /** 收款单据 */
    @Excel(name = "收款单据")
    private String receivedNo;

    /** 收款金额 */
    @Excel(name = "收款金额")
    private Long receivedAmount;

    /** 收款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receivedDate;

    /** 是否开票 */
    @Excel(name = "是否开票")
    private String isInvoicing;

    /** 开票单据 */
    @Excel(name = "开票单据")
    private String invoicingNo;

    /** 经办人 */
    @Excel(name = "经办人")
    private String handleBy;

    /** 客户Id */
    private String customerId;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String customerName;

    public void setReceivedId(Integer receivedId) 
    {
        this.receivedId = receivedId;
    }

    public Integer getReceivedId() 
    {
        return receivedId;
    }
    public void setSysOrgCode(String sysOrgCode) 
    {
        this.sysOrgCode = sysOrgCode;
    }

    public String getSysOrgCode() 
    {
        return sysOrgCode;
    }
    public void setReceivedNo(String receivedNo) 
    {
        this.receivedNo = receivedNo;
    }

    public String getReceivedNo() 
    {
        return receivedNo;
    }
    public void setReceivedAmount(Long receivedAmount) 
    {
        this.receivedAmount = receivedAmount;
    }

    public Long getReceivedAmount() 
    {
        return receivedAmount;
    }
    public void setReceivedDate(Date receivedDate) 
    {
        this.receivedDate = receivedDate;
    }

    public Date getReceivedDate() 
    {
        return receivedDate;
    }
    public void setIsInvoicing(String isInvoicing) 
    {
        this.isInvoicing = isInvoicing;
    }

    public String getIsInvoicing() 
    {
        return isInvoicing;
    }
    public void setInvoicingNo(String invoicingNo) 
    {
        this.invoicingNo = invoicingNo;
    }

    public String getInvoicingNo() 
    {
        return invoicingNo;
    }
    public void setHandleBy(String handleBy) 
    {
        this.handleBy = handleBy;
    }

    public String getHandleBy() 
    {
        return handleBy;
    }
    public void setCustomerId(String customerId) 
    {
        this.customerId = customerId;
    }

    public String getCustomerId() 
    {
        return customerId;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("receivedId", getReceivedId())
            .append("createTime", getCreateTime())
            .append("sysOrgCode", getSysOrgCode())
            .append("receivedNo", getReceivedNo())
            .append("receivedAmount", getReceivedAmount())
            .append("receivedDate", getReceivedDate())
            .append("isInvoicing", getIsInvoicing())
            .append("invoicingNo", getInvoicingNo())
            .append("handleBy", getHandleBy())
            .append("customerId", getCustomerId())
            .append("customerName", getCustomerName())
            .toString();
    }
}
