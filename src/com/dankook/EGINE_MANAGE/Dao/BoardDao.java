package com.dankook.EGINE_MANAGE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
	public int writeBoard(String bId, String bTitle, String bContent) {
		
		System.out.println(bId);
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		String query = null;
		
		// 성공값 1:성공, 0: 실패
		int run = 0;
		
		// 쿼리문
		// 1. 게시판 쓰기
		query = "insert into all_board (bId, bTitle, bContent) values (?, ?, ?)";
		
		try {
			
			// 커넥션 객체 가져오기
			conn = dataSource.getConnection();
	
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setString(1, bId);
			preStatement.setString(2, bTitle);
			preStatement.setString(3, bContent);
			
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
	public int deleteBoard(int bNumber) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		String query = null;

		// 성공값 1:성공, 0: 실패
		int run = 0;
		
		// 쿼리문
		query = "delete from all_board where bNumber = ?";
		
		try {
			conn = dataSource.getConnection();
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setInt(1, bNumber);
			
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
	
	// 게시글 수정 로직
	// 반환: 성공값 / 매개변수: 게시글 컨텐츠
	public int modifyBoard(int bNumber, String bTitle, String bContent) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		String query = null;

		// 성공값 1:성공, 0: 실패
		int run = 0;
		
		// 쿼리문
		query = "update all_board set bTitle = ?, bContent = ? where bNumber = ?";
		
		try {
			conn = dataSource.getConnection();
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setString(1, bTitle);
			preStatement.setString(2, bContent);
			preStatement.setInt(3, bNumber);
			
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
	
	// 게시글 내용 보기 로직
	// 반환: 게시글 내용 / 매개변수: 게시글 번호
	public BoardDto viewBoard(int bNumber) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		ResultSet resultSet = null;
		String query = null;
		BoardDto dto = null;
		
		// *** 게시글 보기 로직 ***
		// 쿼리문
		query = "select * from all_board where bNumber = ?";
		
		try {
			conn = dataSource.getConnection();
			
			// 쿼리 커밋 시작 => 트랜잭션 처리
			if (conn.getAutoCommit()) {
				conn.setAutoCommit(false);
			}
			
			// *** 히트수 업데이트 ***
			upHit(bNumber);

			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// prepared Statement 쿼리문 만들기
			preStatement.setInt(1, bNumber);
			
			// 쿼리문 실행
			resultSet = preStatement.executeQuery();
			
			// 게시판 데이터 가져오기
			if(resultSet.next()) {
				int bNumberTemp = resultSet.getInt("bNumber");
				String bId = resultSet.getString("bId");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				
				dto = new BoardDto(bNumberTemp, bId, bTitle, bContent, bDate, bHit);
			}
			
		} catch (Exception e) {
			
			// 쿼리 롤백
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch(Exception e2) {
				e2.printStackTrace();
			}
			
			// 쿼리 에러 출력
			e.printStackTrace();
		} finally {
			
			// 쿼리 커밋
			try {
				if(conn != null && !conn.getAutoCommit()) { 
				    conn.commit();
				    conn.setAutoCommit(true);
				   }
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
			
			// 커넥션 객체 닫기
			try {
				if(preStatement != null) { preStatement.close(); }
				if(conn != null) { conn.close(); }
				if(resultSet != null) { resultSet.close(); }
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
		ResultSet resultSet = null;
		String query = null;

		// 게시글 리스트
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		// 쿼리문
		query = "select * from all_board order by bNumber";
		
		try {
			conn = dataSource.getConnection();
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);

			// 쿼리문 실행
			resultSet = preStatement.executeQuery();
			
			// 게시판 데이터 가져오기
			while(resultSet.next()) {
				int bNumberTemp = resultSet.getInt("bNumber");
				String bId = resultSet.getString("bId");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				
				BoardDto board = new BoardDto(bNumberTemp, bId, bTitle, bContent, bDate, bHit);
				
				dtos.add(board);
			}
			
		} catch (Exception e) {
			
			// 쿼리 에러
			e.printStackTrace();
			
		} finally {
			
			// 커넥션 객체 닫기
			try {
				if(preStatement != null) { preStatement.close(); }
				if(conn != null) { conn.close(); }
				if(resultSet != null) { resultSet.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return dtos;
	}
	
	// 게시글 리스트 출력 로직
	// 반환: 검색 게시글 리스트 / 매개변수: type, keyword
	public ArrayList<BoardDto> searchBoard(String type, String keyword) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement = null;
		Connection conn = null;
		ResultSet resultSet = null;
		String query = null;

		// 게시글 리스트
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		// 쿼리문
		query = "select *\r\n" + 
				"from all_board\r\n" + 
				"where " + type + " like ?";
		
		try {
			conn = dataSource.getConnection();
			
			// prepared Statement에 쿼리문 넣기
			preStatement = conn.prepareStatement(query);
			
			// preStatement 완성하기
			preStatement.setString(1, "%" + keyword + "%");
			
			// 쿼리문 실행
			resultSet = preStatement.executeQuery();
			
			// 게시판 데이터 가져오기
			while(resultSet.next()) {
				int bNumberTemp = resultSet.getInt("bNumber");
				String bId = resultSet.getString("bId");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				
				BoardDto board = new BoardDto(bNumberTemp, bId, bTitle, bContent, bDate, bHit);
				
				dtos.add(board);
			}
			
		} catch (Exception e) {
			
			// 쿼리 에러
			e.printStackTrace();
			
		} finally {
			
			// 커넥션 객체 닫기
			try {
				if(preStatement != null) { preStatement.close(); }
				if(conn != null) { conn.close(); }
				if(resultSet != null) { resultSet.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return dtos;
	}
	
	private void upHit(int bNumber) {
		
		// 쿼리문, 연결 객체
		PreparedStatement preStatement1 = null;
		PreparedStatement preStatement2 = null;
		Connection conn = null;
		ResultSet resultSet = null;
		String query1 = null;
		String query2 = null;
		int bHit = 0;
		int run = 0;
		
		// 쿼리문
		query1 = "select bHit from all_board where bNumber = ?";
		query2 = "update all_board set bHit = ? where bNumber = ?";
		
		try {
			conn = dataSource.getConnection();
			
			// **** 히트수 가져오는 로직 ****
			// prepared Statement에 쿼리문 넣기
			preStatement1 = conn.prepareStatement(query1);
			
			// prepared Statement 쿼리문 만들기
			preStatement1.setInt(1, bNumber);
			
			// 쿼리문 실행
			resultSet = preStatement1.executeQuery();
			
			// 히트수 데이터 가져오기
			if(resultSet.next()) {
				bHit = resultSet.getInt("bHit");
				bHit++;
			}
			
			// **** 히트수 업데이트 로직 ****
			// prepared Statement에 쿼리문 넣기
			preStatement2 = conn.prepareStatement(query2);
			
			// prepared Statement 쿼리문 만들기
			preStatement2.setInt(1, bHit);
			preStatement2.setInt(2, bNumber);
			
			run = preStatement2.executeUpdate();
			
		} catch (Exception e) {
			// 쿼리 에러
			e.printStackTrace();
		} finally {
			// 커넥션 객체 닫기
			try {
				if(preStatement1 != null) { preStatement1.close(); }
				if(preStatement2 != null) { preStatement2.close(); }
				if(conn != null) { conn.close(); }
				if(resultSet != null) { resultSet.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return;
	}
}
