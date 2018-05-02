package com.dankook.EGINE_MANAGE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDao {
	// DaataSource 가져오는 과정
	DataSource dataSource;
	
	// 생성자
	public ProductDao() {
		// Data Source 검색
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 물품 추가 로직
	// 반환: 성공값 / 매개변수: 물품 이름
	public int addProduct (String productName) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		String query = null;
		
		// 성공값 1:성공, 0: 실패
		int run = 0;
		
		try {
			// 커넥션 객체 가져오기
			conn = dataSource.getConnection();
			
			// 쿼리문
			query = "insert into product(ProductName) values (?)";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setString(1, productName);
			
			// 쿼리문 실행
			run = preStatement.executeUpdate();
			System.out.println("Product Add 성공");
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Product Add 실패");
			
		} finally {
			// 커넥션 객체 닫기
			try {
				if (preStatement != null) { preStatement.close(); }
				if (conn != null) { conn.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return run;
	}
	
	// 물품 삭제 로직
	public int deleteProduct(int productNumber) {
		
	}
}
