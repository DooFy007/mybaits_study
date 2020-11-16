package com.doofy.mappers;

import com.doofy.bean.TblUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ${ClassName}
 * @Description: ${Description}
 * @Author DooFy
 * @Date 2020/11/16
 * @Version ${Version}
 **/
public interface TblUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblUser record);

    int insertSelective(TblUser record);

    TblUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblUser record);

    int updateByPrimaryKey(TblUser record);
}