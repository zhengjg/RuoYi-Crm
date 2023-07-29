package com.ruoyi.sales.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售报价产品对象 hip_sales_quotation_detail
 *
 * @author kevin
 * @date 2023-07-25
 */
public class HipSalesQuotationDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 销售报价产品ID */
    private Integer quotationDetailId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String sysOrgCode;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String prodctName;

    /** 型号 */
    @Excel(name = "型号")
    private String model;

    /** 封装形式 */
    @Excel(name = "封装形式")
    private String packageType;

    /** 类别 */
    @Excel(name = "类别")
    private String category;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 单价 */
    @Excel(name = "单价")
    private Long unitPrice;

    /** 数量 */
    @Excel(name = "数量")
    private Long quantity;

    /** 金额 */
    @Excel(name = "金额")
    private Long amountMoney;

    /** 说明 */
    @Excel(name = "说明")
    private String introduction;

    /** 销售报价Id */
    @Excel(name = "销售报价Id")
    private Integer quotationId;

    public void setQuotationDetailId(Integer quotationDetailId)
    {
        this.quotationDetailId = quotationDetailId;
    }

    public Integer getQuotationDetailId()
    {
        return quotationDetailId;
    }
    public void setSysOrgCode(String sysOrgCode)
    {
        this.sysOrgCode = sysOrgCode;
    }

    public String getSysOrgCode()
    {
        return sysOrgCode;
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
    public void setPackageType(String packageType)
    {
        this.packageType = packageType;
    }

    public String getPackageType()
    {
        return packageType;
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
    public void setUnitPrice(Long unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public Long getUnitPrice()
    {
        return unitPrice;
    }
    public void setQuantity(Long quantity)
    {
        this.quantity = quantity;
    }

    public Long getQuantity()
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
    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public String getIntroduction()
    {
        return introduction;
    }
    public void setQuotationId(Integer quotationId)
    {
        this.quotationId = quotationId;
    }

    public Integer getQuotationId()
    {
        return quotationId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("quotationDetailId", getQuotationDetailId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("sysOrgCode", getSysOrgCode())
            .append("prodctName", getProdctName())
            .append("model", getModel())
            .append("packageType", getPackageType())
            .append("category", getCategory())
            .append("brand", getBrand())
            .append("unitPrice", getUnitPrice())
            .append("quantity", getQuantity())
            .append("amountMoney", getAmountMoney())
            .append("introduction", getIntroduction())
            .append("quotationId", getQuotationId())
            .toString();
    }
}
