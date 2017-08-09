package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cms.entity.Product;
import com.cms.entity.ProductKind;
import com.cms.utils.JDBCUtilsSuper;
import com.cms.utils.Pageer;



public class ProductDao {
	public int deleteProductKindById(int id){
		int res = 0;
		Connection conn = JDBCUtilsSuper.getConnection();
		String sql = "delete from kindTbl where id = "+id+"";
		Statement stat;
		try {
			stat = conn.createStatement();
			res = stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	public ProductKind getProductKindById(int id){
		Connection conn = JDBCUtilsSuper.getConnection();
		QueryRunner qRunner = new QueryRunner();
		List<ProductKind> productKinds = null;
		String sql = "select * from kindTbl where id = ?";
		try {
			productKinds = (List<ProductKind>)qRunner.query(conn, sql,new Object[]{id},new BeanListHandler(ProductKind.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(productKinds.size()>0){
			return productKinds.get(0);
		}else{
			return null;
		}
	}
	public int insertOrUpdateProductKind(ProductKind productKind){
		//这里没有把实体类的id设置为Integer是很有问题，要不就直接可以null来判断了
		Connection conn = JDBCUtilsSuper.getConnection();
		int res = 0;
		System.out.println("id:"+productKind.getId());
		if(productKind.getId() == null || "".equals(productKind.getId().toString())){
			String sql = "insert into kindTbl(kindName) values(?)";
			PreparedStatement stat;
			try {
				stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				stat.setString(1, productKind.getKindName());
				res = stat.executeUpdate();
				ResultSet resultSet = stat.getGeneratedKeys();
				while(resultSet.next()){
					productKind.setId(resultSet.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			String sql = "update kindTbl set kindName = '"+productKind.getKindName()+"' where id = "+productKind.getId()+"";
			Statement stat;
			try {
				stat = conn.createStatement();
				res = stat.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public List<ProductKind> getProductKinds(){
		Connection con = JDBCUtilsSuper.getConnection();
		List<ProductKind> productKinds = new ArrayList<ProductKind>();
		try {
			Statement stat = con.createStatement();
			String sql = "select * from kindTbl";
			ResultSet res = stat.executeQuery(sql);
			while(res.next()){
				ProductKind productKind = new ProductKind();
				productKind.setId(res.getInt("id"));
				productKind.setKindName(res.getString("kindname"));
				productKinds.add(productKind);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productKinds;
	}
	
	public Pageer<Product> getProductByKindId(int kindId,int pageNum,int pageSize){
//		System.out.println(kindId);
		Connection conn = JDBCUtilsSuper.getConnection();
		QueryRunner qRunner = new QueryRunner();
		List<Product> products = new ArrayList<Product>();
		Pageer<Product> resutlProducts =new Pageer<Product>();
		String sql1 = "select count(1) count from ProductTbl INNER JOIN kindTbl where ProductTbl.kindid = kindTbl.id and kindTbl.id=?";
//		qRunner.query(conn, sql2,new Object[]{kindId,pageNum,pageSize},new BeanListHandler(Product.class));
		String sql2 = "select * from ProductTbl INNER JOIN kindTbl where ProductTbl.kindid = kindTbl.id and kindTbl.id=? limit ?,?";
		
		try {
			Long count = (Long) qRunner.query(conn, sql1,new Object[]{kindId},new ScalarHandler(1));
			resutlProducts.setCount(count.intValue());
			products = (List<Product>) qRunner.query(conn, sql2,new Object[]{kindId,(pageNum-1)*pageSize,pageSize},new BeanListHandler(Product.class));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		System.out.println(resutlProducts);
		return resutlProducts;
	}
}
