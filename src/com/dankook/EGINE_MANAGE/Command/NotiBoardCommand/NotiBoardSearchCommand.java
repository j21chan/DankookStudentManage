package com.dankook.EGINE_MANAGE.Command.NotiBoardCommand;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.NotiBoardDao;
import com.dankook.EGINE_MANAGE.Dto.BoardDto;

public class NotiBoardSearchCommand implements NotiBoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 각 파라매터 정보 가져오기
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		
		// 게시판 Dao 객체 생성
		NotiBoardDao dao = new NotiBoardDao();
		
		// 게시판 검색 로직 실행
		ArrayList<BoardDto> dtos = dao.searchBoard(type, keyword);
		
		if (dtos != null) {
			// 게시판 검색 성공
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("NotiBoardList", dtos);
		}
	}
}
