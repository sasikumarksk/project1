package com.capgemini.storesmanagementsystem.service;

import java.util.List;

import com.capgemini.storesmanagementsystem.dao.ManufacturerDao;
import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public class ManufacturerServiceImpl implements  ManufacturerService {
	private ManufacturerDao dao;
	public List<String> loginManufacturer(String userId, String password){
	return dao.loginManufacturer(userId, password);
	}

	public boolean addDealer(UserDetailsInfo dealer) {
		return dao.addDealer(dealer);
	}

	public boolean modifyDealer(String user) {
		return dao.modifyDealer(user);
	}

	public boolean removeDealer(String dealerId) {
		return dao.removeDealer(dealerId);
	}

	public List<String> viewAllDealers(String role) {
		return dao.viewAllDealers(role);
	}

	public boolean addProduct(ProductDetailsInfo product) {
		return dao.addProduct(product);
	}

	public boolean modifyProduct(String product) {
		return dao.modifyProduct(product);
	}

	public boolean removeProduct(Integer productId) {
		return dao.removeProduct(productId);
	}

	public List<String> viewAllProducts() {
		return dao.viewAllProducts();
	}

	public List<String> viewAllOrders() {
		return dao.viewAllOrders();
	}

	public List<String> viewStore() {
		return dao.viewStore();
	}

	
}
