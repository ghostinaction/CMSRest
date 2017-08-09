package com.cms.serve;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.cms.dao.CompanyInfoDao;
import com.cms.dao.CompanyInsDao;
import com.cms.entity.CompanyInfo;
import com.cms.utils.MybatisUtil;

@Service
public class CompanyInfoServe {
	public CompanyInfo getInfo(){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		CompanyInfoDao companyInfoDao = session.getMapper(CompanyInfoDao.class);
		return companyInfoDao.getInfo();
	}
	public int updateInfo(CompanyInfo companyInfo){
		System.out.println("get:"+companyInfo);
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		CompanyInfoDao companyInfoDao = session.getMapper(CompanyInfoDao.class);
		return companyInfoDao.updateInfo(companyInfo);
	}
}
