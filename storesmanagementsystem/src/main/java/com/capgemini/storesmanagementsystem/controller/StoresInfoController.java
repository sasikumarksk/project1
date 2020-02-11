package com.capgemini.storesmanagementsystem.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.service.AdminServiceImpl;


public class StoresInfoController {
	static Logger log = Logger.getLogger("store");

	public static void main(String[] args) {

		AdminServiceImpl service = new AdminServiceImpl();
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		log.info("1.Admin");
		log.info("2.Manufacturer");
		log.info("3.Dealer");
		log.info("4.Exit");

		int count = 0;

		do {

			log.info("+=+=+=+=+=+=+=+=+=+=+=+=");
			log.info("Enter Your Choice");
			log.info("+=+=+=+=+=+=+=+=+=+=+=+=");
			choice = sc.nextInt();

			switch (choice) {
			case 1:

				if (count < 1) {
					count++;
					log.info("Enter Your Username:");
					String name = sc.next();
					log.info("Enter Your Password:");
					
					String password = sc.next();
					//service.login(name, password);
					log.info("Successfully Login");

				}

				AdminController admin = new AdminController();
				admin.adminTask();

				break;

			case 2:

				ManufacturerConntroller manufacturer = new ManufacturerConntroller();
				manufacturer.manufactureTask();
				break;

			case 3:

				DealerController dealer = new DealerController();
				dealer.dealerTask();
				break;

			}
		} while (choice != 3);

		log.trace("ThankYou for using our Services!!!");
		sc.close();

	}
	
}


