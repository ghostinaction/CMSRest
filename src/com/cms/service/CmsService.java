package com.cms.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cms.entity.Carousel;
import com.cms.entity.CompanyInfo;
import com.cms.entity.CompanyIns;
import com.cms.entity.Product;
import com.cms.entity.ProductKind;
import com.cms.serve.CarouselServe;
import com.cms.serve.CompanyInfoServe;
import com.cms.serve.CompanyInsServe;
import com.cms.serve.ProductServe;
import com.github.pagehelper.PageInfo;

@Path("/CmsService")
@Consumes(MediaType.TEXT_PLAIN)
public class CmsService {	
	ProductServe productServe = new ProductServe();
	CompanyInsServe companyInsServe = new CompanyInsServe();
	CompanyInfoServe companyInfoServe = new CompanyInfoServe();
	
	@GET
    @Path("/sayHello")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "success";
    }
	
	@GET
    @Path("/getProductKind")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductKind() {
		JSONObject result = new JSONObject();
		List<ProductKind> productKinds = productServe.getProductKind();
		if(productKinds == null){
			result.put("status", "F");
		}else{
			for(ProductKind productKind:productKinds){
				System.out.println(productKind.toString());
			}
			result.put("status", "S");
			result.put("data", productKinds);
		}
		return result.toJSONString();
				
    }
	
	@GET
    @Path("/getProducts")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String getProducts(@QueryParam("kindId") int kindId,
    						  @QueryParam("pageNo") int pageNo,
    						  @QueryParam("pageSize") int pageSize) {
		JSONObject result = new JSONObject();
		PageInfo<Product> products = productServe.getProducts(kindId, pageNo, pageSize);
		if(products == null){
			result.put("status", "F");
		}else{
			result.put("status", "S");
			result.put("pageSize", products.getPageSize());
			result.put("pageNo", products.getPageNum());
			result.put("total", products.getTotal());
			result.put("data", products.getList());
			result.put("pageTotal", products.getPages());
		}
		System.out.println(result.toJSONString());
		return JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);				
    }
	@GET
	@Path("/getProductDetail")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
	public String getProductDetail(@QueryParam("productId") int productId){
		Product product = productServe.getProductDetail(productId);
		JSONObject result = new JSONObject();
		result.put("status", "S");
		result.put("data", product);
		
		//序列化的时候string为null输出为""
		//http://www.cnblogs.com/jiang-it/p/6594418.html
		return JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
	}
	
	@GET
    @Path("/getCpyIns")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
	public String getCpyIns(){
		List<CompanyIns> companyInsList = companyInsServe.getAllCompanyIns();
		JSONObject result = new JSONObject();
		result.put("status", "S");
		result.put("data", companyInsList);
		return result.toString();
	}
	@GET
	@Path("/getShortInfo")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String getShortInfo(){
		CompanyIns companyIns = companyInsServe.getShortInfo();
		JSONObject result = new JSONObject();
		result.put("status", "S");
		result.put("data", companyIns);
		return result.toString();
	}
	@GET
    @Path("/getCpyInsDetail")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
	public String getCpyDetail(@QueryParam("artId") int artId){
		CompanyIns companyIns = companyInsServe.getDetailById(artId);
		JSONObject result = new JSONObject();
		result.put("status", "S");
		result.put("data", companyIns);
		return result.toString();
	}
	@GET
    @Path("/getInfo")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
	public String getCpyInfo(){
		CompanyInfo companyInfo = companyInfoServe.getInfo();
		JSONObject result = new JSONObject();
		result.put("status", "S");
		result.put("data", companyInfo);
		
		return result.toString();
	}
	@GET
    @Path("/getCarouses")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
	public String getCarouses(){
		List<Carousel> carousels = new CarouselServe().getCarousels();
		JSONObject result = new JSONObject();
		result.put("status", "S");
		result.put("data", carousels);
		return result.toJSONString();
	}
	
}
