package com.dankook.EGINE_MANAGE.Command.StudentCommand;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.StudentDao;
import com.dankook.EGINE_MANAGE.Dto.StudentDto;

public class StudentLoginCommand implements StudentCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 학생 아이디, 비밀번호 정보 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 학생 DAO 객체 생성 후 로그인 로직 수행
		StudentDao dao = new StudentDao();
		StudentDto dto = dao.loginStudent(id, pw);
		
		if (dto != null) {
			// 로그인 성공
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("StudentInfo", dto);
		}
	}

}
