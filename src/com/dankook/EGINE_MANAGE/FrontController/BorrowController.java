package com.dankook.EGINE_MANAGE.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dankook.EGINE_MANAGE.Command.BorrowCommand.BorrowAddCommand;
import com.dankook.EGINE_MANAGE.Command.BorrowCommand.BorrowCommand;
import com.dankook.EGINE_MANAGE.Command.BorrowCommand.BorrowDeleteCommand;
import com.dankook.EGINE_MANAGE.Command.BorrowCommand.BorrowListCommand;
import com.dankook.EGINE_MANAGE.Command.BorrowCommand.BorrowSearchCommand;
import com.dankook.EGINE_MANAGE.Command.ProductCommand.ProductCommand;
import com.dankook.EGINE_MANAGE.Command.ProductCommand.ProductListCommand;


/*
 * 대여 관리 FrontController
 * 
 * *** 실행 순서 ***
 * => http://localhost:8080/EGINE_MANAGE/borrow/[사용자 요청 로직]
 * => actionDo 호출
 * => 로직 수행
 * => 다음 페이지 foward
 */


@WebServlet("/borrow/*")
public class BorrowController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public BorrowController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    System.out.println("Borrow Controller doGet");
	    actionDo(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Borrow Controller doPost");
		actionDo(request, response);
	
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Borrow actionDo");
		
		// request 캐릭터 인코딩을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 요청인지 알기 위해서 URI를 얻어온다
		String viewPage = null;
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		// 로직을 수행할 BorrowCommand 객체
		BorrowCommand command = null;
		
		
		/*
		 * View Page Request
		 */
		
		// 대여 신청 페이지 이동
		if(com.equals("/borrow/addView")) {
			ProductCommand pCommand = new ProductListCommand();
			pCommand.execute(request, response);
			viewPage = "/views/BORROW/borrowAdd.jsp";
		}
		
		/*
		 * Logic Request
		 */
		
		// 대여 신청 로직 => 대여 완료 페이지 이동
		if(com.equals("/borrow/add")) {
			command = new BorrowAddCommand();
			command.execute(request, response);
			viewPage = "/views/BORROW/borrowAddOk.jsp";
			 
		// 대여 반납 로직 => 반납 완료 페이지 이동
		} else if(com.equals("/borrow/delete")) {
			command = new BorrowDeleteCommand();
			command.execute(request, response);
			viewPage = "/views/BORROW/borrowDeleteOk.jsp";
			
		// 대여 리스트 로직 => 대여 리스트 페이지
		} else if(com.equals("/borrow/list")) {
			command = new BorrowListCommand();
			command.execute(request, response);
			viewPage = "/views/BORROW/borrowList.jsp";
			
		// 대여 검색 로직 => 대여 리스트 페이지
		} else if(com.equals("/borrow/search")) {
			command = new BorrowSearchCommand();
			command.execute(request, response);
			viewPage = "/views/BORROW/borrowList.jsp";
		}
		
		
		// 로직 수행 후 viewPage에 맞게 forward 시켜준다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
}
