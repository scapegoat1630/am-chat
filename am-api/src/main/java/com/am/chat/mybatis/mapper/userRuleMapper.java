package com.am.chat.mybatis.mapper;

import com.am.chat.model.userRule;
import com.am.chat.model.userRuleExample;
import java.util.List;

public interface userRuleMapper {
    int countByExample(userRuleExample example);

    int deleteByExample(userRuleExample example);

    int insert(userRule record);

    int insertSelective(userRule record);

    List<userRule> selectByExample(userRuleExample example);

    int updateByExampleSelective( userRule record, userRuleExample example);

    int updateByExample( userRule record, userRuleExample example);
}