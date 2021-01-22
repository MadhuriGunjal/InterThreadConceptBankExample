package com.csi.threadallconcepts;

class MyThread1 extends Thread {
	public void run() {
		System.out.println("Hi Its Punam ");
	}
}

class MyThread2 extends Thread {
	public void run() {
		System.out.println("Hello I am Madhuri Here...");
	}
}

class MyThread3 extends Thread {
	public void run() {
		System.out.println("hiii its Anu Here...");
	}
}

public class ThreadPriorityConcepts {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		MyThread3 t3 = new MyThread3();
		t1.setPriority(5);
		t2.setPriority(10);
		t3.setPriority(10);
		t1.setName("Serivce");
		// System.out.println("access:"+t1.checkAccess(t2));
		t1.checkAccess();
		System.out.println("t1 is alive: " + t1.isAlive());
		System.out.println("count:" + t1.countStackFrames());
		System.out.println("Class :" + t1.getClass());
		System.out.println("\n Name :" + t1.getName());
		System.out.println("\n Priority:" + t1.getPriority());
		System.out.println("\n Id:" + t1.getId());
		System.out.println("\n stack trace:" + t1.getStackTrace());
		t1.start();
		System.out.println("thread t1:" + t1.getThreadGroup());
		System.out.println("daemon:" + t1.isDaemon());
		System.out.println("thread state: " + t1.getState());
		System.out.println("t1 is alive:" + t1.isAlive());
		t2.start();
		t3.start();

	}

}
