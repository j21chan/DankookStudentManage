package com.dankook.EGINE_MANAGE.Command.ProductCommand;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.ProductDao;
import com.dankook.EGINE_MANAGE.Dto.ProductDto;

public class ProductListCommand implements ProductCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 물품 DAO 객체 생성 후 물품 리스트 로직 실행
		ProductDao dao = new ProductDao();
		ArrayList<ProductDto> dtos = dao.listProduct();
		
		// 물품 검색 성공
		if(dtos != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("ProductSearch", dtos);
		}
		
	}

}
