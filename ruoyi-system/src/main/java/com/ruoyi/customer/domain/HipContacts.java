package com.ruoyi.customer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 联系人对象 hip_contacts
 *
 * @author kevin
 * @date 2023-07-24
 */
public class HipContacts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 账单ID */
    private Integer contactsId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String sysOrgCode;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private String age;

    /** 手机 */
    @Excel(name = "手机")
    private String mobile;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 部门 */
    @Excel(name = "部门")
    private String department;

    /** 职位 */
    @Excel(name = "职位")
    private String position;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 客户Id */
    @Excel(name = "客户Id")
    private String customerId;

    /** 是否有效 */
    @Excel(name = "是否有效")
    private String isEnable;

    public void setContactsId(Integer contactsId)
    {
        this.contactsId = contactsId;
    }

    public Integer getContactsId()
    {
        return contactsId;
    }
    public void setSysOrgCode(String sysOrgCode)
    {
        this.sysOrgCode = sysOrgCode;
    }

    public String getSysOrgCode()
    {
        return sysOrgCode;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setAge(String age)
    {
        this.age = age;
    }

    public String getAge()
    {
        return age;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getMobile()
    {
        return mobile;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getDepartment()
    {
        return department;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getPosition()
    {
        return position;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setCustomerId(String customerId)
    {
        this.customerId = customerId;
    }

    public String getCustomerId()
    {
        return customerId;
    }
    public void setIsEnable(String isEnable)
    {
        this.isEnable = isEnable;
    }

    public String getIsEnable()
    {
        return isEnable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contactsId", getContactsId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("sysOrgCode", getSysOrgCode())
            .append("name", getName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("mobile", getMobile())
            .append("phone", getPhone())
            .append("department", getDepartment())
            .append("position", getPosition())
            .append("email", getEmail())
            .append("customerId", getCustomerId())
            .append("isEnable", getIsEnable())
            .toString();
    }
}
