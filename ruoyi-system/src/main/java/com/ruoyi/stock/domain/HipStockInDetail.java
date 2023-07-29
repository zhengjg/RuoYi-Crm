package com.ruoyi.stock.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 入库明细对象 hip_stock_in_detail
 * 
 * @author kevin
 * @date 2023-07-25
 */
public class HipStockInDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出库明细ID */
    private Integer stockInDetailId;

    /** 入库单据编号 */
    @Excel(name = "入库单据编号")
    private String billNo;

    /** 入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date whsInDate;

    /** 经办人 */
    @Excel(name = "经办人")
    private String handleBy;

    /** 数量 */
    @Excel(name = "数量")
    private Integer amounts;

    /** 金额 */
    @Excel(name = "金额")
    private Long price;

    public void setStockInDetailId(Integer stockInDetailId) 
    {
        this.stockInDetailId = stockInDetailId;
    }

    public Integer getStockInDetailId() 
    {
        return stockInDetailId;
    }
    public void setBillNo(String billNo) 
    {
        this.billNo = billNo;
    }

    public String getBillNo() 
    {
        return billNo;
    }
    public void setWhsInDate(Date whsInDate) 
    {
        this.whsInDate = whsInDate;
    }

    public Date getWhsInDate() 
    {
        return whsInDate;
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
            .append("stockInDetailId", getStockInDetailId())
            .append("billNo", getBillNo())
            .append("whsInDate", getWhsInDate())
            .append("handleBy", getHandleBy())
            .append("amounts", getAmounts())
            .append("price", getPrice())
            .toString();
    }
}
