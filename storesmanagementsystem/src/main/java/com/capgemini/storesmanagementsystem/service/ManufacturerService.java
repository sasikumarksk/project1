package com.capgemini.storesmanagementsystem.service;

import java.util.List;

import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public interface ManufacturerService {
	public List<String> loginManufacturer(String userId, String password);

	public boolean addDealer(UserDetailsInfo dealer);
	public boolean modifyDealer(String user);
	public boolean removeDealer(String dealerId);
	public List<String> viewAllDealers(String role);

	public boolean addProduct(ProductDetailsInfo product);
	public boolean modifyProduct(String product);
	public boolean removeProduct(Integer productId);
	public List<String> viewAllProducts();

	public List<String> viewAllOrders();
	public List<String> viewStore(); 


}


