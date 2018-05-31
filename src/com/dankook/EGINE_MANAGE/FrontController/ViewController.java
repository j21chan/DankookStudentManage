package com.dankook.EGINE_MANAGE.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 학생회 학생 관리 FrontController
 * 
 * *** 실행 순서 ***
 * => http://localhost:8080/staff/[사용자 요청 로직]
 * => actionDo 호출
 * => 로직 수행
 * => 다음 페이지 foward
 */


@WebServlet("/view/*")
public class ViewController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ViewController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Staff Controller doGet");
	    actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Staff Controller doPost");
		actionDo(request, response);
	}
	
private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Staff actionDo");
		
		// request 캐릭터 인코딩을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 요청인지 알기 위해서 URI를 얻어온다
		String viewPage = null;
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		// 로직을 수행할 StudentCommand 객체
//		StudentCommand command = null;

		
		/*
		 * View Page Request
		 */
		
		// 메인페이지 = 로그아웃 상태
		if(com.equals("/view/main")) {
			viewPage = "/views/MAIN/main.jsp";
		
		// 비회원 에러페이지
		} else if(com.equals("/view/nonErrorPage")) {
			viewPage = "/views/MENU/menuNonFail.jsp";
		
		// 회원 (일반학생) 에러페이지
		} else if(com.equals("/view/studentErrorPage")) {
			viewPage = "/views/MENU/menuFail.jsp";
			
		// 에러페이지
		} else if(com.equals("/view/MAIN/errorPage")) {
			viewPage = "/views/MAIN/errorPage.jsp";
		}
			
		// 로직 수행 후 viewPage에 맞게 foward 시켜준다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
