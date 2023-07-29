package com.ruoyi.customer.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 新建客户对象 hip_customer
 *
 * @author kevin
 * @date 2023-07-24
 */
public class HipCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户ID */
    private Integer customerId;

    /** 编码 */
    @Excel(name = "编码")
    private String code;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 简称 */
    @Excel(name = "简称")
    private String shortName;

    /** 助记名 */
    @Excel(name = "助记名")
    private String auxName;

    /** 客户分类 */
    @Excel(name = "客户分类")
    private String customerCategory;

    /** 客户等级 */
    @Excel(name = "客户等级")
    private String customerLevel;

    /** 纳税规模 */
    @Excel(name = "纳税规模")
    private String taxScale;

    /** 欠款额度 */
    @Excel(name = "欠款额度")
    private BigDecimal creditQuota;

    /** 所属总公司 */
    @Excel(name = "所属总公司")
    private String headquarters;

    /** 所属地区 */
    @Excel(name = "所属地区")
    private String area;

    /** 业务区域 */
    @Excel(name = "业务区域")
    private String bizArea;

    /** 客户地址 */
    @Excel(name = "客户地址")
    private String address;

    /** 客户网站 */
    @Excel(name = "客户网站")
    private String website;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String legalPerson;

    /** 法人电话 */
    @Excel(name = "法人电话")
    private String legalPersonPhone;

    /** 财务信息联系人 */
    @Excel(name = "财务信息联系人")
    private String financialContacts;

    /** 财务信息联系电话 */
    @Excel(name = "财务信息联系电话")
    private String financialPhone;

    /** 开票信息单位名称 */
    @Excel(name = "开票信息单位名称")
    private String invoiceCompany;

    /** 开票信息税号 */
    @Excel(name = "开票信息税号")
    private String invoiceTaxCode;

    /** 开票信息开户行 */
    @Excel(name = "开票信息开户行")
    private String invoiceBankName;

    /** 开票信息行号 */
    @Excel(name = "开票信息行号")
    private String invoiceBankCode;

    /** 开票信息账号 */
    @Excel(name = "开票信息账号")
    private String invoiceAccount;

    /** 开票信息联系电话 */
    @Excel(name = "开票信息联系电话")
    private String invoicePhone;

    /** 开票地址 */
    @Excel(name = "开票地址")
    private String invoiceAddress;

    /** 办款资料单位名称 */
    @Excel(name = "办款资料单位名称")
    private String paymentCompany;

    /** 办款资料开户行 */
    @Excel(name = "办款资料开户行")
    private String paymentBankName;

    /** 办款资料行号 */
    @Excel(name = "办款资料行号")
    private String paymentBankCode;

    /** 办款资料账号 */
    @Excel(name = "办款资料账号")
    private String paymentAccount;

    /** 收件信息收件人 */
    @Excel(name = "收件信息收件人")
    private String recvName;

    /** 收件信息联系电话 */
    @Excel(name = "收件信息联系电话")
    private String recvPhone;

    /** 收件信息传真 */
    @Excel(name = "收件信息传真")
    private String recvFax;

    /** 收件信息Email */
    @Excel(name = "收件信息Email")
    private String recvEmail;

    /** 收件信息地址 */
    @Excel(name = "收件信息地址")
    private String recvAddress;

    /** 收件信息邮编 */
    @Excel(name = "收件信息邮编")
    private String recvPostcode;

    /** 附件 */
    @Excel(name = "附件")
    private String attachment;

    /** 启用 */
    @Excel(name = "启用")
    private Integer isEnabled;

    /** 版本 */
    @Excel(name = "版本")
    private Long version;

    /** 业务员 */
    @Excel(name = "业务员")
    private String salesMan;

    public void setCustomerId(Integer customerId)
    {
        this.customerId = customerId;
    }

    public Integer getCustomerId()
    {
        return customerId;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public String getShortName()
    {
        return shortName;
    }
    public void setAuxName(String auxName)
    {
        this.auxName = auxName;
    }

    public String getAuxName()
    {
        return auxName;
    }
    public void setCustomerCategory(String customerCategory)
    {
        this.customerCategory = customerCategory;
    }

    public String getCustomerCategory()
    {
        return customerCategory;
    }
    public void setCustomerLevel(String customerLevel)
    {
        this.customerLevel = customerLevel;
    }

    public String getCustomerLevel()
    {
        return customerLevel;
    }
    public void setTaxScale(String taxScale)
    {
        this.taxScale = taxScale;
    }

    public String getTaxScale()
    {
        return taxScale;
    }
    public void setCreditQuota(BigDecimal creditQuota)
    {
        this.creditQuota = creditQuota;
    }

    public BigDecimal getCreditQuota()
    {
        return creditQuota;
    }
    public void setHeadquarters(String headquarters)
    {
        this.headquarters = headquarters;
    }

    public String getHeadquarters()
    {
        return headquarters;
    }
    public void setArea(String area)
    {
        this.area = area;
    }

    public String getArea()
    {
        return area;
    }
    public void setBizArea(String bizArea)
    {
        this.bizArea = bizArea;
    }

    public String getBizArea()
    {
        return bizArea;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setWebsite(String website)
    {
        this.website = website;
    }

    public String getWebsite()
    {
        return website;
    }
    public void setLegalPerson(String legalPerson)
    {
        this.legalPerson = legalPerson;
    }

    public String getLegalPerson()
    {
        return legalPerson;
    }
    public void setLegalPersonPhone(String legalPersonPhone)
    {
        this.legalPersonPhone = legalPersonPhone;
    }

    public String getLegalPersonPhone()
    {
        return legalPersonPhone;
    }
    public void setFinancialContacts(String financialContacts)
    {
        this.financialContacts = financialContacts;
    }

    public String getFinancialContacts()
    {
        return financialContacts;
    }
    public void setFinancialPhone(String financialPhone)
    {
        this.financialPhone = financialPhone;
    }

    public String getFinancialPhone()
    {
        return financialPhone;
    }
    public void setInvoiceCompany(String invoiceCompany)
    {
        this.invoiceCompany = invoiceCompany;
    }

    public String getInvoiceCompany()
    {
        return invoiceCompany;
    }
    public void setInvoiceTaxCode(String invoiceTaxCode)
    {
        this.invoiceTaxCode = invoiceTaxCode;
    }

    public String getInvoiceTaxCode()
    {
        return invoiceTaxCode;
    }
    public void setInvoiceBankName(String invoiceBankName)
    {
        this.invoiceBankName = invoiceBankName;
    }

    public String getInvoiceBankName()
    {
        return invoiceBankName;
    }
    public void setInvoiceBankCode(String invoiceBankCode)
    {
        this.invoiceBankCode = invoiceBankCode;
    }

    public String getInvoiceBankCode()
    {
        return invoiceBankCode;
    }
    public void setInvoiceAccount(String invoiceAccount)
    {
        this.invoiceAccount = invoiceAccount;
    }

    public String getInvoiceAccount()
    {
        return invoiceAccount;
    }
    public void setInvoicePhone(String invoicePhone)
    {
        this.invoicePhone = invoicePhone;
    }

    public String getInvoicePhone()
    {
        return invoicePhone;
    }
    public void setInvoiceAddress(String invoiceAddress)
    {
        this.invoiceAddress = invoiceAddress;
    }

    public String getInvoiceAddress()
    {
        return invoiceAddress;
    }
    public void setPaymentCompany(String paymentCompany)
    {
        this.paymentCompany = paymentCompany;
    }

    public String getPaymentCompany()
    {
        return paymentCompany;
    }
    public void setPaymentBankName(String paymentBankName)
    {
        this.paymentBankName = paymentBankName;
    }

    public String getPaymentBankName()
    {
        return paymentBankName;
    }
    public void setPaymentBankCode(String paymentBankCode)
    {
        this.paymentBankCode = paymentBankCode;
    }

    public String getPaymentBankCode()
    {
        return paymentBankCode;
    }
    public void setPaymentAccount(String paymentAccount)
    {
        this.paymentAccount = paymentAccount;
    }

    public String getPaymentAccount()
    {
        return paymentAccount;
    }
    public void setRecvName(String recvName)
    {
        this.recvName = recvName;
    }

    public String getRecvName()
    {
        return recvName;
    }
    public void setRecvPhone(String recvPhone)
    {
        this.recvPhone = recvPhone;
    }

    public String getRecvPhone()
    {
        return recvPhone;
    }
    public void setRecvFax(String recvFax)
    {
        this.recvFax = recvFax;
    }

    public String getRecvFax()
    {
        return recvFax;
    }
    public void setRecvEmail(String recvEmail)
    {
        this.recvEmail = recvEmail;
    }

    public String getRecvEmail()
    {
        return recvEmail;
    }
    public void setRecvAddress(String recvAddress)
    {
        this.recvAddress = recvAddress;
    }

    public String getRecvAddress()
    {
        return recvAddress;
    }
    public void setRecvPostcode(String recvPostcode)
    {
        this.recvPostcode = recvPostcode;
    }

    public String getRecvPostcode()
    {
        return recvPostcode;
    }
    public void setAttachment(String attachment)
    {
        this.attachment = attachment;
    }

    public String getAttachment()
    {
        return attachment;
    }
    public void setIsEnabled(Integer isEnabled)
    {
        this.isEnabled = isEnabled;
    }

    public Integer getIsEnabled()
    {
        return isEnabled;
    }
    public void setVersion(Long version)
    {
        this.version = version;
    }

    public Long getVersion()
    {
        return version;
    }
    public void setSalesMan(String salesMan)
    {
        this.salesMan = salesMan;
    }

    public String getSalesMan()
    {
        return salesMan;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customerId", getCustomerId())
            .append("code", getCode())
            .append("name", getName())
            .append("shortName", getShortName())
            .append("auxName", getAuxName())
            .append("customerCategory", getCustomerCategory())
            .append("customerLevel", getCustomerLevel())
            .append("taxScale", getTaxScale())
            .append("creditQuota", getCreditQuota())
            .append("headquarters", getHeadquarters())
            .append("area", getArea())
            .append("bizArea", getBizArea())
            .append("address", getAddress())
            .append("website", getWebsite())
            .append("legalPerson", getLegalPerson())
            .append("legalPersonPhone", getLegalPersonPhone())
            .append("financialContacts", getFinancialContacts())
            .append("financialPhone", getFinancialPhone())
            .append("invoiceCompany", getInvoiceCompany())
            .append("invoiceTaxCode", getInvoiceTaxCode())
            .append("invoiceBankName", getInvoiceBankName())
            .append("invoiceBankCode", getInvoiceBankCode())
            .append("invoiceAccount", getInvoiceAccount())
            .append("invoicePhone", getInvoicePhone())
            .append("invoiceAddress", getInvoiceAddress())
            .append("paymentCompany", getPaymentCompany())
            .append("paymentBankName", getPaymentBankName())
            .append("paymentBankCode", getPaymentBankCode())
            .append("paymentAccount", getPaymentAccount())
            .append("recvName", getRecvName())
            .append("recvPhone", getRecvPhone())
            .append("recvFax", getRecvFax())
            .append("recvEmail", getRecvEmail())
            .append("recvAddress", getRecvAddress())
            .append("recvPostcode", getRecvPostcode())
            .append("attachment", getAttachment())
            .append("isEnabled", getIsEnabled())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .append("salesMan", getSalesMan())
            .toString();
    }
}
