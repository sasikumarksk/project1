package com.capgemini.storesmanagementsystem.dto;

public class ProductDetailsInfo {
	private Integer productId;
	private String productName;
	private double price;
	private Integer stocks;
	private String warranty;
	
	public Integer getProduct() {
		return productId;
	}
	public void setProduct(Integer product) {
		this.productId = product;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public Integer getStocks() {
		return stocks;
	}
	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}
	
}