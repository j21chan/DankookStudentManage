package com.dankook.EGINE_MANAGE.Command.BoardCommand;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.BoardDao;

public class BoardWriteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 각 파라매터 정보 가져오기
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		// 게시판 Dao 객체 생성
		BoardDao dao = new BoardDao();
		
		// 게시판 쓰기 로직 실행
		int run = dao.writeBoard(bId, bTitle, bContent); 
		
		if (run == 1) {
			// 게시판 쓰기 성공
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("boardWrite", "boardWrite");
		}
	}
}