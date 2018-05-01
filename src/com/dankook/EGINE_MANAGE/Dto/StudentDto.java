package com.dankook.EGINE_MANAGE.Dto;

import com.dankook.EGINE_MANAGE.Uility.Major;
import com.dankook.EGINE_MANAGE.Uility.Department;

public class StudentDto {
	private String id;
	private String pw;
	
	private int studentId;
	private String studentName;
	
	private Major majorNumber;
	private Department deptNumber;
	
	private String sex;
	private String phone;
	private String address;
	
	// 디폴트 생성자
	public StudentDto() {
		
	}
	
	// 모든 파라매터 이용한 생성자
	public StudentDto(String id, String pw, int studentId, String studentName, Major majorNumber, Department deptNumber,
					  String sex, String phone, String address) {
		this.id = id;
		this.pw = pw;
		this.studentId = studentId;
		this.studentName = studentName;
		this.majorNumber = majorNumber;
		this.deptNumber = deptNumber;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
	}
	
	// Getter and Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Major getMajorNumber() {
		return majorNumber;
	}

	public void setMajorNumber(Major majorNumber) {
		this.majorNumber = majorNumber;
	}

	public Department getDeptNumber() {
		return deptNumber;
	}

	public void setDeptNumber(Department deptNumber) {
		this.deptNumber = deptNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
