package com.dankook.EGINE_MANAGE.Dto;

import java.sql.Timestamp;

public class BoardDto {
	private int bNumber;
	private String bId;
	private String bTitle;
	private String bContent;
	private Timestamp bDate;
	private int bHit;
	
	
	// 모든 필드를 이용한 생성자
	public BoardDto(int bNumber, String bId, String bTitle, String bContent, Timestamp bDate, int bHit) {
		this.bNumber = bNumber;
		this.bId = bId;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
	}
	
	
	// 디폴트 생성자
	public BoardDto() {
		
	}
	
	// Getters and Setters
	public int getbNumber() {
		return bNumber;
	}

	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
}
