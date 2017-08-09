package com.cms.dao;

import java.util.List;

import com.cms.entity.CompanyIns;

public interface CompanyInsDao {
	List<CompanyIns> getList();
	List<CompanyIns> getListByParam(Integer[] ids);
	CompanyIns getOneById(int id);
	CompanyIns getShortInfo();
	int updateCompanyIns(CompanyIns companyIns);
	
}
