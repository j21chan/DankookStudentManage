package com.dankook.EGINE_MANAGE.Command.StudentCommand;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.StudentDao;
import com.dankook.EGINE_MANAGE.Dto.StudentDto;

public class StudentModifyCommand implements StudentCommand {

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
	
		// 학생 DAO 객체 생성, 학생 객체에 넣기
		StudentDao dao = new StudentDao();
		StudentDto dto = dao.modifyStudent(id, pw, studentId, studentName, majorNumber, deptNumber, sex, phone, address);
		
		
		if (dto != null) {
			// 학생 회원 정보 수정 성공
			HttpSession httpSession = request.getSession();
			
			// 세션에 있던 기존 학생 정보 삭제
			if (httpSession.getAttribute("StudentInfo") != null) {
				httpSession.removeAttribute("StudentInfo");				
			}
			
			// 새로운 학생 정보를 세션에 등록
			httpSession.setAttribute("StudentInfo", dto);
		}
	}
}
