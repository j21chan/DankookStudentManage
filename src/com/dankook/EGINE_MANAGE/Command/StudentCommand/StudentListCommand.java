package com.dankook.EGINE_MANAGE.Command.StudentCommand;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.StudentDao;
import com.dankook.EGINE_MANAGE.Dto.StudentDto;

public class StudentListCommand implements StudentCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// UTF-8 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 학생 객체 생성
		StudentDao dao = new StudentDao();
		
		// 학생 DAO를 이용해서 전체 학생 정보 가져오기
		ArrayList<StudentDto> dtos = dao.listStudent();
		
		if (dtos != null) {
			// 학생 리스트 가져오기 성공
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("studentList", dtos);
		}
	}

}
