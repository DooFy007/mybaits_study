package com.doofy.mappers;

import com.doofy.bean.TblTeacher;

/**
 * @ClassName ${ClassName}
 * @Description: ${Description}
 * @Author DooFy
 * @Date 2020/11/17
 * @Version ${Version}
 **/
public interface TblTeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblTeacher record);

    int insertSelective(TblTeacher record);

    TblTeacher selectById(Integer id);

    int updateByPrimaryKeySelective(TblTeacher record);

    int updateByPrimaryKey(TblTeacher record);
}