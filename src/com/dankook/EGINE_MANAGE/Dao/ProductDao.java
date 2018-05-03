package com.dankook.EGINE_MANAGE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dankook.EGINE_MANAGE.Dto.ProductDto;

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
			query =  "delete from product where ProductNumber = ?";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setInt(1, productNumber);
			
			// 쿼리문 실행
			run = preStatement.executeUpdate();
			System.out.println("Product Delete 성공");
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Product Delete 실패");
			
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
	
	// 물품 검색 로직
	public ArrayList<ProductDto> searchProduct(String productName) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		ResultSet resultSet = null;
		String query = null;
		
		// 물품 DTO객체, 물품 리스트
		ProductDto product = null;
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		// 물품 검색 로직 시작
		try {
			// 커넥션 객체 얻기
			conn = dataSource.getConnection();
			
			// 쿼리문 생성
			query = "select * from product where ProductName like %?%";
			
			// 쿼리문 완성
			preStatement = conn.prepareStatement(query);
			preStatement.setString(1, productName);
			
			// 쿼리문 실행 후 결과 얻기
			resultSet = preStatement.executeQuery(query);
			
			// 물품 객체 받아오기
			while(resultSet.next()) {
				
				// 객체 정보 받아오기
				int productNumber = resultSet.getInt("ProductNumber");
				String productName1 = resultSet.getString("ProductName");
				
				// 객체 생성 후 리스트에 넣기
				product = new ProductDto(productNumber, productName1);
				dtos.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				// 사용한 객체 반납
				if (preStatement != null) { preStatement.close(); }
				if (conn != null) { conn.close(); }
				if (resultSet != null) { resultSet.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	// 물품 리스트 로직
	public ArrayList<ProductDto> listProduct() {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		ResultSet resultSet = null;
		String query = null;
		
		// 물품 DTO객체, 물품 리스트
		ProductDto product = null;
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		// 물품 리스트 로직 시작
		try {
			// 커넥션 객체 얻기
			conn = dataSource.getConnection();
			
			// 쿼리문 생성
			query = "select * from product";
			
			// 쿼리문 완성
			preStatement = conn.prepareStatement(query);
			
			// 쿼리문 실행 후 결과 얻기
			resultSet = preStatement.executeQuery(query);
			
			// 물품 객체 받아오기
			while(resultSet.next()) {
				
				// 객체 정보 받아오기
				int productNumber = resultSet.getInt("ProductNumber");
				String productName1 = resultSet.getString("ProductName");
				
				// 객체 생성 후 리스트에 넣기
				product = new ProductDto(productNumber, productName1);
				dtos.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				// 사용한 객체 반납
				if (preStatement != null) { preStatement.close(); }
				if (conn != null) { conn.close(); }
				if (resultSet != null) { resultSet.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return null;
	}
}
