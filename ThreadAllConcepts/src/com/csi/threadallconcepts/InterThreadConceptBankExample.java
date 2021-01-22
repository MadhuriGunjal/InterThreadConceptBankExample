package com.csi.threadallconcepts;

import java.util.Scanner;

class Customer1 {

	int accbalance = 500;

	public Customer1() {
		this.accbalance = accbalance;
	}

	Scanner sc = new Scanner(System.in);
	int withdrawamount;
	int depositedamount;

	synchronized public void withdrawMoney1() {

		System.out.println("enter amount to withdraw");
		int withdrawamount = sc.nextInt();
		if (accbalance < withdrawamount) {
			System.out.println("Insufficient balance");
			try {

				wait();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (accbalance < withdrawamount) {
			System.out.println("insuff");
			System.out.println("you have to deposit money ");
			depositeMoney1();
			System.exit(0);
		} else {
			accbalance -= withdrawamount;
			System.out.println("amount is withdrawed");
			System.exit(0);
		}

		accbalance -= withdrawamount;
		System.out.println("amount withdraw succesfully");
	}

	synchronized public void depositeMoney1() {
		System.out.println("deposite amount money-");

		int depositedamount = sc.nextInt();
		accbalance += depositedamount;

		System.out.println("amount deposited succesfully");

		notify();
	}

}

public class InterThreadConceptBankExample {
	public static void main(String[] args) {

		Customer1 cc = new Customer1();
		new Thread() {
			public void run() {
				cc.withdrawMoney1();
			};
		}.start();

		new Thread() {
			public void run() {
				cc.depositeMoney1();
			};
		}.start();

	}
}
