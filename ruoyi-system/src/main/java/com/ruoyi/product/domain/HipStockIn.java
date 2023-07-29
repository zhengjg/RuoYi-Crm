package com.ruoyi.product.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品入库对象 hip_stock_in
 *
 * @author kevin
 * @date 2023-07-24
 */
public class HipStockIn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库ID */
    private Integer stockInId;

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

    /** 说明 */
    @Excel(name = "说明")
    private String specification;

    /** 数量 */
    @Excel(name = "数量")
    private String quantity;

    /** 仓库 */
    @Excel(name = "仓库")
    private String warehouse;

    public void setStockInId(Integer stockInId)
    {
        this.stockInId = stockInId;
    }

    public Integer getStockInId()
    {
        return stockInId;
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
    public void setSpecification(String specification)
    {
        this.specification = specification;
    }

    public String getSpecification()
    {
        return specification;
    }
    public void setQuantity(String quantity)
    {
        this.quantity = quantity;
    }

    public String getQuantity()
    {
        return quantity;
    }
    public void setWarehouse(String warehouse)
    {
        this.warehouse = warehouse;
    }

    public String getWarehouse()
    {
        return warehouse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stockInId", getStockInId())
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
            .append("specification", getSpecification())
            .append("quantity", getQuantity())
            .append("warehouse", getWarehouse())
            .toString();
    }
}
