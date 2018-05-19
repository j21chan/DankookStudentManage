package com.dankook.EGINE_MANAGE.Command.BorrowCommand;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.BorrowDao;

public class BorrowDeleteCommand implements BorrowCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 물품 반납 정보 가져옴
		int borrowNumber = Integer.parseInt(request.getParameter("borrowNumber"));
		
		// 대여 객체 생성 후에 반납 로직 실행
		BorrowDao dao = new BorrowDao();
		int run = dao.deleteBorrow(borrowNumber);
		
		// 세션 객체 생성
		HttpSession httpSession = request.getSession();
		
		// 물품 반납 성공
		if(run == 1) {
			httpSession.setAttribute("DeleteBorrow", "success");
		} else {
			httpSession.setAttribute("DeleteBorrow", null);
		}
	}
}
