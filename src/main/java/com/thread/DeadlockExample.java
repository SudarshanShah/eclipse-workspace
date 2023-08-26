package com.thread;

// Deadlock is a situation where first thread is waiting for the lock which second thread has
// and second thread is waiting for the lock which first thread has.
// To avoid Deadlock situation, both threads should acquire the locks in same order.
public class DeadlockExample {

	public static void main(String[] args) {
		
		String lock1 = "Sudarshan";
		String lock2 = "Shah";
		
		Thread thread1 = new Thread(() -> {
			synchronized (lock1) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("Lock2 acquired");
				}
			}
		},"thread1");
		
		Thread thread2 = new Thread(() -> {
			synchronized (lock2) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("Lock1 acquired");
				}
			}
		},"thread2");
		
		thread1.start();
		thread2.start();
	}
}
