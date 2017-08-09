package com.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.cms.entity.LeaveMsg;

public interface LeaveMsgDao {
	 @Results(value = {
			 			@Result(property = "nickName", column = "nickname"),
			 			@Result(property = "companyName", column = "bus_name"),			 		
			 			@Result(property = "companyAddress", column = "bus_address"),			 		
	 			}) 
	@Select("select * from leavemessage order by leaveTime desc")
	public List<LeaveMsg> getList();	
	
	@Delete("delete from leavemessage where id=#{id}")
	public int delete(int id);
	
	@Insert("insert into leavemessage(nickname,email,phone,bus_name,bus_address,title,content,leaveTime) values(#{nickName},#{email},#{phone},#{companyName},#{companyAddress},#{title},#{content},#{leaveTime})")
	@SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = int.class)
	public int insert(LeaveMsg leaveMsg);
}
