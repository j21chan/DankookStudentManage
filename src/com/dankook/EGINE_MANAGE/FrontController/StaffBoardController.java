package com.dankook.EGINE_MANAGE.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dankook.EGINE_MANAGE.Command.StaffBoardCommand.StaffBoardCommand;
import com.dankook.EGINE_MANAGE.Command.StaffBoardCommand.StaffBoardDeleteCommand;
import com.dankook.EGINE_MANAGE.Command.StaffBoardCommand.StaffBoardListCommand;
import com.dankook.EGINE_MANAGE.Command.StaffBoardCommand.StaffBoardModifyCommand;
import com.dankook.EGINE_MANAGE.Command.StaffBoardCommand.StaffBoardSearchCommand;
import com.dankook.EGINE_MANAGE.Command.StaffBoardCommand.StaffBoardViewCommand;
import com.dankook.EGINE_MANAGE.Command.StaffBoardCommand.StaffBoardWriteCommand;

/*
 * 공대 학생회 게시판 FrontController
 * 
 * *** 실행 순서 ***
 * => http://localhost:8080/EGINE_MANAGE/staffBoard/[사용자 요청 로직]
 * => actionDo 호출
 * => 로직 수행
 * => 다음 페이지 foward
 */

@WebServlet("/staffBoard/*")
public class StaffBoardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public StaffBoardController() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Staff Board Controller doGet");
	    actionDo(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Staff Board Controller doPost");
		actionDo(request, response);
		
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Staff Board actionDo");
		
		// request 캐릭터 인코딩을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 요청인지 알기 위해서 URI를 얻어온다
		String viewPage = null;
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		// 로직을 수행할 BoardCommand 객체
		StaffBoardCommand command = null;
		
		
		/*
		 * View Page Request
		 */
		
		// 게시판 쓰기 화면으로 이동
		if(com.equals("/staffBoard/writeView")) {
			viewPage = "/views/STAFF-BOARD/boardWrite.jsp";
		
		// 게시판 수정 화면으로 이동 
		} else if(com.equals("/staffBoard/modifyView")) {
			viewPage = "/views/STAFF-BOARD/boardModify.jsp";
		}
		
		/*
		 * Logic Request
		 */
		
		// 게시판 쓰기 로직 => 게시판 전체 리스트
		if(com.equals("/staffBoard/write")) {
			command = new StaffBoardWriteCommand();
			command.execute(request, response);
			viewPage = "/views/STAFF-BOARD/boardList.jsp";
			
		// 게시판 삭제 로직  => 게시판 전체 리스트
		} else if(com.equals("/staffBoard/delete")) {
			command = new StaffBoardDeleteCommand();
			command.execute(request, response);
			viewPage = "/views/STAFF-BOARD/boardDeleteOk.jsp";
			
		// 게시판 수정 로직  => 게시판 전체 리스트
		} else if(com.equals("/staffBoard/modify")) {
			command = new StaffBoardModifyCommand();
			command.execute(request, response);
			viewPage = "/views/STAFF-BOARD/boardModifyOk.jsp";
			
		// 게시판 내용 보기 로직  => 게시판 보기
		} else if(com.equals("/staffBoard/view")) {
			command = new StaffBoardViewCommand();
			command.execute(request, response);
			viewPage = "/views/STAFF-BOARD/boardView.jsp";
		
		// 게시판 리스트 로직  => 게시판 전체 리스트
		} else if(com.equals("/staffBoard/list")) {
			command = new StaffBoardListCommand();
			command.execute(request, response);
			viewPage = "/views/STAFF-BOARD/boardList.jsp";
		
		// 게시판 검색 로직
		} else if(com.equals("/staffBoard/search")) {
			command = new StaffBoardSearchCommand();
			command.execute(request, response);
			viewPage = "/views/STAFF-BOARD/boardList.jsp";
		}
		
		
		// 로직 수행 후 viewPage에 맞게 forward 시켜준다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
