package com.cms.serve;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.cms.dao.ProductDao;
import com.cms.dao.ProductMapper;
import com.cms.entity.Product;
import com.cms.entity.ProductKind;
import com.cms.utils.MybatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProductServe {
	ProductDao productDao = new ProductDao();
	public List<ProductKind> getProductKind(){
		return productDao.getProductKinds();
	}
	
	public int deleteProductKind(int id){
		return productDao.deleteProductKindById(id);
	}
	public int insertOrUpdateProductKind(ProductKind productKind){
		return productDao.insertOrUpdateProductKind(productKind);
	}
	
	public PageInfo<Product> getProducts(int kindId,int pageNo,int pageSize){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		pageNo = pageNo == 0?1:pageNo;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Product> products = null;
	    if(kindId <= 0){
	    	products = productMapper.getAllProduct();
	    }else{
	    	products = productMapper.getProductByKindId(kindId);
	    }
    	
    	PageInfo<Product> page = new PageInfo<Product>(products);
    	for (Product product : products) {
    		System.out.println(product);
		}
    	return page;
	}
	public List<Product> getAllProduct(){
		List<Product> products = null;
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		products = productMapper.getAllProduct();
		return products;
	}
	
	public List<Product> getProductList(int kindId){
		List<Product> products = null;
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		products = productMapper.getProductByKindId(kindId);
		return products;
	}
	public Product getProductDetail(int id){
		Product product = null;
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		product = productMapper.getProductById(id);
		return product;
	}
	public int deleteProduct(int id){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		return productMapper.deleteProductById(id);
	}
	public int insertOrUpdateProduct(Product product){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		int ret = 0;
		if(product.getId() == null || "".equals(product.getId().toString())){
			ret = productMapper.insertProduct(product);
		}else{
			ret = productMapper.updateProduct(product);
		}
		return ret;
	}
}
