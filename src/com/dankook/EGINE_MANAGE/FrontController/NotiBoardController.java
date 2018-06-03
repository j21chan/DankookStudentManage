package com.dankook.EGINE_MANAGE.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dankook.EGINE_MANAGE.Command.NotiBoardCommand.NotiBoardCommand;
import com.dankook.EGINE_MANAGE.Command.NotiBoardCommand.NotiBoardDeleteCommand;
import com.dankook.EGINE_MANAGE.Command.NotiBoardCommand.NotiBoardListCommand;
import com.dankook.EGINE_MANAGE.Command.NotiBoardCommand.NotiBoardModifyCommand;
import com.dankook.EGINE_MANAGE.Command.NotiBoardCommand.NotiBoardSearchCommand;
import com.dankook.EGINE_MANAGE.Command.NotiBoardCommand.NotiBoardViewCommand;
import com.dankook.EGINE_MANAGE.Command.NotiBoardCommand.NotiBoardWriteCommand;

/*
 * 공지 게시판 FrontController
 * 
 * *** 실행 순서 ***
 * => http://localhost:8080/EGINE_MANAGE/board/[사용자 요청 로직]
 * => actionDo 호출
 * => 로직 수행
 * => 다음 페이지 foward
 */

@WebServlet("/notiBoard/*")
public class NotiBoardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public NotiBoardController() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("NotiBoard Controller doGet");
	    actionDo(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("NotiBoard Controller doPost");
		actionDo(request, response);
		
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("NotiBoard actionDo");
		
		// request 캐릭터 인코딩을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 요청인지 알기 위해서 URI를 얻어온다
		String viewPage = null;
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		// 로직을 수행할 BoardCommand 객체
		NotiBoardCommand command = null;
		
		
		/*
		 * View Page Request
		 */
		
		// 게시판 쓰기 화면으로 이동
		if(com.equals("/notiBoard/writeView")) {
			viewPage = "/views/NOTI-BOARD/boardWrite.jsp";
		
		// 게시판 수정 화면으로 이동 
		} else if(com.equals("/notiBoard/modifyView")) {
			viewPage = "/views/NOTI-BOARD/boardModify.jsp";
		}
		
		/*
		 * Logic Request
		 */
		
		// 게시판 쓰기 로직 => 게시판 전체 리스트
		if(com.equals("/notiBoard/write")) {
			command = new NotiBoardWriteCommand();
			command.execute(request, response);
			viewPage = "/views/NOTI-BOARD/boardList.jsp";
			
		// 게시판 삭제 로직  => 게시판 전체 리스트
		} else if(com.equals("/notiBoard/delete")) {
			command = new NotiBoardDeleteCommand();
			command.execute(request, response);
			viewPage = "/views/NOTI-BOARD/boardList.jsp";
			
		// 게시판 수정 로직  => 게시판 전체 리스트
		} else if(com.equals("/notiBoard/modify")) {
			command = new NotiBoardModifyCommand();
			command.execute(request, response);
			viewPage = "/views/NOTI-BOARD/boardList.jsp";
			
		// 게시판 내용 보기 로직  => 게시판 보기
		} else if(com.equals("/notiBoard/view")) {
			command = new NotiBoardViewCommand();
			command.execute(request, response);
			viewPage = "/views/NOTI-BOARD/boardView.jsp";
		
		// 게시판 리스트 로직  => 게시판 전체 리스트
		} else if(com.equals("/notiBoard/list")) {
			command = new NotiBoardListCommand();
			command.execute(request, response);
			viewPage = "/views/NOTI-BOARD/boardList.jsp";
		
		// 게시판 검색 로직
		} else if(com.equals("/notiBoard/search")) {
			command = new NotiBoardSearchCommand();
			command.execute(request, response);
			viewPage = "/views/NOTI-BOARD/boardList.jsp";
		}
		
		
		// 로직 수행 후 viewPage에 맞게 forward 시켜준다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
