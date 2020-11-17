package com.doofy.service.impl;

import com.doofy.bean.TblTeacher;
import com.doofy.mappers.TblTeacherMapper;
import com.doofy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName
 * @Description:
 * @Author DooFy
 * @Date 2020/11/17
 * @Version
 **/
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TblTeacherMapper teacherMapper;

    @Override
    public TblTeacher getTeacherById(int id) {
        return teacherMapper.selectById(id);
    }
}
