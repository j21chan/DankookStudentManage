package com.dankook.EGINE_MANAGE.Uility;

//전공에 대한 열거형
public enum Major {
	electronic(1), 		// 전자전기공학과
	polymer(2), 		// 고분자공학과
	fiber(3), 			// 파이버공학과
	software(4),		// 소프트웨어학과
	appliedComputer(5), // 응용컴퓨터공학과
	civil(6),			// 토목환경공학과
	mechanic(7),		// 기계공학과
	chemistry(8);		// 화학공학과
	
	// 전공 번호
	private int majorNumber;
	
	// 번호에 따라서 enum 만들어주기
	public static Major majorNum(int num) {
		switch(num) {
		case 1:
			return electronic;
		case 2:
			return polymer;
		case 3:
			return fiber;
		case 4:
			return software;
		case 5:
			return appliedComputer;
		case 6:
			return civil;
		case 7:
			return mechanic;
		case 8:
			return chemistry;
		}
		
		return null;
	}
	
	// enum에 따른 한글 전공명 반환
	public static String majorNumToName(Major majorEnum) {
		switch(majorEnum) {
		case electronic:
			return "전자전기공학과";
		case polymer:
			return "고분자공학과";
		case fiber:
			return "파이버공학과";
		case software:
			return "소프트웨어학과";
		case appliedComputer:
			return "응용컴퓨터공학과";
		case civil:
			return "토목환경공학과";
		case mechanic:
			return "기계공학과";
		case chemistry:
			return "화학공학과";
		}
		return null;
	}
	
	// 전공 번호를 이용한 생성자
	Major(int majorNumber) {
		this.majorNumber = majorNumber;
	}
	
	public int getMajorNumber() {
		return this.majorNumber;
	}
}