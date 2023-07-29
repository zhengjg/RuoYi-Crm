package com.ruoyi.customer.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同对象 hip_contract
 * 
 * @author kevin
 * @date 2023-07-28
 */
public class HipContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同Id */
    private Integer contractId;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNo;

    /** 签署地点 */
    @Excel(name = "签署地点")
    private String signAddress;

    /** 供方 */
    @Excel(name = "供方")
    private String supplier;

    /** 客户Id */
    @Excel(name = "客户Id")
    private String customerId;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String deliveryAddress;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 合同类型 */
    @Excel(name = "合同类型")
    private String contractType;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String settlementType;

    /** 税率 */
    @Excel(name = "税率")
    private String taxRate;

    /** 合同总价 */
    @Excel(name = "合同总价")
    private Long totalPrice;

    /** 流程号 */
    @Excel(name = "流程号")
    private Integer flowId;

    /** 当前节点 */
    @Excel(name = "当前节点")
    private Integer currentNode;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 合同信息 */
    private List<HipContractOrder> hipContractOrderList;

    public void setContractId(Integer contractId) 
    {
        this.contractId = contractId;
    }

    public Integer getContractId() 
    {
        return contractId;
    }
    public void setContractNo(String contractNo) 
    {
        this.contractNo = contractNo;
    }

    public String getContractNo() 
    {
        return contractNo;
    }
    public void setSignAddress(String signAddress) 
    {
        this.signAddress = signAddress;
    }

    public String getSignAddress() 
    {
        return signAddress;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }
    public void setCustomerId(String customerId) 
    {
        this.customerId = customerId;
    }

    public String getCustomerId() 
    {
        return customerId;
    }
    public void setDeliveryAddress(String deliveryAddress) 
    {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() 
    {
        return deliveryAddress;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setContractType(String contractType) 
    {
        this.contractType = contractType;
    }

    public String getContractType() 
    {
        return contractType;
    }
    public void setSettlementType(String settlementType) 
    {
        this.settlementType = settlementType;
    }

    public String getSettlementType() 
    {
        return settlementType;
    }
    public void setTaxRate(String taxRate) 
    {
        this.taxRate = taxRate;
    }

    public String getTaxRate() 
    {
        return taxRate;
    }
    public void setTotalPrice(Long totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public Long getTotalPrice() 
    {
        return totalPrice;
    }
    public void setFlowId(Integer flowId) 
    {
        this.flowId = flowId;
    }

    public Integer getFlowId() 
    {
        return flowId;
    }
    public void setCurrentNode(Integer currentNode) 
    {
        this.currentNode = currentNode;
    }

    public Integer getCurrentNode() 
    {
        return currentNode;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }

    public List<HipContractOrder> getHipContractOrderList()
    {
        return hipContractOrderList;
    }

    public void setHipContractOrderList(List<HipContractOrder> hipContractOrderList)
    {
        this.hipContractOrderList = hipContractOrderList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contractId", getContractId())
            .append("contractNo", getContractNo())
            .append("signAddress", getSignAddress())
            .append("supplier", getSupplier())
            .append("customerId", getCustomerId())
            .append("deliveryAddress", getDeliveryAddress())
            .append("status", getStatus())
            .append("contractType", getContractType())
            .append("settlementType", getSettlementType())
            .append("taxRate", getTaxRate())
            .append("totalPrice", getTotalPrice())
            .append("remark", getRemark())
            .append("flowId", getFlowId())
            .append("currentNode", getCurrentNode())
            .append("customerName", getCustomerName())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("hipContractOrderList", getHipContractOrderList())
            .toString();
    }
}
