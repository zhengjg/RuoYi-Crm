package com.ruoyi.product.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品出库对象 hip_stock_out
 *
 * @author kevin
 * @date 2023-07-24
 */
public class HipStockOut extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出库Id */
    private Integer stockOutId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String sysOrgCode;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String productNo;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String name;

    /** 型号 */
    @Excel(name = "型号")
    private String model;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 产品分类 */
    @Excel(name = "产品分类")
    private String productCategory;

    /** 产品属性 */
    @Excel(name = "产品属性")
    private String productAttribute;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 数量 */
    @Excel(name = "数量")
    private String quantity;

    /** 说明 */
    @Excel(name = "说明")
    private String specification;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNo;

    /** 仓库 */
    @Excel(name = "仓库")
    private String warehouse;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 客户Id */
    @Excel(name = "客户Id")
    private String customerId;

    public void setStockOutId(Integer stockOutId)
    {
        this.stockOutId = stockOutId;
    }

    public Integer getStockOutId()
    {
        return stockOutId;
    }
    public void setSysOrgCode(String sysOrgCode)
    {
        this.sysOrgCode = sysOrgCode;
    }

    public String getSysOrgCode()
    {
        return sysOrgCode;
    }
    public void setProductNo(String productNo)
    {
        this.productNo = productNo;
    }

    public String getProductNo()
    {
        return productNo;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setModel(String model)
    {
        this.model = model;
    }

    public String getModel()
    {
        return model;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }
    public void setProductCategory(String productCategory)
    {
        this.productCategory = productCategory;
    }

    public String getProductCategory()
    {
        return productCategory;
    }
    public void setProductAttribute(String productAttribute)
    {
        this.productAttribute = productAttribute;
    }

    public String getProductAttribute()
    {
        return productAttribute;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setQuantity(String quantity)
    {
        this.quantity = quantity;
    }

    public String getQuantity()
    {
        return quantity;
    }
    public void setSpecification(String specification)
    {
        this.specification = specification;
    }

    public String getSpecification()
    {
        return specification;
    }
    public void setContractNo(String contractNo)
    {
        this.contractNo = contractNo;
    }

    public String getContractNo()
    {
        return contractNo;
    }
    public void setWarehouse(String warehouse)
    {
        this.warehouse = warehouse;
    }

    public String getWarehouse()
    {
        return warehouse;
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
            .append("stockOutId", getStockOutId())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("sysOrgCode", getSysOrgCode())
            .append("productNo", getProductNo())
            .append("name", getName())
            .append("model", getModel())
            .append("unit", getUnit())
            .append("productCategory", getProductCategory())
            .append("productAttribute", getProductAttribute())
            .append("brand", getBrand())
            .append("quantity", getQuantity())
            .append("specification", getSpecification())
            .append("contractNo", getContractNo())
            .append("warehouse", getWarehouse())
            .append("customerName", getCustomerName())
            .append("customerId", getCustomerId())
            .toString();
    }
}
