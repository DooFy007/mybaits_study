package com.doofy.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.doofy.bean.TblUser;
import com.doofy.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping("/{id}")
	public String selectUser(@PathVariable int id){
		log.info("");
		TblUser user = userService.getUserById(id);
		return JSONObject.toJSONString(user, SerializerFeature.WriteNullStringAsEmpty);
	}
}
