package com.csi.threadallconcepts;

class Customer {
	int accbalance = 10000;

	public Customer() {
		this.accbalance = accbalance;
	}

	synchronized public void withdrawMoney(int amount) {
		System.out.println("withrow amount 15000/-");
		if (accbalance < amount) {
			try {
				wait();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		accbalance -= amount;
		System.out.println("amount withdraw succesfully");
	}

	synchronized public void depositeMoney(int amount) {
		System.out.println("deposite amount 250000/-");
		accbalance += amount;
		System.out.println("amount deposited succesfully");
		notify();
	}
}

public class InterThreadConcedptBank {
	public static void main(String[] args) {
		Customer cc = new Customer();
		new Thread() {
			public void run() {
				cc.withdrawMoney(15000);
			};
		}.start();

		new Thread() {
			public void run() {
				cc.depositeMoney(250000);
			};
		}.start();
	}
}
