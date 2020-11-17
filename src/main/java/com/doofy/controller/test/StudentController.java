package com.doofy.controller.test;

import com.doofy.bean.TblStudent;
import com.doofy.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Description:
 * @Author DooFy
 * @Date 2020/11/17
 * @Version
 **/
@Api(tags = "学生管理模块")
@RestController("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @ApiOperation(value = "学生查询",notes = "通过学生id查询学生")
    @ApiImplicitParam(name = "id",value = "学生id",required = true,defaultValue = "1" ,paramType = "path",dataType = "int")
    @ApiResponse(code = 200,message = "响应成功")
    @GetMapping("/getStudentById/{id}")
    public TblStudent getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
}
