package com.dankook.EGINE_MANAGE.Command.BorrowCommand;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.BorrowDao;
import com.dankook.EGINE_MANAGE.Dto.BorrowDto;

public class BorrowListCommand implements BorrowCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 대여 객체 생성 후에 대여 신청 로직 실행
		BorrowDao dao = new BorrowDao();
		ArrayList<BorrowDto> dtos = dao.listBorrow();
		
		// 세션 객체 생성
		HttpSession httpSession = request.getSession();
		
		if(dtos != null) {
			httpSession.setAttribute("borrowList", dtos);
		} else {
			httpSession.setAttribute("borrowList", dtos);
		}
	}
}
