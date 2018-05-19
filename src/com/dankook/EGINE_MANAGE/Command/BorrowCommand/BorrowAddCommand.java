package com.dankook.EGINE_MANAGE.Command.BorrowCommand;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.BorrowDao;

public class BorrowAddCommand implements BorrowCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 대여 정보 가져옴
		String staffId = request.getParameter("staffId");
		String studentId = request.getParameter("studentId");
		int productNumber = Integer.parseInt(request.getParameter("productNumber"));
		int productIndex = Integer.parseInt(request.getParameter("productIndex"));
		
		// 대여 객체 생성 후에 대여 신청 로직 실행
		BorrowDao dao = new BorrowDao();
		int run = dao.addBorrow(staffId, studentId, productNumber, productIndex);
		
		// 세션 객체 생성
		HttpSession httpSession = request.getSession();
		
		if(run == 1) {
			// 물품 대여 성공
			httpSession.setAttribute("borrowAdd", "success");
		} else {
			// 물품 대여 실패
			httpSession.setAttribute("borrowAdd", null);
		}
	}
}
