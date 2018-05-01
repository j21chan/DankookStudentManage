package com.dankook.EGINE_MANAGE.Command.StudentCommand;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dankook.EGINE_MANAGE.Dao.StudentDao;
import com.dankook.EGINE_MANAGE.Dto.StudentDto;

public class StudentSearchCommand implements StudentCommand {

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
		
		// 검색된 학생 객체를 담기위한 DTOS
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		
		// 학생 DAO 객체 생성 후 학생 검색 로직 실행
		StudentDao dao = new StudentDao();
		dtos = dao.searchStudent(type, keyword);
		
		// 학생 검색에 성공 하면 세션에 값 저장
		if(dtos != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("studentList", dtos);
		}
	}
}
