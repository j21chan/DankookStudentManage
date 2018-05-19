package com.dankook.EGINE_MANAGE.Dto;

public class StudentDto {
	private String id;
	private String pw;
	
	private int studentId;
	private String studentName;
	
	private String major;
	private String dept;
	
	private String sex;
	private String phone;
	private String address;
	
	// 디폴트 생성자
	public StudentDto() {
		
	}

	// 필드값을 이용한 생성자
	public StudentDto(String id, String pw, int studentId, String studentName, String major, String dept, String sex,
			String phone, String address) {
		this.id = id;
		this.pw = pw;
		this.studentId = studentId;
		this.studentName = studentName;
		this.major = major;
		this.dept = dept;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
	}

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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
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
