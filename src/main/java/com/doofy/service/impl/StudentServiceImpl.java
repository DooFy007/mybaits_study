package com.doofy.service.impl;

import com.doofy.bean.TblStudent;
import com.doofy.mappers.TblStudentMapper;
import com.doofy.service.StudentService;
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
public class StudentServiceImpl implements StudentService {
    @Autowired
    TblStudentMapper studentMapper;
    @Override
    public TblStudent getStudentById(int id) {
        return studentMapper.selectById(id);
    }
}
