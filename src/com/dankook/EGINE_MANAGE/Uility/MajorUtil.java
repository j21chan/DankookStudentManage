package com.dankook.EGINE_MANAGE.Uility;

public class MajorUtil {
	public static String majorNumToName(int num) {
		switch(num) {
		case 1:
			return "전자전기공학과";
		case 2:
			return "고분자공학과";
		case 3:
			return "파이버공학과";
		case 4:
			return "소프트웨어학과";
		case 5:
			return "응용컴퓨터공학과";
		case 6:
			return "토목환경공학과";
		case 7:
			return "기계공학과";
		case 8:
			return "화학공학과";
		}
		return null;
	}
}
