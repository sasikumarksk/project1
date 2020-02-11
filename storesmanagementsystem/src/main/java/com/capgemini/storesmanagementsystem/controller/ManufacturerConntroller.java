package com.capgemini.storesmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dao.ManufacturerDaoImpl;
import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;
import com.capgemini.storesmanagementsystem.service.ManufacturerService;

public class ManufacturerConntroller {
	private ManufacturerService manService;
	Logger log = Logger.getLogger("store");
	Scanner scan = new Scanner(System.in);
	ManufacturerDaoImpl dao = new ManufacturerDaoImpl();

	void manufactureTask() {

		int choice = 0;
		log.info("Welcome to Manufactures Page");
		log.info("1.Add Dealer");
		log.info("2.Modify Dealer");
		log.info("3.Remove Dealers");
		log.info("4.View Dealers");
		log.info("5.Add Products");
		log.info("6.Modify Products");
		log.info("7.Remove Products");
		log.info("8.View Products");
		log.info("9.View Store");
		log.info("10.Exit");

		do {
			log.info("************************");
			log.info("Enter Your Choice");
			log.info("************************");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				UserDetailsInfo user = new UserDetailsInfo();
				log.info("Enter the UserId");
				String userId = scan.next();
				user.setUserId(userId);

				log.info("Enter the Email");
				String Email = scan.next();
				user.setEmail(Email);

				log.info("Enter the Location");
				String Location = scan.next();
				user.setAddress(Location);
				log.info("Enter the Password");
				String password = scan.next();
				user.setPassword(password);

				log.info("Enter the Role");
				String role = scan.next();
				user.setUserRole(role);

				log.info("Enter the UserName");
				String uname = scan.next();
				user.setUserName(uname);

				dao.addDealer(user);
				// adminService.addManufactur(user);
				log.info("Insert Succesfully");
				break;
			case 2:
				break;
			case 3:

				log.info("Enter the UserId(String) You want to Delete");
				String userid = scan.next();
				dao.removeDealer(userid);
				log.info("User_Id is deleted Succesfully");
				break;

			case 4:
				log.info("Enter which role(Users) you want to see");
				String rol = scan.next();
				List<String> li = dao.viewAllDealers(rol);
				for (String s : li)
					log.info(li);
				break;
			case 5:
				ProductDetailsInfo product = new ProductDetailsInfo();
				log.info("Enter the ProductId");
				int pId = scan.nextInt();
				product.setProduct(pId);

				log.info("Enter the Brand");
				String brand = scan.next();
				product.setProductName(brand);

				log.info("Enter the Price");
				double d = scan.nextDouble();
				product.setPrice(d);

				log.info("Enter the Stocks");
				int s = scan.nextInt();
				product.setStocks(s);

				log.info("Enter the Warranty");
				String str = scan.next();
				product.setWarranty(str);

				dao.addProduct(product);
				log.info("Insert Succesfully");
				break;

			case 6:
				break;

			case 7:
				log.info("Enter the ProductId You want to Delete");
				int pid = scan.nextInt();
				dao.removeProduct(pid);
				log.info("User_Id is deleted Succesfully");
				break;

			case 8:
				List<String> n = dao.viewAllProducts();
				for (String string : n) {
					log.info(string);
				}
				break;
			case 9:
				List<String> ki = dao.viewStore();
				for (String string : ki) {
					log.info(string);

				}
				break;
			default:
				System.out.println("Invalid Choice...");
				break;

			}
		} while (choice != 10);
	}

}
