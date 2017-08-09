package com.cms.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cms.entity.User;

public interface UserDao {
	@Select("select * from userTbl where userName=#{userName} and passWord=#{passWord} and canUse='YES'")
	public User getUser(User user);
	
	@Update("update userTbl set passWord=#{passWord} where id=#{id}")
	public int updateUser(User user);
}
