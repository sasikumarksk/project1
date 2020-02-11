package com.capgemini.storesmanagementsystem.service;

import java.util.List;

import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public interface AdminService {

	
	public boolean addManufacturer(UserDetailsInfo user);
	public boolean updateManufacturer(String userId,UserDetailsInfo user);
	public boolean deleteManufacturer(String userId);
	public List<String> viewAllManufacturer();

}
