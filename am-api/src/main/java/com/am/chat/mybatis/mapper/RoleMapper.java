package com.am.chat.mybatis.mapper;

import com.am.chat.model.Role;
import com.am.chat.model.RoleExample;
import java.util.List;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective( Role record, RoleExample example);

    int updateByExample( Role record,  RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    List<Role> findByUserName(String name);
}