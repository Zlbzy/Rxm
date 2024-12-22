package com.eddy.rxm;

import com.eddy.rxm.admin.entity.SysUser;
import com.eddy.rxm.admin.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class RxManagerApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	void contextLoads() {

	}

	@Test
	public void testUserMapper(){
		List<SysUser> userList = userMapper.selectList(null);
		System.out.println(userList);
	}

	@Test
	public void createPwd(){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encode = passwordEncoder.encode("123");
		System.out.println(encode);

	}

}
