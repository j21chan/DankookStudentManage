package com.dankook.EGINE_MANAGE.Command.StudentCommand;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.StudentDao;

public class StudentDeleteCommand implements StudentCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		StudentDao dao = new StudentDao();
		
		int run = dao.deleteStudent(id, pw);
		
		if (run == 1) {
			// 회원 탈퇴 성공
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("studentDelete", "delete");
		}
		
	}
}
