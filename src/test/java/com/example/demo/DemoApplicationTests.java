package com.example.demo;

import com.delu.springboot.DemoApplication;
import com.delu.springboot.autochess.base.Constants;
import com.delu.springboot.autochess.tools.CommonUtils;
import com.delu.springboot.autochess.user.account.Account;
import com.delu.springboot.autochess.user.User;
import com.delu.springboot.autochess.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {

		String userId = Constants.USER_PREFIX + CommonUtils.createRamdonString(6);
//		String userId = "USER_L0rgxs";
		String salt = CommonUtils.createRamdonString(6);

		User user = new User();
		user.setUserId(userId);
		user.setNickName("delu");
		user.setHeadImg("http://www.google.com");

		Account account = new Account();
		account.setUserId(userId);
		account.setAccount("963517096@qq.com");
		account.setPassword(CommonUtils.md5("123456" + salt ));
		account.setSalt(salt);
		userService.createUser(user, account);
	}

	@Test
	public void test(){

		System.out.println("delu");
	}
}
