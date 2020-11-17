package com.doofy.mappers;

import com.doofy.bean.TblStudent;

/**
 * @ClassName ${ClassName}
 * @Description: ${Description}
 * @Author DooFy
 * @Date 2020/11/17
 * @Version ${Version}
 **/
public interface TblStudentMapper {
    int deleteById(Integer id);
    int insert(TblStudent record);
    int insertSelective(TblStudent record);
    TblStudent selectById(Integer id);
    int updateByPrimaryKeySelective(TblStudent record);
    int updateByPrimaryKey(TblStudent record);
}