package com.wjj.dao;

import com.wjj.model.Storage;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    int deduct(@Param("commodityCode") String commodityCode, @Param("count") int count);
}