package com.capgemini.storesmanagementsystem.dao;

import java.util.List;

import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;

public interface DealerDao {
public List<String> loginDealer(String userId, String password);
	
	public boolean makeOrder(OrderDetailsInfo order);
	public boolean deleteOrder(Integer orderId);
	public List<String> showAllproducts();
	public List<String> viewMyOrders(int userId);
	public List<String> viewMyStore(int storeId);


}
