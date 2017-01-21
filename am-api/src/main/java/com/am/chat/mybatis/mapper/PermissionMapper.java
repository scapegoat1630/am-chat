package com.am.chat.mybatis.mapper;

import com.am.chat.model.Permission;
import com.am.chat.model.PermissionExample;
import java.util.List;

public interface PermissionMapper {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective( Permission record,  PermissionExample example);

    int updateByExample( Permission record, PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 根据角色id查询角色所具有的权限
     * @param id
     * @return
     */
    List<Permission> getByRoleId(Integer id);
}