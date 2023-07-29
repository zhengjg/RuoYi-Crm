package com.ruoyi.customer.service;

import com.ruoyi.customer.domain.HipContacts;

import java.util.List;


/**
 * 联系人Service接口
 *
 * @author kevin
 * @date 2023-07-24
 */
public interface IHipContactsService
{
    /**
     * 查询联系人
     *
     * @param contactsId 联系人主键
     * @return 联系人
     */
    public HipContacts selectHipContactsByContactsId(Integer contactsId);

    /**
     * 查询联系人列表
     *
     * @param hipContacts 联系人
     * @return 联系人集合
     */
    public List<HipContacts> selectHipContactsList(HipContacts hipContacts);

    /**
     * 新增联系人
     *
     * @param hipContacts 联系人
     * @return 结果
     */
    public int insertHipContacts(HipContacts hipContacts);

    /**
     * 修改联系人
     *
     * @param hipContacts 联系人
     * @return 结果
     */
    public int updateHipContacts(HipContacts hipContacts);

    /**
     * 批量删除联系人
     *
     * @param contactsIds 需要删除的联系人主键集合
     * @return 结果
     */
    public int deleteHipContactsByContactsIds(Integer[] contactsIds);

    /**
     * 删除联系人信息
     *
     * @param contactsId 联系人主键
     * @return 结果
     */
    public int deleteHipContactsByContactsId(Integer contactsId);
}
