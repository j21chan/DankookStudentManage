package com.dankook.EGINE_MANAGE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dankook.EGINE_MANAGE.Dto.StudentDto;
import com.dankook.EGINE_MANAGE.Uility.DeptUtil;
import com.dankook.EGINE_MANAGE.Uility.MajorUtil;

public class StudentDao {
	// DaataSource 가져오는 과정
	DataSource dataSource;
	
	// 생성자
	public StudentDao() {
		// Data Source 검색
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 학생 회원 가입 로직
	// 반환: 성공값 / 매개변수: 학생 회원 가입 정보
	public int joinStudent(String id, String pw, int studentId, String studentName, int majorNumber, int deptNumber, String sex, String phone, String address) {
		
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
			query = "insert into student(id, pw, StudentID, StudentName, MajorNumber, DeptNumber, Sex, Phone, Address) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setString(1, id);
			preStatement.setString(2, pw);
			preStatement.setInt(3, studentId);
			preStatement.setString(4, studentName);
			preStatement.setInt(5, majorNumber);
			preStatement.setInt(6, deptNumber);
			preStatement.setString(7, sex);
			preStatement.setString(8, phone);
			preStatement.setString(9, address);
			
			// 쿼리문 실행
			run = preStatement.executeUpdate();
			System.out.println("Student Join 성공");
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Student Join 실패");
			
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
	
	
	// 학생 로그인 로직
	// 반환: 성공값 / 매개변수: 학생 로그인 정보
	public StudentDto loginStudent(String sID, String sPW) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		ResultSet resultSet = null;
		String query = null;
		
		// 학생 객체
		StudentDto student = null;
		
		try {
			// 커넥션 객체 가져오기
			conn = dataSource.getConnection();
			
			// 쿼리문
			query = "select * from student where id = ? and pw = ?";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setString(1, sID);
			preStatement.setString(2, sPW);
			
			// 쿼리문 실행
			resultSet = preStatement.executeQuery(query);
			System.out.println("Student Login 성공");
			
			// 학생 정보를 DB에서 가져옴
			if (resultSet.next()) {
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				
				int studentId = Integer.parseInt(resultSet.getString("StudentID"));
				String studentName = resultSet.getString("StudentName");
				
				String major = resultSet.getString("Major");
				String dept = resultSet.getString("Dept");
				
				String sex = resultSet.getString("Sex");
				String phone = resultSet.getString("Phone");
				String address = resultSet.getString("Address");
				
				student = new StudentDto(id, pw, studentId, studentName, major, dept, sex, phone, address);
			}
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Student Login 실패");
		} finally {
			// 커넥션 객체 닫기
			try {
				if (preStatement != null) { preStatement.close(); }
				if (conn != null) { conn.close(); }
				if (resultSet != null) { resultSet.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return student;
	}

	// 학생 회원 정보 수정 로직
	// 반환: 성공값 / 매개변수: 학생 회원 수정 정보
	public StudentDto modifyStudent(String id, String pw, int studentId, String studentName, int majorNumber, int deptNumber, String sex, String phone, String address) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		String query = null;
		
		// 학생 객체
		StudentDto student = null;
		
		// 성공값 1:성공, 0: 실패
		int run = 0;
		
		try {
			// 커넥션 객체 가져오기
			conn = dataSource.getConnection();
			
			// 쿼리문
			query = "update student set id = ?, pw = ?, StudentID = ?, StudentName = ?, MajorNumber = ?, DeptNumber = ?, Sex = ?, Phone = ?, Address = ? where id = ?";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setString(1, id);
			preStatement.setString(2, pw);
			preStatement.setInt(3, studentId);
			preStatement.setString(4, studentName);
			preStatement.setInt(5, majorNumber);
			preStatement.setInt(6, deptNumber);
			preStatement.setString(7, sex);
			preStatement.setString(8, phone);
			preStatement.setString(9, address);
			preStatement.setString(10, id);
			
			// 쿼리문 실행
			run = preStatement.executeUpdate();
			System.out.println("Student Modifiy 성공");
			
			// 수정된 학생 객체
			if (run == 1) {
				student = new StudentDto(id, pw, studentId, studentName, MajorUtil.majorNumToName(majorNumber), DeptUtil.deptNumToName(deptNumber), sex, phone, address);	
			}
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Student Modify 실패");
			
		} finally {
			// 커넥션 객체 닫기
			try {
				if (preStatement != null) { preStatement.close(); }
				if (conn != null) { conn.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return student;
	}
	
	// 학생 회원 탈퇴 로직
	// 반환: 성공값 / 매개변수: 학생 아이디, 비밀번호 정보
	public int deleteStudent(String id, String pw) {
		
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
			query = "delete from student where id = ? and pw = ?";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setString(1, id);
			preStatement.setString(2, pw);

			// 쿼리문 실행
			run = preStatement.executeUpdate();
			System.out.println("Student Delete 성공");
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Student Delete 실패");
			
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
	
	// 학생 검색 로직
	// 반환: 학생 정보 / 매개변수: 학생 회원 정보
	public ArrayList<StudentDto> searchStudent(String type, String keyword) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		ResultSet resultSet = null;
		String query = null;
		
		// 학생 리스트 객체, 학생 객체
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		StudentDto student = null;
		
		try {
			// 커넥션 객체 가져오기
			conn = dataSource.getConnection();
			
			// 검색 타입에 따른 쿼리문
			if (type.equals("id")) {
				
			} else if (type.equals("studentId")) {
				
			} else if (type.equals("studentName")) {
				
			} else if (type.equals("major")) {
				
			} else if (type.equals("department")) {
				
			}
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);

			// 쿼리문 실행
			resultSet = preStatement.executeQuery(query);
			System.out.println("Student Search 성공");
			
			// 학생 정보를 DB에서 가져옴
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				
				int studentId = Integer.parseInt(resultSet.getString("StudentID"));
				String studentName = resultSet.getString("StudentName");
				
				String major = resultSet.getString("Major");
				String dept = resultSet.getString("Dept");
				
				String sex = resultSet.getString("Sex");
				String phone = resultSet.getString("Phone");
				String address = resultSet.getString("Address");
				
				// 학생 객체를 만들어서 리스트에 넣어줌
				student = new StudentDto(id, pw, studentId, studentName, major, dept, sex, phone, address);
				dtos.add(student);
				
			}
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Student Search 실패");
			
		} finally {
			// 커넥션 객체 닫기
			try {
				if (preStatement != null) { preStatement.close(); }
				if (conn != null) { conn.close(); }
				if (resultSet != null) { resultSet.close(); }
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	// 학생 리스트 로직
	// 반환: 학생 정보 리스트 / 매개변수: 없음
	public ArrayList<StudentDto> listStudent() {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		ResultSet resultSet = null;
		String query = null;
		
		// 학생 리스트 객체, 학생 객체
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		StudentDto student = null;
		
		try {
			// 커넥션 객체 가져오기
			conn = dataSource.getConnection();
			
			// 쿼리문
			query = "select * from student";
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// 쿼리문 실행
			resultSet = preStatement.executeQuery(query);
			
			
			// 학생 정보를 DB에서 가져옴
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				
				int studentId = Integer.parseInt(resultSet.getString("StudentID"));
				String studentName = resultSet.getString("StudentName");
				
				String major = resultSet.getString("Major");
				String dept = resultSet.getString("Dept");
				
				String sex = resultSet.getString("Sex");
				String phone = resultSet.getString("Phone");
				String address = resultSet.getString("Address");
				
				// 학생 객체를 만들어서 리스트에 넣어줌
				student = new StudentDto(id, pw, studentId, studentName, major, dept, sex, phone, address);
				dtos.add(student);
				
			}
			
			System.out.println("Student List 성공");
		
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			System.out.println("Student List 실패");
			
		} finally {
			// 커넥션 객체 닫기
			try {
				if (preStatement != null) { preStatement.close(); }
				if (conn != null) { conn.close(); }
				if (resultSet != null) { resultSet.close(); }
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}
	
}
