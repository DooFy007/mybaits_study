package com.doofy.service;

import com.doofy.bean.TblUser;
import com.doofy.mappers.TblUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName
 * @Description:
 * @Author DooFy
 * @Date 2020/11/16
 * @Version
 **/
public interface UserService {
	TblUser getUserById(int id);
}
