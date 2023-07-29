package com.ruoyi.customer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同订单对象 hip_contract_order
 *
 * @author kevin
 * @date 2023-07-29
 */
public class HipContractOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同订单ID */
    private Integer contractOrderId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String prodctName;

    /** 型号 */
    @Excel(name = "型号")
    private String model;

    /** 容量 */
    @Excel(name = "容量")
    private String capacity;

    /** 类别 */
    @Excel(name = "类别")
    private String category;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 状态 */
    private Integer status;

    /** 单价 */
    @Excel(name = "单价")
    private Long unitPrice;

    /** 数量 */
    @Excel(name = "数量")
    private Integer quantity;

    /** 金额 */
    @Excel(name = "金额")
    private Long amountMoney;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNo;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Integer productId;

    public void setContractOrderId(Integer contractOrderId)
    {
        this.contractOrderId = contractOrderId;
    }

    public Integer getContractOrderId()
    {
        return contractOrderId;
    }
    public void setProdctName(String prodctName)
    {
        this.prodctName = prodctName;
    }

    public String getProdctName()
    {
        return prodctName;
    }
    public void setModel(String model)
    {
        this.model = model;
    }

    public String getModel()
    {
        return model;
    }
    public void setCapacity(String capacity)
    {
        this.capacity = capacity;
    }

    public String getCapacity()
    {
        return capacity;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setUnitPrice(Long unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public Long getUnitPrice()
    {
        return unitPrice;
    }
    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Integer getQuantity()
    {
        return quantity;
    }
    public void setAmountMoney(Long amountMoney)
    {
        this.amountMoney = amountMoney;
    }

    public Long getAmountMoney()
    {
        return amountMoney;
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
    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public Integer getProductId()
    {
        return productId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("contractOrderId", getContractOrderId())
                .append("createTime", getCreateTime())
                .append("prodctName", getProdctName())
                .append("model", getModel())
                .append("capacity", getCapacity())
                .append("category", getCategory())
                .append("brand", getBrand())
                .append("status", getStatus())
                .append("unitPrice", getUnitPrice())
                .append("quantity", getQuantity())
                .append("amountMoney", getAmountMoney())
                .append("remarks", getRemarks())
                .append("contractNo", getContractNo())
                .append("productId", getProductId())
                .toString();
    }
}
