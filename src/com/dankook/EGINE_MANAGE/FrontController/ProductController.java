package com.dankook.EGINE_MANAGE.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dankook.EGINE_MANAGE.Command.ProductCommand.ProductAddCommand;
import com.dankook.EGINE_MANAGE.Command.ProductCommand.ProductCommand;
import com.dankook.EGINE_MANAGE.Command.ProductCommand.ProductDeleteCommand;
import com.dankook.EGINE_MANAGE.Command.ProductCommand.ProductListCommand;
import com.dankook.EGINE_MANAGE.Command.ProductCommand.ProductSearchCommand;


/*
 * 물품관리 FrontController
 * 
 * *** 실행 순서 ***
 * => http://localhost:8080/EGINE_MANAGE/product/[사용자 요청 로직]
 * => actionDo 호출
 * => 로직 수행
 * => 다음 페이지 foward
 */


@WebServlet("/product/*")
public class ProductController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ProductController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Product Controller doGet");
		actionDo(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Product Controller doPost");
		actionDo(request, response);
	
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Product actionDo");
		
		// request 캐릭터 인코딩을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 요청인지 알기 위해서 URI를 얻어온다
		String viewPage = null;
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		// 로직을 수행할 ProductCommand 객체
		ProductCommand command = null;
		
		
		/*
		 * View Page Request
		 */
		
		if(com.equals("/product/addView")) {
			viewPage = "/views/PRODUCT/productAdd.jsp";
		}
		
		
		/*
		 * Logic Request
		 */
		
		// 물품 추가 로직
		if(com.equals("/product/add")) {
			command = new ProductAddCommand();
			command.execute(request, response);
			viewPage = "/views/PRODUCT/productAddOk.jsp";
			
		// 물품 삭제 로직
		} else if(com.equals("/product/delete")) {
			command = new ProductDeleteCommand();
			command.execute(request, response);
			viewPage = "/views/PRODUCT/productDeleteOk.jsp";
			
		// 물품 리스트 로직
		} else if(com.equals("/product/list")) {
			command = new ProductListCommand();
			command.execute(request, response);
			viewPage = "/views/PRODUCT/productList.jsp";
			
		// 물품 검색 로직
		} else if(com.equals("/product/search")) {
			command = new ProductSearchCommand();
			command.execute(request, response);
			viewPage = "/views/PRODUCT/productList.jsp";
		}
		
		
		// 로직 수행 후 viewPage에 맞게 forward 시켜준다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
