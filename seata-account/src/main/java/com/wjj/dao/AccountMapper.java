package com.wjj.dao;

import com.wjj.model.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    int debit(@Param("userId") String userId, @Param("money") int money);
}