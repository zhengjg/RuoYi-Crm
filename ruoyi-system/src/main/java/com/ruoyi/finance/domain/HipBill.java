package com.ruoyi.finance.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * finance对象 hip_bill
 *
 * @author kevin
 * @date 2023-07-24
 */
public class HipBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 账单ID */
    private Integer billId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String sysOrgCode;

    /** 应收 */
    @Excel(name = "应收")
    private Long receivable;

    /** 已收 */
    @Excel(name = "已收")
    private Long received;

    /** 结余 */
    @Excel(name = "结余")
    private Long remainder;

    /** 税点 */
    @Excel(name = "税点")
    private String taxPoint;

    /** 收款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiptDate;

    /** 是否开票 */
    @Excel(name = "是否开票")
    private String isInvoice;

    /** 开票日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开票日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invoiceDate;

    /** 应开票金额 */
    @Excel(name = "应开票金额")
    private Long invoiceAmount;

    /** 已开票金额 */
    @Excel(name = "已开票金额")
    private Long invoicedAmount;

    /** 未开票金额 */
    @Excel(name = "未开票金额")
    private Long uninvoicedAmount;

    /** 冲红 */
    @Excel(name = "冲红")
    private Long invoiceReversal;

    /** 经办人 */
    @Excel(name = "经办人")
    private String handledBy;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNo;

    /** 是否结清 */
    @Excel(name = "是否结清")
    private String isEnding;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 客户Id */
    @Excel(name = "客户Id")
    private String customerId;

    public void setBillId(Integer billId)
    {
        this.billId = billId;
    }

    public Integer getBillId()
    {
        return billId;
    }
    public void setSysOrgCode(String sysOrgCode)
    {
        this.sysOrgCode = sysOrgCode;
    }

    public String getSysOrgCode()
    {
        return sysOrgCode;
    }
    public void setReceivable(Long receivable)
    {
        this.receivable = receivable;
    }

    public Long getReceivable()
    {
        return receivable;
    }
    public void setReceived(Long received)
    {
        this.received = received;
    }

    public Long getReceived()
    {
        return received;
    }
    public void setRemainder(Long remainder)
    {
        this.remainder = remainder;
    }

    public Long getRemainder()
    {
        return remainder;
    }
    public void setTaxPoint(String taxPoint)
    {
        this.taxPoint = taxPoint;
    }

    public String getTaxPoint()
    {
        return taxPoint;
    }
    public void setReceiptDate(Date receiptDate)
    {
        this.receiptDate = receiptDate;
    }

    public Date getReceiptDate()
    {
        return receiptDate;
    }
    public void setIsInvoice(String isInvoice)
    {
        this.isInvoice = isInvoice;
    }

    public String getIsInvoice()
    {
        return isInvoice;
    }
    public void setInvoiceDate(Date invoiceDate)
    {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoiceDate()
    {
        return invoiceDate;
    }
    public void setInvoiceAmount(Long invoiceAmount)
    {
        this.invoiceAmount = invoiceAmount;
    }

    public Long getInvoiceAmount()
    {
        return invoiceAmount;
    }
    public void setInvoicedAmount(Long invoicedAmount)
    {
        this.invoicedAmount = invoicedAmount;
    }

    public Long getInvoicedAmount()
    {
        return invoicedAmount;
    }
    public void setUninvoicedAmount(Long uninvoicedAmount)
    {
        this.uninvoicedAmount = uninvoicedAmount;
    }

    public Long getUninvoicedAmount()
    {
        return uninvoicedAmount;
    }
    public void setInvoiceReversal(Long invoiceReversal)
    {
        this.invoiceReversal = invoiceReversal;
    }

    public Long getInvoiceReversal()
    {
        return invoiceReversal;
    }
    public void setHandledBy(String handledBy)
    {
        this.handledBy = handledBy;
    }

    public String getHandledBy()
    {
        return handledBy;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }
    public void setContractNo(String contractNo)
    {
        this.contractNo = contractNo;
    }

    public String getContractNo()
    {
        return contractNo;
    }
    public void setIsEnding(String isEnding)
    {
        this.isEnding = isEnding;
    }

    public String getIsEnding()
    {
        return isEnding;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerName()
    {
        return customerName;
    }
    public void setCustomerId(String customerId)
    {
        this.customerId = customerId;
    }

    public String getCustomerId()
    {
        return customerId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("billId", getBillId())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("sysOrgCode", getSysOrgCode())
            .append("receivable", getReceivable())
            .append("received", getReceived())
            .append("remainder", getRemainder())
            .append("taxPoint", getTaxPoint())
            .append("receiptDate", getReceiptDate())
            .append("isInvoice", getIsInvoice())
            .append("invoiceDate", getInvoiceDate())
            .append("invoiceAmount", getInvoiceAmount())
            .append("invoicedAmount", getInvoicedAmount())
            .append("uninvoicedAmount", getUninvoicedAmount())
            .append("invoiceReversal", getInvoiceReversal())
            .append("handledBy", getHandledBy())
            .append("remarks", getRemarks())
            .append("contractNo", getContractNo())
            .append("isEnding", getIsEnding())
            .append("customerName", getCustomerName())
            .append("customerId", getCustomerId())
            .toString();
    }
}
