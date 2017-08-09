package com.cms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.entity.Product;
import com.cms.entity.ProductKind;
import com.cms.serve.ProductServe;

@Controller
@RequestMapping("productManage")
public class ProductManagerController {
	@Resource
	private ProductServe productServe;
	
	@RequestMapping("getProductKind.do")
	public ModelAndView getProductKind(){
		ModelAndView modelAndView = new ModelAndView("files/productkind");
		List<ProductKind> productKinds = productServe.getProductKind();
		modelAndView.addObject("productKinds", productKinds);
		return modelAndView;
	}
	
	@RequestMapping("getProductKindJSON.do")
	@ResponseBody
	public List<ProductKind> getProductKindJSON(){
		List<ProductKind> productKinds = productServe.getProductKind();
		return productKinds;
	}
	
//	@RequestMapping("getProductDetail")
	
	@RequestMapping(value="edit.do" ,method=RequestMethod.POST)
	public String editProductKind(ProductKind productKind){
		System.out.println(productKind.getKindName());
		int retId = productServe.insertOrUpdateProductKind(productKind);
		return "redirect:getProductKind.do";
	}
	@RequestMapping("delete.do")
	public String deleteProductKind(@QueryParam(value="id") int id){
		int retId = productServe.deleteProductKind(id);
		return "redirect:getProductKind.do";
	}
	
	@RequestMapping("listProduct.do")
	public ModelAndView listProduct(){
		ModelAndView modelAndView = new ModelAndView("files/productList");
		List<Product> products = productServe.getAllProduct();
		modelAndView.addObject("products", products);
		return modelAndView;
	}
	@RequestMapping("getProductDetailJSON.do")
	@ResponseBody
	public Product getProductDetailJSON(@QueryParam(value="id") int id){
		return productServe.getProductDetail(id);
	}
	@RequestMapping("deleteProduct.do")
	public String deleteProduct(@QueryParam(value="productId") int productId){
		int retId = productServe.deleteProduct(productId);
		return "redirect:listProduct.do";
	}
	@RequestMapping(value="editProduct.do",method=RequestMethod.POST)
	public String editProduct(Product product){
		int retId = productServe.insertOrUpdateProduct(product);
		return "redirect:listProduct.do";
	}
}
