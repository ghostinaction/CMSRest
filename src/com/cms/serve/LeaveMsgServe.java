package com.cms.serve;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.cms.dao.CompanyInfoDao;
import com.cms.dao.LeaveMsgDao;
import com.cms.entity.LeaveMsg;
import com.cms.utils.MybatisUtil;

@Service
public class LeaveMsgServe {
	public List<LeaveMsg> getMsgs(){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		LeaveMsgDao leaveMsgDao = session.getMapper(LeaveMsgDao.class);
		return leaveMsgDao.getList();
	}
	public int insertMsg(LeaveMsg leaveMsg){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		LeaveMsgDao leaveMsgDao = session.getMapper(LeaveMsgDao.class);
		return leaveMsgDao.insert(leaveMsg);		
	}
	public int deleteMsgById(int id){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		LeaveMsgDao leaveMsgDao = session.getMapper(LeaveMsgDao.class);
		return leaveMsgDao.delete(id);
	}
}
