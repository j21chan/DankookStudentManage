package com.dankook.EGINE_MANAGE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BorrowDao {
	// DaataSource 가져오는 과정
	DataSource dataSource;
	
	// 생성자
	public BorrowDao() {
		// Data Source 검색
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 대여 로직
	public int addBorrow(String staffId, String studentId, int productNumber, int productIndex) {
		
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
			query = "insert into borrow_list(StaffId, StudentId, ProductNumber, ProductIndex) values (?, ?, ?, ?)";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setString(1, staffId);
			preStatement.setString(2, studentId);
			preStatement.setInt(3, productNumber);
			preStatement.setInt(4, productIndex);
			
			// 쿼리문 실행
			run = preStatement.executeUpdate();
			System.out.println("Borrow Add 성공");
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Borrow Add 실패");
			
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
	
	
	// 물품 반납 로직
	public int deleteBorrow(int borrowNumber) {
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
			query = "delete from borrow_list where BorrowNumber = ? ";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setInt(1, borrowNumber);
			
			// 쿼리문 실행
			run = preStatement.executeUpdate();
			System.out.println("Borrow Delete 성공");
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Borrow Delete 실패");
			
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
	
	
	// 전체 대여 목록 로직
	
	// 대여 검색 로직
}
