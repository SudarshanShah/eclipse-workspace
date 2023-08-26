package com.thread;

public class ThreadMain {

	public static void main(String[] args) {

		System.out.println("main is starting");

		// NOT to prefer this way
		// as we are constrained to extend only one class
		Thread thread1 = new Thread1("thread1");
		thread1.start();

		// PREFERRED way of creating thread
		// using Runnable Interface
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread() + " " + i);
			}
		}, "thread2");
		thread.start();

		System.out.println("main is exiting");
		
		
		
		

		Stack stack = new Stack(5);

		new Thread(() -> {
			int counter = 0;
			while (++counter < 2)
				System.out.println("Pushed " + stack.push(100));
		}, "Pusher").start();

		new Thread(() -> {
			int counter = 0;
			while (++counter < 2)
				System.out.println("Popped " + stack.pop());
		}, "Popper").start();
		
		
		
		
		

		Thread thread3 = new Thread(() -> {
			try {
				Thread.sleep(1);
				for (int i = 10000; i > 0; i--);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "States");

		thread3.start();

		while (true) {
			Thread.State state = thread3.getState();
			System.out.println(state);
			if (state == Thread.State.TERMINATED)
				break;
		}
		
		
		
		
		Thread t = new Thread(() -> {
			System.out.println(Thread.currentThread());
		}, "Our Thread");
		
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("the main is exiting");
	}
}
