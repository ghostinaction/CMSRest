package com.cms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cms.entity.Product;
import com.cms.utils.JDBCUtilsSuper;
import com.cms.utils.Pageer;

public interface ProductMapper {
	@Select("select ProductTbl.* from ProductTbl LEFT JOIN kindTbl ON ProductTbl.kindid = kindTbl.id where kindTbl.id=#{kindId}")
	public List<Product> getProductByKindId(int kindId);
	@Select("select ProductTbl.*,kindTbl.kindName from ProductTbl LEFT JOIN kindTbl ON ProductTbl.kindid = kindTbl.id")
	public List<Product> getAllProduct();
	@Select("select ProductTbl.*,kindTbl.kindName from ProductTbl LEFT JOIN kindTbl ON ProductTbl.kindid = kindTbl.id where ProductTbl.id = #{id}")
	public Product getProductById(int id);
	@Delete("delete from ProductTbl where ProductTbl.id = #{id}")
	public int deleteProductById(int id);
	@Insert("insert into ProductTbl(kindId,productName,mainUrl,detailUrl,productInfo,productDetail) values(#{kindId},#{productName},#{mainUrl},#{detailUrl},#{productInfo},#{productDetail})")
	public int insertProduct(Product product);
	@Update("update productTbl set kindId=#{kindId},productName=#{productName},mainUrl=#{mainUrl},productDetail=#{productDetail},detailUrl=#{detailUrl},productInfo=#{productInfo} where id=#{id}")
	public int updateProduct(Product product);
	
}
