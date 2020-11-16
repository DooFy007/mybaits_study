package com.doofy.service.impl;

import com.doofy.bean.TblUser;
import com.doofy.mappers.TblUserMapper;
import com.doofy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName
 * @Description:
 * @Author DooFy
 * @Date 2020/11/16
 * @Version
 **/
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	TblUserMapper userMapper;
	@Override
	public TblUser getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}
}
