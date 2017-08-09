package com.cms.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import com.cms.dao.CompanyInsDao;
import com.cms.dao.ProductMapper;
import com.cms.entity.CompanyIns;
import com.cms.entity.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class Test {
	private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static{
        try{
            reader = Resources.getResourceAsReader("com/cms/config/Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	@Before
	public void setUp() throws Exception {
		
	}

//	@org.junit.Test
	public void testGetProductByKindId() {
		SqlSession session = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		int pageNo = 1;
	    int pageSize = 2;
	    PageHelper.startPage(pageNo, pageSize);
    	List<Product> products = productMapper.getProductByKindId(1);
    	PageInfo<Product> page = new PageInfo<Product>(products);
    	for (Product product : products) {
    		System.out.println(product);
		}
        //测试PageInfo全部属性
        System.out.println(page.getPageNum());
        System.out.println(page.getPageSize());
        System.out.println(page.getStartRow());
        System.out.println(page.getEndRow());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getFirstPage());
        System.out.println(page.getLastPage());
        System.out.println(page.isHasPreviousPage());
        System.out.println(page.isHasNextPage());
	}
//	@org.junit.Test
	public void testGetCompanys(){
		SqlSession session = sqlSessionFactory.openSession(true);
		CompanyInsDao companyInsDao = session.getMapper(CompanyInsDao.class);
//		CompanyIns companyIns = new CompanyIns();
//		companyIns.setId(2);
//		List<CompanyIns> companyInsList =  companyInsDao.getList(companyIns);
		List<CompanyIns> companyInsList =  companyInsDao.getList();
		for(CompanyIns com:companyInsList){
			System.out.println(com);
		}
	}
	@org.junit.Test
	public void testGetCompanysParams(){
		SqlSession session = sqlSessionFactory.openSession(true);
		CompanyInsDao companyInsDao = session.getMapper(CompanyInsDao.class);
//		CompanyIns companyIns = new CompanyIns();
//		companyIns.setId(2);
//		List<CompanyIns> companyInsList =  companyInsDao.getList(companyIns);
		Integer []ids = new Integer[]{1,2,3};
		List<CompanyIns> companyInsList =  companyInsDao.getListByParam(ids);
		for(CompanyIns com:companyInsList){
			System.out.println(com);
		}
	}
//	@org.junit.Test
	public void testGetOneCompany(){
		SqlSession session = sqlSessionFactory.openSession(true);
		CompanyInsDao companyInsDao = session.getMapper(CompanyInsDao.class);
		CompanyIns companyIns=  companyInsDao.getOneById(1);
		System.out.println(companyIns);
	}
//	@org.junit.Test
	public void testCpyIns(){
		
	}
//	@org.junit.Test
	public void testUpdataCpy(){
		SqlSession session = sqlSessionFactory.openSession(true);
		CompanyInsDao companyInsDao = session.getMapper(CompanyInsDao.class);
		CompanyIns companyIns=  companyInsDao.getOneById(1);
		companyIns.setContent("<h3>hello world</h3>");
		int count = companyInsDao.updateCompanyIns(companyIns);
		System.out.println(count);
	}
}
