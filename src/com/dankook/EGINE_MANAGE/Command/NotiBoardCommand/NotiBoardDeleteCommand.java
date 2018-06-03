package com.dankook.EGINE_MANAGE.Command.NotiBoardCommand;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.NotiBoardDao;

public class NotiBoardDeleteCommand implements NotiBoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 각 파라매터 정보 가져오기
		int bNumber = Integer.parseInt(request.getParameter("bNumber"));
		
		// 게시판 Dao 객체 생성
		NotiBoardDao dao = new NotiBoardDao();
		
		// 게시판 쓰기 로직 실행
		int run = dao.deleteBoard(bNumber);
		
		if (run == 1) {
			// 게시판 삭제 성공
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("notiBoardDelete", "notiBoardDelete");
		}
	}
}
