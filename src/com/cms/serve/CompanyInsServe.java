package com.cms.serve;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.cms.dao.CompanyInsDao;
import com.cms.entity.CompanyIns;
import com.cms.utils.MybatisUtil;


@Service
public class CompanyInsServe {
	public List<CompanyIns> getAllCompanyIns(){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		CompanyInsDao companyInsDao = session.getMapper(CompanyInsDao.class);
		List<CompanyIns> companyInsList =  companyInsDao.getList();
		return companyInsList;
	}
	public List<CompanyIns> getCompanyInsByParam(Integer[] ids){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		CompanyInsDao companyInsDao = session.getMapper(CompanyInsDao.class);
		List<CompanyIns> companyInsList =  companyInsDao.getListByParam(ids);
		return companyInsList;
	}
	public CompanyIns getDetailById(int id){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		CompanyInsDao companyInsDao = session.getMapper(CompanyInsDao.class);
		return companyInsDao.getOneById(id);
	}
	public CompanyIns getShortInfo(){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		CompanyInsDao companyInsDao = session.getMapper(CompanyInsDao.class);
		return companyInsDao.getShortInfo();
	}
	public int updateCompanyIns(CompanyIns companyIns){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		CompanyInsDao companyInsDao = session.getMapper(CompanyInsDao.class);
		return companyInsDao.updateCompanyIns(companyIns);
	}
}
