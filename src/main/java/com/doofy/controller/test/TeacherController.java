package com.doofy.controller.test;

import com.doofy.bean.TblTeacher;
import com.doofy.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Description:
 * @Author DooFy
 * @Date 2020/11/17
 * @Version
 **/
@Api(tags = "教师管理模块")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @ApiOperation(value = "教师查询",notes = "根据教师ID查询教师")
    @ApiImplicitParam(name = "id",value = "教师ID",required = true,paramType = "path",dataType = "int",defaultValue = "1")
    @ApiResponse(code = 500,message = "服务端响应异常")
    @GetMapping("/getTeacherById/{id}")
    public TblTeacher getTeacherById(@PathVariable("id") int id){
        return teacherService.getTeacherById(id);
    }
}
