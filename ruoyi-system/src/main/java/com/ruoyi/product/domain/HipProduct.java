package com.ruoyi.product.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品维护对象 hip_product
 * 
 * @author keivn
 * @date 2023-07-24
 */
public class HipProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品ID */
    private Integer productId;

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

    /** 单位组 */
    @Excel(name = "单位组")
    private String unitGroup;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 产品类别 */
    @Excel(name = "产品类别")
    private String productType;

    /** 产品属性 */
    @Excel(name = "产品属性")
    private String productProperty;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 产品说明 */
    @Excel(name = "产品说明")
    private String specification;

    /** 封装形式 */
    @Excel(name = "封装形式")
    private String packageType;

    /** 产品图片 */
    @Excel(name = "产品图片")
    private String img;

    /** 产地 */
    @Excel(name = "产地")
    private String placeOrigin;

    /** 参考价 */
    @Excel(name = "参考价")
    private Long referPrice;

    /** 最低价 */
    @Excel(name = "最低价")
    private Long lowPrice;

    /** 数量 */
    @Excel(name = "数量")
    private Integer quantity;

    public void setProductId(Integer productId) 
    {
        this.productId = productId;
    }

    public Integer getProductId() 
    {
        return productId;
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
    public void setUnitGroup(String unitGroup) 
    {
        this.unitGroup = unitGroup;
    }

    public String getUnitGroup() 
    {
        return unitGroup;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }
    public void setProductProperty(String productProperty) 
    {
        this.productProperty = productProperty;
    }

    public String getProductProperty() 
    {
        return productProperty;
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
    public void setPackageType(String packageType) 
    {
        this.packageType = packageType;
    }

    public String getPackageType() 
    {
        return packageType;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setPlaceOrigin(String placeOrigin) 
    {
        this.placeOrigin = placeOrigin;
    }

    public String getPlaceOrigin() 
    {
        return placeOrigin;
    }
    public void setReferPrice(Long referPrice) 
    {
        this.referPrice = referPrice;
    }

    public Long getReferPrice() 
    {
        return referPrice;
    }
    public void setLowPrice(Long lowPrice) 
    {
        this.lowPrice = lowPrice;
    }

    public Long getLowPrice() 
    {
        return lowPrice;
    }
    public void setQuantity(Integer quantity) 
    {
        this.quantity = quantity;
    }

    public Integer getQuantity() 
    {
        return quantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("sysOrgCode", getSysOrgCode())
            .append("productNo", getProductNo())
            .append("name", getName())
            .append("model", getModel())
            .append("unitGroup", getUnitGroup())
            .append("unit", getUnit())
            .append("productType", getProductType())
            .append("productProperty", getProductProperty())
            .append("brand", getBrand())
            .append("specification", getSpecification())
            .append("packageType", getPackageType())
            .append("img", getImg())
            .append("placeOrigin", getPlaceOrigin())
            .append("referPrice", getReferPrice())
            .append("lowPrice", getLowPrice())
            .append("quantity", getQuantity())
            .toString();
    }
}
