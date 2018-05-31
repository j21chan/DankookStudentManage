package com.dankook.EGINE_MANAGE.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dankook.EGINE_MANAGE.Command.StudentCommand.StudentCommand;
import com.dankook.EGINE_MANAGE.Command.StudentCommand.StudentDeleteCommand;
import com.dankook.EGINE_MANAGE.Command.StudentCommand.StudentJoinCommand;
import com.dankook.EGINE_MANAGE.Command.StudentCommand.StudentListCommand;
import com.dankook.EGINE_MANAGE.Command.StudentCommand.StudentLoginCommand;
import com.dankook.EGINE_MANAGE.Command.StudentCommand.StudentModifyCommand;
import com.dankook.EGINE_MANAGE.Command.StudentCommand.StudentSearchCommand;


/*
 * 학생 관리 FrontController
 * 
 * *** 실행 순서 ***
 * => http://localhost:8080/EGINE_MANAGE/student/[사용자 요청 로직]
 * => actionDo 호출
 * => 로직 수행
 * => 다음 페이지 foward
 */


@WebServlet("/student/*")
public class StudentController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	public StudentController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    System.out.println("Student Controller doGet");
	    actionDo(request, response);
	    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Student Controller doPost");
		actionDo(request, response);
		
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Student actionDo");
		
		// request 캐릭터 인코딩을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 요청인지 알기 위해서 URI를 얻어온다
		String viewPage = null;
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		// 로직을 수행할 StudentCommand 객체
		StudentCommand command = null;

		
		/*
		 * View Page Request
		 */
		
		// 메인 화면
		if(com.equals("/student/main")) {
			viewPage = "/views/MAIN/loginMain.jsp";
			
		// 회원가입 선택 화면
		} else if(com.equals("/student/joinView")) {
			viewPage = "/views/STUDENT/studentSelect.jsp";
		
		// 일반 학생 회원가입 화면
		} else if(com.equals("/student/studentJoinView")) {
			viewPage = "/views/STUDENT/studentJoin.jsp";
		
		// 학생회 학생 회원가입 화면
		} else if(com.equals("/student/staffJoinView")) {
			viewPage = "/views/STUDENT/studentCouncilJoin.jsp";
			
		// 회원 삭제 화면
		} else if(com.equals("/student/deleteView")) {
			viewPage = "/views/STUDENT/studentDelete.jsp";
			
		// 회원 수정 화면
		} else if(com.equals("/student/modifyView")) {
			viewPage = "/views/STUDENT/studentModify.jsp";
		
		// 로그아웃 화면
		} else if(com.equals("/student/logout")) {
			viewPage = "/views/STUDENT/studentLogout.jsp";
		}
		
		
		/*
		 * Logic Request
		 */
		
		// 학생 회원가입 로직
		if(com.equals("/student/join")) {
			command = new StudentJoinCommand();
			command.execute(request, response);
			viewPage = "/views/STUDENT/studentJoinOk.jsp";
		
		// 학생 로그인 로직
		} else if(com.equals("/student/login")) {
			command = new StudentLoginCommand();
			command.execute(request, response);
			viewPage = "/views/MAIN/loginMain.jsp";
			
		// 학생 회원정보 수정 로직
		} else if(com.equals("/student/modify")) {
			command = new StudentModifyCommand();
			command.execute(request, response);
			viewPage = "/views/STUDENT/studentModifyOk.jsp";
		
		// 학생 회원 탈퇴 로직
		} else if(com.equals("/student/delete")) {
			command = new StudentDeleteCommand();
			command.execute(request, response);
			viewPage = "/views/STUDENT/studentDeleteOk.jsp";
		
		// 학생회 학생 검색 로직
		} else if(com.equals("/student/search")) {
			command = new StudentSearchCommand();
			command.execute(request, response);
			viewPage = "/views/STUDENT/studentList.jsp";
		
		// 학생회 학생 회원정보 리스트 로직
		} else if(com.equals("/student/list")) {
			command = new StudentListCommand();
			command.execute(request, response);
			viewPage = "/views/STUDENT/studentList.jsp";
		}
		
		// 로직 수행 후 viewPage에 맞게 forward 시켜준다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
