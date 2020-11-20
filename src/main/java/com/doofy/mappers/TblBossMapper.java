package com.doofy.mappers;

import com.doofy.bean.TblBoss;

public interface TblBossMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblBoss record);

    int insertSelective(TblBoss record);

    TblBoss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblBoss record);

    int updateByPrimaryKey(TblBoss record);
}