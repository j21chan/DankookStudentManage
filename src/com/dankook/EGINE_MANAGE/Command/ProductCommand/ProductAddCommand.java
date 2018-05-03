package com.dankook.EGINE_MANAGE.Command.ProductCommand;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.ProductDao;

public class ProductAddCommand implements ProductCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 물품 이름을 가져옴
		String productName = request.getParameter("productName");
		
		// 물품 DAO 객체 생성 후 물품 추가 로직 실행
		ProductDao dao = new ProductDao();
		int run = dao.addProduct(productName);
		
		// 물품 추가 성공
		if(run == 1) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("ProductAdd", "add sucess");
		}
	}
}