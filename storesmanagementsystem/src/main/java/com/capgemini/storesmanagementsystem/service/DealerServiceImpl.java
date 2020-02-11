package com.capgemini.storesmanagementsystem.service;

import java.util.List;

import com.capgemini.storesmanagementsystem.dao.DealerDao;
import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;

public class DealerServiceImpl implements DealerService{

	
	private DealerDao dao; 

		
		public List<String> loginDealer(String userId, String password) {
			return dao.loginDealer(userId, password);
		}


		public boolean makeOrder(OrderDetailsInfo order) {
			return dao.makeOrder(order);
		}


		public boolean deleteOrder(Integer orderId) {
			return dao.deleteOrder(orderId);
		}


		public List<String> showAllproducts() {
			return dao.showAllproducts();
		}


		public List<String> viewMyStore(int storeId) {
			return dao.viewMyStore(storeId);
		}


		public List<String> viewMyOrders(int userId) {
			return dao.viewMyOrders(userId);
		}
	
	


	
	
	
	

}
