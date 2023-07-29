package com.ruoyi.stock.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出库明细对象 hip_stock_out_detail
 * 
 * @author kevin
 * @date 2023-07-25
 */
public class HipStockOutDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出库明细ID */
    private Integer stockOutDetailId;

    /** 出库单据 */
    @Excel(name = "出库单据")
    private String billNo;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNo;

    /** 客户id */
    private String customerId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 出库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date whsOutDate;

    /** 经办人 */
    @Excel(name = "经办人")
    private String handleBy;

    /** 数量 */
    @Excel(name = "数量")
    private Integer amounts;

    /** 金额 */
    @Excel(name = "金额")
    private Long price;

    public void setStockOutDetailId(Integer stockOutDetailId) 
    {
        this.stockOutDetailId = stockOutDetailId;
    }

    public Integer getStockOutDetailId() 
    {
        return stockOutDetailId;
    }
    public void setBillNo(String billNo) 
    {
        this.billNo = billNo;
    }

    public String getBillNo() 
    {
        return billNo;
    }
    public void setContractNo(String contractNo) 
    {
        this.contractNo = contractNo;
    }

    public String getContractNo() 
    {
        return contractNo;
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
    public void setWhsOutDate(Date whsOutDate) 
    {
        this.whsOutDate = whsOutDate;
    }

    public Date getWhsOutDate() 
    {
        return whsOutDate;
    }
    public void setHandleBy(String handleBy) 
    {
        this.handleBy = handleBy;
    }

    public String getHandleBy() 
    {
        return handleBy;
    }
    public void setAmounts(Integer amounts) 
    {
        this.amounts = amounts;
    }

    public Integer getAmounts() 
    {
        return amounts;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stockOutDetailId", getStockOutDetailId())
            .append("billNo", getBillNo())
            .append("contractNo", getContractNo())
            .append("customerId", getCustomerId())
            .append("customerName", getCustomerName())
            .append("whsOutDate", getWhsOutDate())
            .append("handleBy", getHandleBy())
            .append("amounts", getAmounts())
            .append("price", getPrice())
            .toString();
    }
}
