package com.dankook.EGINE_MANAGE.Command.StudentCommand;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.StudentDao;

public class StudentJoinCommand implements StudentCommand {

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
		
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String studentName = request.getParameter("studentName");
		
		// 전공, 부서는 enum 이용해서 바꿔보기
		int majorNumber = Integer.parseInt(request.getParameter("major"));
		int deptNumber = Integer.parseInt(request.getParameter("depart"));
		
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
	
		// 학생 Dao 객체 생성
		StudentDao dao = new StudentDao();
		
		// 학생 회원가입 로직 실행
		int run = dao.joinStudent(id, pw, studentId, studentName, majorNumber, deptNumber, sex, phone, address);
		
		if (run == 1) {
			// 회원가입 성공
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("join", "join");
		}
	}
}
