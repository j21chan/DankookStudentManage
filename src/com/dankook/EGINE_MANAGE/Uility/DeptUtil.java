package com.dankook.EGINE_MANAGE.Uility;

public class DeptUtil {
	// 부서 번호에 따른 부서 명 반환
	public static String deptNumToName(int num) {
		switch(num) {
		case 0:
			return "일반학생";
		case 1:
			return "신입생";
		case 2:
			return "기획부";
		case 3:
			return "연대사업부";
		case 4:
			return "운영부";
		case 5:
			return "홍보부";
		case 6:
			return "회장부회장";
		}
		return null;
	}
}