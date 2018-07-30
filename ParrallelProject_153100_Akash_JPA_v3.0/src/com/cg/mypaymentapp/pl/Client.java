package com.cg.mypaymentapp.pl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class Client {

	private WalletService walletService;
	private HashMap<String, Customer> data;

	public Client() {

		walletService = new WalletServiceImpl();

	}

	public void menu() {
		System.out.println("\nChoose among the following menu: ");
		System.out.println("1. Create an Account");
		System.out.println("2. Show the Balance");
		System.out.println("3. Fund Transfer");
		System.out.println("4. Deposit Fund");
		System.out.println("5. Withdraw Fund");
		System.out.println("6. Exit");
		System.out.print("Enter your choice\t\t:\t");

		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		switch (choice) {

		case 1:
			System.out.print("\nEnter name\t\t\t:\t");
			String name = sc.next();
			System.out.print("\nEnter phone number\t\t:\t");
			String mobileno = sc.next();
			System.out.print("\nEnter amount\t\t\t:\t");
			BigDecimal amount = sc.nextBigDecimal();

			
			try {
				walletService.createAccount(name, mobileno, amount);
			} catch (Exception e4) {
				// TODO Auto-generated catch block
				
				System.err.println(e4);
			}
			break;
		case 2:
			System.out.print("\nEnter mobile number\t\t:\t");
			mobileno = sc.next();

			try {
				Customer customer = walletService.showBalance(mobileno);

				System.out.println("\t\t\t"+customer.getWallet());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}
			break;
		case 3:
			System.out.print("\nEnter sender mobile number\t:\t");
			String sourceMobileNo = sc.next();
			System.out.print("\nEnter reciever mobile number\t:\t");
			String targetMobileNo = sc.next();
			System.out.print("\nEnter amount\t\t\t:\t");
			amount = sc.nextBigDecimal();

			try {
				walletService.fundTransfer(sourceMobileNo, targetMobileNo, amount);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.err.println(e1);
			}

			break;
		case 4:
			System.out.print("\nEnter mobile phone\t\t:\t");
			mobileno = sc.next();
			System.out.print("\nEnter the amount to be deposited:\t");
			amount = sc.nextBigDecimal();

			try {
				walletService.depositAmount(mobileno, amount);
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				System.err.println(e3);
			}

			break;

		case 5:
			System.out.print("\nEnter mobile phone\t\t:\t");
			mobileno = sc.next();
			System.out.print("\nEnter the amount to be withdrawn:\t");
			amount = sc.nextBigDecimal();

			try {
				walletService.withdrawAmount(mobileno, amount);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				System.err.println(e2);
			}

			break;
		
	
		default:
			System.exit(0);
			break;

		}

	}

	public static void main(String[] args) {

		Client client = new Client();

		while (true) {
			client.menu();
		}

	}
}
