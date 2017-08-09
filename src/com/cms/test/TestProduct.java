package com.cms.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cms.entity.Product;
import com.cms.serve.ProductServe;

public class TestProduct {
	private ProductServe productServe = new ProductServe();
	@Test
	public void test() {
//		productServe.deleteProduct(5);
		
		Product product = productServe.getProductDetail(1);
		System.out.println(product);
		
//		product.setProductName("飞行器1号");
//		productServe.insertOrUpdateProduct(product);
//		
//		Product product2 = new Product();
//		product2.setProductName("梦幻开局");
//		productServe.insertOrUpdateProduct(product2);
		
		List<Product> products = productServe.getAllProduct();
		for(Product product2:products){
			System.out.println(product2);
		}
	}

}
