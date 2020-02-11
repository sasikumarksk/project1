package com.capgemini.storesmanagementsystem.util;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordValidator {
	public static boolean passwordValidator(String plainPassword,String hashedPassword) {
		return BCrypt.checkpw( plainPassword,hashedPassword);
		
	}
	public static void main(String[] args) {
		Scanner scanner=new  Scanner(System.in);
		System.out.println("enter  the password to be encoded");
		String plainPassword=scanner.nextLine();
		String hashedPassword=PasswordEncoder.passwordEncoder(plainPassword);
		System.out.println(hashedPassword);
		System.out.println("enter the password tobe matched");
		String password=scanner.nextLine();
		if(passwordValidator(password, hashedPassword)) {
			System.out.println("password matches");
		}else {
			System.out.println("invalid password");
		}
		
		scanner.close();
		
	}

}
