package com.ruoyi.customer.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.customer.domain.HipContacts;
import com.ruoyi.customer.mapper.HipContactsMapper;
import com.ruoyi.customer.service.IHipContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 联系人Service业务层处理
 *
 * @author kevin
 * @date 2023-07-24
 */
@Service
public class HipContactsServiceImpl implements IHipContactsService
{
    @Autowired
    private HipContactsMapper hipContactsMapper;

    /**
     * 查询联系人
     *
     * @param contactsId 联系人主键
     * @return 联系人
     */
    @Override
    public HipContacts selectHipContactsByContactsId(Integer contactsId)
    {
        return hipContactsMapper.selectHipContactsByContactsId(contactsId);
    }

    /**
     * 查询联系人列表
     *
     * @param hipContacts 联系人
     * @return 联系人
     */
    @Override
    public List<HipContacts> selectHipContactsList(HipContacts hipContacts)
    {
        return hipContactsMapper.selectHipContactsList(hipContacts);
    }

    /**
     * 新增联系人
     *
     * @param hipContacts 联系人
     * @return 结果
     */
    @Override
    public int insertHipContacts(HipContacts hipContacts)
    {
        hipContacts.setCreateTime(DateUtils.getNowDate());
        return hipContactsMapper.insertHipContacts(hipContacts);
    }

    /**
     * 修改联系人
     *
     * @param hipContacts 联系人
     * @return 结果
     */
    @Override
    public int updateHipContacts(HipContacts hipContacts)
    {
        hipContacts.setUpdateTime(DateUtils.getNowDate());
        return hipContactsMapper.updateHipContacts(hipContacts);
    }

    /**
     * 批量删除联系人
     *
     * @param contactsIds 需要删除的联系人主键
     * @return 结果
     */
    @Override
    public int deleteHipContactsByContactsIds(Integer[] contactsIds)
    {
        return hipContactsMapper.deleteHipContactsByContactsIds(contactsIds);
    }

    /**
     * 删除联系人信息
     *
     * @param contactsId 联系人主键
     * @return 结果
     */
    @Override
    public int deleteHipContactsByContactsId(Integer contactsId)
    {
        return hipContactsMapper.deleteHipContactsByContactsId(contactsId);
    }
}
