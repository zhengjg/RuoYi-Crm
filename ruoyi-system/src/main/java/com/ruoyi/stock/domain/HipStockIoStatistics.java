package com.ruoyi.stock.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出入库汇总对象 hip_stock_io_statistics
 * 
 * @author kevin
 * @date 2023-07-25
 */
public class HipStockIoStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出入库ID */
    private Integer ioStatisticsId;

    /** 年 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "年", width = 30, dateFormat = "yyyy-MM-dd")
    private Date year;

    /** 月 */
    @Excel(name = "月")
    private Integer month;

    /** 仓库 */
    @Excel(name = "仓库")
    private String warehouse;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Integer stockInNum;

    /** 出库数量 */
    @Excel(name = "出库数量")
    private Integer stockOutNum;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Integer stockAmount;

    /** 入库金额 */
    @Excel(name = "入库金额")
    private Long stockInPrice;

    /** 出库金额 */
    @Excel(name = "出库金额")
    private Long stockOutPrice;

    /** 结余金额 */
    @Excel(name = "结余金额")
    private Long stockPrice;

    public void setIoStatisticsId(Integer ioStatisticsId) 
    {
        this.ioStatisticsId = ioStatisticsId;
    }

    public Integer getIoStatisticsId() 
    {
        return ioStatisticsId;
    }
    public void setYear(Date year) 
    {
        this.year = year;
    }

    public Date getYear() 
    {
        return year;
    }
    public void setMonth(Integer month) 
    {
        this.month = month;
    }

    public Integer getMonth() 
    {
        return month;
    }
    public void setWarehouse(String warehouse) 
    {
        this.warehouse = warehouse;
    }

    public String getWarehouse() 
    {
        return warehouse;
    }
    public void setStockInNum(Integer stockInNum) 
    {
        this.stockInNum = stockInNum;
    }

    public Integer getStockInNum() 
    {
        return stockInNum;
    }
    public void setStockOutNum(Integer stockOutNum) 
    {
        this.stockOutNum = stockOutNum;
    }

    public Integer getStockOutNum() 
    {
        return stockOutNum;
    }
    public void setStockAmount(Integer stockAmount) 
    {
        this.stockAmount = stockAmount;
    }

    public Integer getStockAmount() 
    {
        return stockAmount;
    }
    public void setStockInPrice(Long stockInPrice) 
    {
        this.stockInPrice = stockInPrice;
    }

    public Long getStockInPrice() 
    {
        return stockInPrice;
    }
    public void setStockOutPrice(Long stockOutPrice) 
    {
        this.stockOutPrice = stockOutPrice;
    }

    public Long getStockOutPrice() 
    {
        return stockOutPrice;
    }
    public void setStockPrice(Long stockPrice) 
    {
        this.stockPrice = stockPrice;
    }

    public Long getStockPrice() 
    {
        return stockPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ioStatisticsId", getIoStatisticsId())
            .append("year", getYear())
            .append("month", getMonth())
            .append("warehouse", getWarehouse())
            .append("stockInNum", getStockInNum())
            .append("stockOutNum", getStockOutNum())
            .append("stockAmount", getStockAmount())
            .append("stockInPrice", getStockInPrice())
            .append("stockOutPrice", getStockOutPrice())
            .append("stockPrice", getStockPrice())
            .toString();
    }
}
