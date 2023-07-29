package com.ruoyi.customer.mapper;

import java.util.List;
import com.ruoyi.customer.domain.HipContacts;

/**
 * 联系人Mapper接口
 *
 * @author kevin
 * @date 2023-07-24
 */
public interface HipContactsMapper
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
     * 删除联系人
     *
     * @param contactsId 联系人主键
     * @return 结果
     */
    public int deleteHipContactsByContactsId(Integer contactsId);

    /**
     * 批量删除联系人
     *
     * @param contactsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHipContactsByContactsIds(Integer[] contactsIds);
}
