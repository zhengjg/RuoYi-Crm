package com.ruoyi.finance.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对账单对象 hip_sales
 *
 * @author kevin
 * @date 2023-07-24
 */
public class HipSales extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 销售ID */
    private Integer salesId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String sysOrgCode;

    /** 辅助发货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "辅助发货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date extDeliveryDate;

    /** 辅助收款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "辅助收款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date extPaymentDate;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNum;

    /** 处理日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handleDate;

    /** 交货地址 */
    @Excel(name = "交货地址")
    private String deliveryAddress;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 容量 */
    @Excel(name = "容量")
    private String capactiy;

    /** 数量 */
    @Excel(name = "数量")
    private Integer num;

    /** 是否含税 */
    @Excel(name = "是否含税")
    private String isTax;

    /** 单价 */
    @Excel(name = "单价")
    private Long price;

    /** 应收账款 */
    @Excel(name = "应收账款")
    private String receivable;

    /** 已收账款 */
    @Excel(name = "已收账款")
    private String received;

    /** 收款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receivedDate;

    /** 收款金额 */
    @Excel(name = "收款金额")
    private String receivedMoney;

    /** 应收帐款余额 */
    @Excel(name = "应收帐款余额")
    private String receivableRemainder;

    /** 是否开票 */
    @Excel(name = "是否开票")
    private String isInvoicing;

    /** 处理开票日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理开票日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invoicingDate;

    /** 已开票金额 */
    @Excel(name = "已开票金额")
    private String invoicedMoney;

    /** 应开票金额 */
    @Excel(name = "应开票金额")
    private String invoicingMoney;

    /** 未开票金额 */
    @Excel(name = "未开票金额")
    private String uninvoicedMoney;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 销售单号 */
    @Excel(name = "销售单号")
    private String saleNo;

    public void setSalesId(Integer salesId)
    {
        this.salesId = salesId;
    }

    public Integer getSalesId()
    {
        return salesId;
    }
    public void setSysOrgCode(String sysOrgCode)
    {
        this.sysOrgCode = sysOrgCode;
    }

    public String getSysOrgCode()
    {
        return sysOrgCode;
    }
    public void setExtDeliveryDate(Date extDeliveryDate)
    {
        this.extDeliveryDate = extDeliveryDate;
    }

    public Date getExtDeliveryDate()
    {
        return extDeliveryDate;
    }
    public void setExtPaymentDate(Date extPaymentDate)
    {
        this.extPaymentDate = extPaymentDate;
    }

    public Date getExtPaymentDate()
    {
        return extPaymentDate;
    }
    public void setContractNum(String contractNum)
    {
        this.contractNum = contractNum;
    }

    public String getContractNum()
    {
        return contractNum;
    }
    public void setHandleDate(Date handleDate)
    {
        this.handleDate = handleDate;
    }

    public Date getHandleDate()
    {
        return handleDate;
    }
    public void setDeliveryAddress(String deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setCapactiy(String capactiy)
    {
        this.capactiy = capactiy;
    }

    public String getCapactiy()
    {
        return capactiy;
    }
    public void setNum(Integer num)
    {
        this.num = num;
    }

    public Integer getNum()
    {
        return num;
    }
    public void setIsTax(String isTax)
    {
        this.isTax = isTax;
    }

    public String getIsTax()
    {
        return isTax;
    }
    public void setPrice(Long price)
    {
        this.price = price;
    }

    public Long getPrice()
    {
        return price;
    }
    public void setReceivable(String receivable)
    {
        this.receivable = receivable;
    }

    public String getReceivable()
    {
        return receivable;
    }
    public void setReceived(String received)
    {
        this.received = received;
    }

    public String getReceived()
    {
        return received;
    }
    public void setReceivedDate(Date receivedDate)
    {
        this.receivedDate = receivedDate;
    }

    public Date getReceivedDate()
    {
        return receivedDate;
    }
    public void setReceivedMoney(String receivedMoney)
    {
        this.receivedMoney = receivedMoney;
    }

    public String getReceivedMoney()
    {
        return receivedMoney;
    }
    public void setReceivableRemainder(String receivableRemainder)
    {
        this.receivableRemainder = receivableRemainder;
    }

    public String getReceivableRemainder()
    {
        return receivableRemainder;
    }
    public void setIsInvoicing(String isInvoicing)
    {
        this.isInvoicing = isInvoicing;
    }

    public String getIsInvoicing()
    {
        return isInvoicing;
    }
    public void setInvoicingDate(Date invoicingDate)
    {
        this.invoicingDate = invoicingDate;
    }

    public Date getInvoicingDate()
    {
        return invoicingDate;
    }
    public void setInvoicedMoney(String invoicedMoney)
    {
        this.invoicedMoney = invoicedMoney;
    }

    public String getInvoicedMoney()
    {
        return invoicedMoney;
    }
    public void setInvoicingMoney(String invoicingMoney)
    {
        this.invoicingMoney = invoicingMoney;
    }

    public String getInvoicingMoney()
    {
        return invoicingMoney;
    }
    public void setUninvoicedMoney(String uninvoicedMoney)
    {
        this.uninvoicedMoney = uninvoicedMoney;
    }

    public String getUninvoicedMoney()
    {
        return uninvoicedMoney;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }
    public void setSaleNo(String saleNo)
    {
        this.saleNo = saleNo;
    }

    public String getSaleNo()
    {
        return saleNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("salesId", getSalesId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("sysOrgCode", getSysOrgCode())
            .append("extDeliveryDate", getExtDeliveryDate())
            .append("extPaymentDate", getExtPaymentDate())
            .append("contractNum", getContractNum())
            .append("handleDate", getHandleDate())
            .append("deliveryAddress", getDeliveryAddress())
            .append("brand", getBrand())
            .append("capactiy", getCapactiy())
            .append("num", getNum())
            .append("isTax", getIsTax())
            .append("price", getPrice())
            .append("receivable", getReceivable())
            .append("received", getReceived())
            .append("receivedDate", getReceivedDate())
            .append("receivedMoney", getReceivedMoney())
            .append("receivableRemainder", getReceivableRemainder())
            .append("isInvoicing", getIsInvoicing())
            .append("invoicingDate", getInvoicingDate())
            .append("invoicedMoney", getInvoicedMoney())
            .append("invoicingMoney", getInvoicingMoney())
            .append("uninvoicedMoney", getUninvoicedMoney())
            .append("remarks", getRemarks())
            .append("saleNo", getSaleNo())
            .toString();
    }
}
