package com.dankook.EGINE_MANAGE.Dto;

public class ProductDto {
	private int productNumber;
	private String productName;
	
	// 디폴트 생성자
	public ProductDto() {
		
	}
	
	// 물품 생성자
	public ProductDto(int productNumber, String productName) {
		this.productNumber = productNumber;
		this.productName = productName;
	}
	
	// Getters and Setters
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
