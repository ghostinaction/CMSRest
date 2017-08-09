package com.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cms.entity.User;
import com.cms.serve.UserServe;

public class TestUser {

	@Test
	public void test() {
		User user = new User();
		user.setUserName("123");
		user.setPassWord("123");
		User user1 = new UserServe().checkUser(user);
		
	}

}
