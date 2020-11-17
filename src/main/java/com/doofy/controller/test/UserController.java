package com.doofy.controller.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.doofy.bean.TblUser;
import com.doofy.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Description:
 * @Author DooFy
 * @Date 2020/11/16
 * @Version
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理模块 ")
public class UserController {
	@Autowired
	UserService userService;

	@ApiOperation(value = "查询用户" ,notes="根据userId查询用户",tags = "用户接口")
	@ApiImplicitParam(paramType = "path",name = "id",value="用户ID",required = true,dataType = "Integer",defaultValue = "1")
	@ApiResponse(code = 400,message = "响应异常",response = java.lang.Exception.class)
	@GetMapping("/{id}")
	public String selectUser(@PathVariable("id") int id){
		TblUser user = userService.getUserById(id);
		return JSONObject.toJSONString(user, SerializerFeature.WriteNullStringAsEmpty);
	}
}
