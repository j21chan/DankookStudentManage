package com.dankook.EGINE_MANAGE.Command.ProductCommand;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.ProductDao;

public class ProductDeleteCommand implements ProductCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 물품 번호를 가져옴
		int productNumber = Integer.parseInt(request.getParameter("productNumber"));
		
		// 물품 DAO 객체 생성 후 물품 삭제 로직 실행
		ProductDao dao = new ProductDao();
		int run = dao.deleteProduct(productNumber);
		
		// 물품 삭제 성공
		if(run == 1) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("ProductDelete", "delete sucess");
		}
	}
}
