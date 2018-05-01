package com.dankook.EGINE_MANAGE.Dto;

import java.sql.Timestamp;

public class BorrowDto {
	private int borrowNumber;
	
	private int staffNumber;
	private String staffName;
	private String staffMajor;
	private String staffPhone;
	
	private int studentNumber;
	private String studentName;
	private String studentMajor;
	private String studentPhone;
	
	private int productIndex;
	private String productName;
	
	private Timestamp borrowDate;

	public int getBorrowNumber() {
		return borrowNumber;
	}

	// 생성자
	public BorrowDto(int borrowNumber, int staffNumber, String staffName, String staffMajor, String staffPhone,
			int studentNumber, String studentName, String studentMajor, String studentPhone, int productIndex,
			String productName, Timestamp borrowDate) {
		this.borrowNumber = borrowNumber;
		this.staffNumber = staffNumber;
		this.staffName = staffName;
		this.staffMajor = staffMajor;
		this.staffPhone = staffPhone;
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentMajor = studentMajor;
		this.studentPhone = studentPhone;
		this.productIndex = productIndex;
		this.productName = productName;
		this.borrowDate = borrowDate;
	}

	// Getters and Setters
	public void setBorrowNumber(int borrowNumber) {
		this.borrowNumber = borrowNumber;
	}

	public int getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffMajor() {
		return staffMajor;
	}

	public void setStaffMajor(String staffMajor) {
		this.staffMajor = staffMajor;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMajor() {
		return studentMajor;
	}

	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public int getProductIndex() {
		return productIndex;
	}

	public void setProductIndex(int productIndex) {
		this.productIndex = productIndex;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Timestamp getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Timestamp borrowDate) {
		this.borrowDate = borrowDate;
	}
}
