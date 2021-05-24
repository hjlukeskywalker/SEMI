package com.product.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.product.model.dao.ProductDao;
import com.product.model.vo.Product;

public class ProductService {
	
	private ProductDao dao=new ProductDao();
	
	
	public String searchCateCode(String category) {
		Connection conn=getConnection();
		String cateCode=dao.searchCateCode(conn,category);
		close(conn);
		return cateCode;
	}
	
	
	public List<Product> selectProductList(String cateCode, int cPage, int numPerPage){
		Connection conn=getConnection();
		List<Product> list=dao.selectProductList(conn,cateCode,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	
	public List<Product> selectProductList(int cPage, int numPerPage){
		Connection conn=getConnection();
		List<Product> list=dao.selectProductList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	
	public int selectProductCount(String cateCode) {
		Connection conn=getConnection();
		int result=dao.selectProductCount(conn,cateCode);
		close(conn);
		return result;
	}
	
	
	public int selectProductCount() {
		Connection conn=getConnection();
		int result=dao.selectProductCount(conn);
		close(conn);
		return result;
	}

}
