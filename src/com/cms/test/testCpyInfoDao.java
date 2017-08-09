package com.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cms.dao.ProductDao;
import com.cms.entity.CompanyInfo;
import com.cms.entity.ProductKind;
import com.cms.serve.CompanyInfoServe;
import com.cms.serve.CompanyInsServe;

public class testCpyInfoDao {

//	@Test
	public void testUpdate(){
		CompanyInfo companyInfo = new CompanyInfoServe().getInfo();
		companyInfo.setAddress("aaaaaaaaaaaaaa");
		new CompanyInfoServe().updateInfo(companyInfo);
	}
//	@Test
	public void test() {
		CompanyInfo companyInfo = new CompanyInfoServe().getInfo();
		System.out.println(companyInfo);
	}
//	@Test
	public void testKindId(){
		ProductKind productKind = new ProductDao().getProductKindById(1);
		System.out.println(productKind);
	}
//	@Test 
	public void testDelete(){
		new ProductDao().deleteProductKindById(5);
	}
	@Test 
	public void insertUpdate(){
		ProductKind productKind = new ProductDao().getProductKindById(1);
		productKind.setKindName("空气炮系列");
//		ProductKind productKind = new ProductKind();
//		productKind.setKindName("123");
		new ProductDao().insertOrUpdateProductKind(productKind);
	}

}
