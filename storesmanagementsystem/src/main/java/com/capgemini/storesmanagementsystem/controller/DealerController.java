package com.capgemini.storesmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dao.DealerDaoImpl;
import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;
import com.capgemini.storesmanagementsystem.service.DealerService;

public class DealerController {
	private DealerService dealerService;

	DealerDaoImpl dao = new DealerDaoImpl();
	Logger log = Logger.getLogger("store");
	Scanner scan = new Scanner(System.in);

	void dealerTask() {

		int choice = 0;
		log.info("Welcome to Dealer's Page");
		log.info("1.Make Orders");
		log.info("2.Delete Orders");
		log.info("3.Show All Products");
		log.info("4.Show All Orders");
		log.info("5.Show My Store");
		log.info("5.Exit");

		do {
			log.info("************************");
			log.info("Enter Your Choice");
			log.info("************************");
			choice = scan.nextInt();
			switch (choice) {

			case 1:
				OrderDetailsInfo od = new OrderDetailsInfo();
				log.info("Enter UserName");
				String userName = scan.next();
				od.setUserName(userName);

				log.info("Enter Password");
				String password = scan.next();
				od.setPassword(password);

				log.info("Enter orderId ");
				int orderId = scan.nextInt();
				od.setOrderId(orderId);

				log.info("Enter productId ");
				int pId = scan.nextInt();
				od.setProductId(pId);

				log.info("Enter Quantity ");
				int qty = scan.nextInt();
				od.setQuantity(qty);

				log.info("Enter address");
				String address = scan.next();
				od.setAddress(address);

				dao.makeOrder(od);
				log.info("Insert Succesfully");
				break;

			case 2:
				log.info("Enter the orderId You want to Delete");
				int n = scan.nextInt();
				dao.deleteOrder(n);
				log.info("OrderId is deleted Succesfully");
				break;
			case 3:
				List<String> s = dao.showAllproducts();
				for (String string : s) {
					log.info(string);
				}
				break;
				
			case 4:

				log.info("Enter the UserId for seeing StoreUnit");

				int id1 = scan.nextInt();
				List<String> li = dao.viewMyOrders(id1);

				for (String str : li) {
					log.info(str);
				}
				break;
			case 5:
				log.info("Enter the StoreId You want to See");

				int k = scan.nextInt();
				//dao.viewMyStore(k);

				List<String> j = dao.viewMyStore(k);
				for (String string : j) {
					log.info(string);

				}
				break;

			default:
				System.out.println("Invalid Choice...");
				break;

			}

		} while (choice != 6);
	}
	


}
