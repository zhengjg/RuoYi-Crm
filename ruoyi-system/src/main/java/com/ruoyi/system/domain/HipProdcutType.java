package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 产品类别对象 hip_prodcut_type
 * 
 * @author kevin
 * @date 2023-07-28
 */
public class HipProdcutType extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品类别ID */
    private Integer typeId;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String name;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 图片 */
    @Excel(name = "图片")
    private String pics;

    /** 父级节点 */
    @Excel(name = "父级节点")
    private String pid;

    /** 是否有子节点 */
    @Excel(name = "是否有子节点")
    private String hasChild;

    public void setTypeId(Integer typeId) 
    {
        this.typeId = typeId;
    }

    public Integer getTypeId() 
    {
        return typeId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setPics(String pics) 
    {
        this.pics = pics;
    }

    public String getPics() 
    {
        return pics;
    }
    public void setPid(String pid) 
    {
        this.pid = pid;
    }

    public String getPid() 
    {
        return pid;
    }
    public void setHasChild(String hasChild) 
    {
        this.hasChild = hasChild;
    }

    public String getHasChild() 
    {
        return hasChild;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("typeId", getTypeId())
            .append("name", getName())
            .append("content", getContent())
            .append("pics", getPics())
            .append("pid", getPid())
            .append("hasChild", getHasChild())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
