package com.dankook.EGINE_MANAGE.Command.ProductCommand;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.ProductDao;
import com.dankook.EGINE_MANAGE.Dto.ProductDto;

public class ProductSearchCommand implements ProductCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 물품 이름을 가져옴
		String productName = request.getParameter("search");
		
		// 물품 DAO 객체 생성 후 물품 검색 로직 실행
		ProductDao dao = new ProductDao();
		ArrayList<ProductDto> dtos = dao.searchProduct(productName);
		
		// 물품 검색 성공
		if(dtos != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("ProductList", dtos);
		}
	}
}
