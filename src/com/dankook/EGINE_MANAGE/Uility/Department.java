package com.dankook.EGINE_MANAGE.Uility;

//부서에 대한 열거형
public enum Department {
	freshman(1),	// 신입생
	planning(2),	// 기획부
	solidarity(3),	// 연대사업부
	operation(4),	// 운영부
	promotion(5),	// 홍보부
	chairman(6);	// 회장 부회장
	
	// 부서 번호
	private int deptNumber;
	
	// 번호에 따른 부서 Enum 생성
	public static Department deptNum(int num) {
		switch(num) {
		case 1:
			return Department.freshman;
		case 2:
			return Department.planning;
		case 3:
			return Department.solidarity;
		case 4:
			return Department.operation;
		case 5:
			return Department.promotion;
		case 6:
			return Department.chairman;
		}
		
		return null;
	}
	
	// 부서 Enum을 받아서 부서명으로 바꿔주는 메소드
	public static String deptNumToName(Department dept) {
		switch(dept) {
		case freshman:
			return "신입생";
		case planning:
			return "기획부";
		case solidarity:
			return "연대사업부";
		case operation:
			return "운영부";
		case promotion:
			return "홍보부";
		case chairman:
			return "회장부회장";
		}
		return null;
	}
	
	// 부서 번호를 이용한 생성자
	Department(int deptNumber) {
		this.deptNumber = deptNumber;
	}
	
	public int getDeptNumber() {
		return this.deptNumber;
	}
}