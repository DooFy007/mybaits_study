package com.doofy;

import com.MybatisStudyApplication;
import com.doofy.bean.TblUser;
import com.doofy.mappers.TblUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisStudyApplication.class)
public class MybatisStudyApplicationTests {

	@Autowired
	TblUserMapper userMapper;

	@Test
	public void contextLoads() {
		TblUser tblUser = userMapper.selectByPrimaryKey(1);
		System.out.println(tblUser);
	}

}
