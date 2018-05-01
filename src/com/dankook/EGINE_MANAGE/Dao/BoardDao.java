package com.dankook.EGINE_MANAGE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dankook.EGINE_MANAGE.Dto.BoardDto;

public class BoardDao {
	// DaataSource 가져오는 과정
	DataSource dataSource;
	
	public BoardDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시글 쓰기 로직
	// 반환: 성공값 / 매개변수: 게시글 컨텐츠
	public int writeBoard(int bNumber, String bId, String bTitle, String bContent) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		String query = null;
		
		// 성공값 1:성공, 0: 실패
		int run = 0;
		
		// 쿼리문
		// 1. 게시판 쓰기
		query = "insert into all_board (bNumber, bId, bTitle, bContent) values (?, ?, ?, ?)";
		
		try {
			
			// 커넥션 객체 가져오기
			conn = dataSource.getConnection();
	
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
//			preStatement.setString(1, );
			
			// 쿼리문 실행
			run = preStatement.executeUpdate();
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
			
		} finally {
			// 커넥션 객체 닫기
			try {
				if(preStatement != null) { preStatement.close(); }
				if(conn != null) { conn.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			run = 1;
		}
		
		return run;
	}
	
	// 게시글 삭제 로직
	// 반환: 성공값 / 매개변수: 게시글 번호
	public int deleteBoard() {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		String query = null;

		// 성공값 1:성공, 0: 실패
		int run = 0;
		
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
		} finally {
			// 커넥션 객체 닫기
			try {
				if(preStatement != null) { preStatement.close(); }
				if(conn != null) { conn.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			run = 1;
		}
		
		return run;
	}
	
	// 게시글 수정 로직
	// 반환: 성공값 / 매개변수: 게시글 컨텐츠
	public int modifyBoard() {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		String query = null;

		// 성공값 1:성공, 0: 실패
		int run = 0;
		
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
		} finally {
			// 커넥션 객체 닫기
			try {
				if(preStatement != null) { preStatement.close(); }
				if(conn != null) { conn.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			run = 1;
		}
		
		return run;
	}
	
	// 게시글 내용 보기 로직
	// 반환: 게시글 내용 / 매개변수: 게시글 번호
	public BoardDto vieweBoard() {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		String query = null;

		// 게시글 내용
		BoardDto dto = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
		} finally {
			// 커넥션 객체 닫기
			try {
				if(preStatement != null) { preStatement.close(); }
				if(conn != null) { conn.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	// 게시글 리스트 출력 로직
	// 반환: 게시글 리스트 / 매개변수: 없음
	public ArrayList<BoardDto> listBoard() {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		String query = null;

		// 게시글 내용
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		try {
			
			conn = dataSource.getConnection();
			
		} catch (Exception e) {
			
			// 쿼리 에러
			e.printStackTrace();
			
		} finally {
			
			// 커넥션 객체 닫기
			try {
				if(preStatement != null) { preStatement.close(); }
				if(conn != null) { conn.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return null;
	}
	
}
