package com.cms.dao;

import com.cms.entity.CompanyInfo;

public interface CompanyInfoDao {
	CompanyInfo getInfo();
	int updateInfo(CompanyInfo companyInfo);
}
