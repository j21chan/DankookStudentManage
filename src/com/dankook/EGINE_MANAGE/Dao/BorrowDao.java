package com.dankook.EGINE_MANAGE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dankook.EGINE_MANAGE.Dto.BorrowDto;

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
	public ArrayList<BorrowDto> listBorrow() {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		ResultSet resultSet = null;
		String query = null;
		
		// 대여 리스트, 대여 객체
		ArrayList<BorrowDto> dtos = new ArrayList<BorrowDto>();
		BorrowDto borrow = null;
		
		try {
			// 커넥션 객체 가져오기
			conn = dataSource.getConnection();
			
			// 쿼리문
			query = "select a.BorrowNumber as BorrowNumber,\r\n" + 
					"		 b.StudentId as StaffNumber, b.StudentName as StaffName, b.MajorName as StaffMajor, b.Phone as StaffPhone,\r\n" + 
					"		 c.StudentId as StudentNumber, c.StudentName as StudentName, c.MajorName as StudentMajor, c.Phone as StudentPhone,\r\n" + 
					"		 a.ProductName as ProductName, a.ProductIndex as ProductIndex, a.BorrowDate as BorrowDate\r\n" + 
					"from (select BorrowNumber, StaffId, StudentId, ProductName, ProductIndex, BorrowDate\r\n" + 
					"		from borrow_list, product\r\n" + 
					"		where borrow_list.ProductNumber = product.ProductNumber) as a,\r\n" + 
					"\r\n" + 
					"	  (select id, StudentId, StudentName, MajorName, Phone\r\n" + 
					"	  	from student, major\r\n" + 
					"	  	where student.MajorNumber = major.MajorNumber) as b,\r\n" + 
					"	  	\r\n" + 
					"	  (select id, StudentId, StudentName, MajorName, Phone\r\n" + 
					"	   from student, major\r\n" + 
					"	   where student.MajorNumber = major.MajorNumber) as c\r\n" + 
					"\r\n" + 
					"where a.StaffId = b.id\r\n" + 
					"		and a.StudentId = c.id\r\n" + 
					"		\r\n" + 
					"order by a.BorrowNumber asc;";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);

			resultSet = preStatement.executeQuery();
			System.out.println("Borrow List 성공");
			
			// 대여 정보를 DB에서 가져옴
			while (resultSet.next()) {
				System.out.println("대여 정보 가져옴");
				int borrowNumber = Integer.parseInt(resultSet.getString("BorrowNumber"));
				
				int staffNumber = Integer.parseInt(resultSet.getString("StaffNumber"));
				String staffName = resultSet.getString("StaffName");
				String staffMajor = resultSet.getString("StaffMajor");
				String staffPhone = resultSet.getString("StaffPhone");
				
				int studentNumber = Integer.parseInt(resultSet.getString("StudentNumber"));
				String studentName = resultSet.getString("StudentName");
				String studentMajor = resultSet.getString("StudentMajor");
				String studentPhone = resultSet.getString("StudentPhone");
				
				int productIndex = Integer.parseInt(resultSet.getString("ProductIndex"));
				String productName = resultSet.getString("ProductName");
				
				Timestamp borrowDate = resultSet.getTimestamp("BorrowDate");
				
				// 학생 객체를 만들어서 리스트에 넣어줌
				borrow = new BorrowDto(borrowNumber,
									   staffNumber, staffName, staffMajor, staffPhone,
									   studentNumber, studentName, studentMajor, studentPhone,
									   productIndex, productName, borrowDate);
				dtos.add(borrow);
			}
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Borrow List 실패");
			
		} finally {
			// 커넥션 객체 닫기
			try {
				if (preStatement != null) { preStatement.close(); }
				if (conn != null) { conn.close(); }
				if (resultSet != null) { resultSet.close(); }
			} catch (Exception e2) {
				// 커넥션 객체 닫기 에러
 				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	
	// 대여 검색 로직
	public ArrayList<BorrowDto> searchBorrow(String type, String keyword) {
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		ResultSet resultSet = null;
		String query = null;
		
		// 대여 리스트, 대여 객체
		ArrayList<BorrowDto> dtos = new ArrayList<BorrowDto>();
		BorrowDto borrow = null;
		
		try {
			// 커넥션 객체 가져오기
			conn = dataSource.getConnection();
			
			// 쿼리문
			query = "select a.BorrowNumber as BorrowNumber,\r\n" + 
					"		 b.StudentId as StaffNumber, b.StudentName as StaffName, b.MajorName as StaffMajor, b.Phone as StaffPhone,\r\n" + 
					"		 c.StudentId as StudentNumber, c.StudentName as StudentName, c.MajorName as StudentMajor, c.Phone as StudentPhone,\r\n" + 
					"		 a.ProductName as ProductName, a.ProductIndex as ProductIndex, a.BorrowDate as BorrowDate\r\n" + 
					"from (select BorrowNumber, StaffId, StudentId, ProductName, ProductIndex, BorrowDate\r\n" + 
					"		from borrow_list, product\r\n" + 
					"		where borrow_list.ProductNumber = product.ProductNumber) as a,\r\n" + 
					"\r\n" + 
					"	  (select id, StudentId, StudentName, MajorName, Phone\r\n" + 
					"	  	from student, major\r\n" + 
					"	  	where student.MajorNumber = major.MajorNumber) as b,\r\n" + 
					"	  	\r\n" + 
					"	  (select id, StudentId, StudentName, MajorName, Phone\r\n" + 
					"	   from student, major\r\n" + 
					"	   where student.MajorNumber = major.MajorNumber) as c\r\n" + 
					"\r\n" + 
					"where a.StaffId = b.id\r\n" + 
					"		and a.StudentId = c.id\r\n" + 
					"		and " + type + " like ? \r\n" + 
					"order by a.BorrowNumber asc;";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// preStatement 문장 완성
			preStatement.setString(1, "%" + keyword + "%");
			
			// 쿼리 실행
			resultSet = preStatement.executeQuery();
			System.out.println("Borrow Search 성공");
			
			// 대여 정보를 DB에서 가져옴
			while (resultSet.next()) {
				int borrowNumber = Integer.parseInt(resultSet.getString("BorrowNumber"));
				
				int staffNumber = Integer.parseInt(resultSet.getString("StaffNumber"));
				String staffName = resultSet.getString("StaffName");
				String staffMajor = resultSet.getString("StaffMajor");
				String staffPhone = resultSet.getString("StaffPhone");
				
				int studentNumber = Integer.parseInt(resultSet.getString("StudentNumber"));
				String studentName = resultSet.getString("StudentName");
				String studentMajor = resultSet.getString("StudentMajor");
				String studentPhone = resultSet.getString("StudentPhone");
				
				int productIndex = Integer.parseInt(resultSet.getString("ProductIndex"));
				String productName = resultSet.getString("ProductName");
				
				Timestamp borrowDate = resultSet.getTimestamp("BorrowDate");
				
				// 학생 객체를 만들어서 리스트에 넣어줌
				borrow = new BorrowDto(borrowNumber,
									   staffNumber, staffName, staffMajor, staffPhone,
									   studentNumber, studentName, studentMajor, studentPhone,
									   productIndex, productName, borrowDate);
				dtos.add(borrow);
			}
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Borrow Search 실패");
			
		} finally {
			// 커넥션 객체 닫기
			try {
				if (preStatement != null) { preStatement.close(); }
				if (conn != null) 		  { conn.close(); }
				if (resultSet != null) 	  { resultSet.close(); }
			} catch (Exception e2) {
				// 커넥션 객체 닫기 에러
 				e2.printStackTrace();
			}
		}
		return dtos;
	}
}
