package com.dankook.EGINE_MANAGE.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dankook.EGINE_MANAGE.Command.BoardCommand.BoardCommand;
import com.dankook.EGINE_MANAGE.Command.BoardCommand.BoardDeleteCommand;
import com.dankook.EGINE_MANAGE.Command.BoardCommand.BoardListCommand;
import com.dankook.EGINE_MANAGE.Command.BoardCommand.BoardModifyCommand;
import com.dankook.EGINE_MANAGE.Command.BoardCommand.BoardSearchCommand;
import com.dankook.EGINE_MANAGE.Command.BoardCommand.BoardViewCommand;
import com.dankook.EGINE_MANAGE.Command.BoardCommand.BoardWriteCommand;


/*
 * 자유 게시판 FrontController
 * 
 * *** 실행 순서 ***
 * => http://localhost:8080/board/[사용자 요청 로직]
 * => actionDo 호출
 * => 로직 수행
 * => 다음 페이지 foward
 */


@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Board Controller doGet");
	    actionDo(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Board Controller doPost");
		actionDo(request, response);
		
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Board actionDo");
		
		// request 캐릭터 인코딩을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 요청인지 알기 위해서 URI를 얻어온다
		String viewPage = null;
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		// 로직을 수행할 BoardCommand 객체
		BoardCommand command = null;
		
		
		/*
		 * View Page Request
		 */
		
		if(com.equals("")) {
			viewPage = "";
		}

		
		/*
		 * Logic Request
		 */
		
		// 게시판 쓰기 로직
		if(com.equals("/board/write")) {
			command = new BoardWriteCommand();
			command.execute(request, response);
			viewPage = "/views/BOARD/boardWrite.jsp";
			
		// 게시판 삭제 로직
		} else if(com.equals("/board/delete")) {
			command = new BoardDeleteCommand();
			command.execute(request, response);
			viewPage = "/views/BOARD/boardDelete.jsp";
			
		// 게시판 수정 로직
		} else if(com.equals("/board/modify")) {
			command = new BoardModifyCommand();
			command.execute(request, response);
			viewPage = "/views/BOARD/boardModify.jsp";
			
		// 게시판 내용 보기 로직
		} else if(com.equals("/board/view")) {
			command = new BoardViewCommand();
			command.execute(request, response);
			viewPage = "/views/BOARD/boardView.jsp";
		
		// 게시판 리스트 로직
		} else if(com.equals("/board/list")) {
			command = new BoardListCommand();
			command.execute(request, response);
			viewPage = "/views/BOARD/boardList.jsp";
		
		// 게시판 검색 로직
		} else if(com.equals("/board/search")) {
			command = new BoardSearchCommand();
			command.execute(request, response);
			viewPage = "/views/BOARD/boardList.jsp";
		}
		
		
		// 로직 수행 후 viewPage에 맞게 foward 시켜준다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
