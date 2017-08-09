package com.cms.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.aspectj.apache.bcel.generic.NEW;
import org.junit.Test;

import com.cms.entity.CompanyIns;
import com.cms.entity.LeaveMsg;
import com.cms.serve.CompanyInsServe;
import com.cms.serve.LeaveMsgServe;

public class testMsg {
	
	LeaveMsgServe leaveMsgServe = new LeaveMsgServe();
	@Test
	public void test() {
		List<LeaveMsg> ls = leaveMsgServe.getMsgs();
		for(LeaveMsg one:ls){
			System.out.println(one);
			System.out.println(one.getLeaveTime());
		}
//		LeaveMsg leaveMsg = new LeaveMsg();
//		leaveMsg.setCompanyAddress("abc");
//		leaveMsg.setLeaveTime(new Date());
//		leaveMsgServe.insertMsg(leaveMsg);
		leaveMsgServe.deleteMsgById(2);
	}
	@Test
	public void testInsert(){
		LeaveMsg leaveMsg = new LeaveMsg();
		leaveMsg.setEmail("123");
		leaveMsgServe.insertMsg(leaveMsg);
		System.out.println("a:"+leaveMsg.getId());
	}
	@Test
	public void testCpyIns(){	
		CompanyInsServe companyInsServe = new CompanyInsServe();
		CompanyIns companyIns = companyInsServe.getDetailById(1);
		System.out.println(companyIns);
	}

}
