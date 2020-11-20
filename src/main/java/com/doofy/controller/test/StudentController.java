package com.doofy.controller.test;

import com.doofy.bean.TblStudent;
import com.doofy.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName
 * @Description:
 * @Author DooFy
 * @Date 2020/11/17
 * @Version
 **/
@Api(tags = "学生管理模块")
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @Autowired
    StudentService studentService;

    @ApiOperation(value = "学生查询",notes = "通过学生id查询学生")
    @ApiImplicitParam(name = "id",value = "学生id",required = true,defaultValue = "1" ,paramType = "path",dataType = "int")
    @GetMapping("/getStudentById/{id}")
    public TblStudent getStudentById(@PathVariable int id){
        log.info("学生查询");
        return studentService.getStudentById(id);
    }
}
