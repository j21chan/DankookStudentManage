package com.dankook.EGINE_MANAGE.Command.StaffBoardCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.StaffBoardDao;
import com.dankook.EGINE_MANAGE.Dto.BoardDto;

public class StaffBoardMainListCommand implements StaffBoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		// 게시판 Dao 객체 생성
		StaffBoardDao dao = new StaffBoardDao();
		
		// 게시판 쓰기 로직 실행
		ArrayList<BoardDto> dtos = dao.mainListBoard();
		
		if (dtos != null) {
			// 게시판 리스트 가져오기 성공
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("StaffMainBoardList", dtos);
		}	
	}
}
