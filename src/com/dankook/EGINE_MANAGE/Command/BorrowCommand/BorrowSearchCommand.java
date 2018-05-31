package com.dankook.EGINE_MANAGE.Command.BorrowCommand;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.BorrowDao;
import com.dankook.EGINE_MANAGE.Dto.BorrowDto;

public class BorrowSearchCommand implements BorrowCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 검색 종류, 검색 키워드 가져오기
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		
		// 검색된 대여 객체를 담기 위한 dtos
		ArrayList<BorrowDto> dtos = new ArrayList<BorrowDto>();
		
		// 대여 DAO 객체 생성 후 대여 검색 로직 실행
		BorrowDao dao = new BorrowDao();
		dtos = dao.searchBorrow(type, keyword);
		
		// 대여 검색에 성공하면 세션에 값 저장
		if(dtos != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("borrowList", dtos);
		}
	}
}
