package com.thread;

public class Stack {
	private int[] array;
	private int stackTop;
	Object lock;

	public Stack(int capacity) {
		array = new int[capacity];
		stackTop = -1;
		lock = new Object();
	}

	// for synchronized block
	// same lock ensures that all synchronized blocks are blocked to other threads,
	// while one thread has access to the lock

	// if method is synchronized, lock used is the current instance of the class
	// that is synchronized(this) {}

	public synchronized boolean push(int element) {

		if (isFull())
			return false;
		++stackTop;

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		array[stackTop] = element;
		return true;
	}

	public synchronized int pop() {

		if (isEmpty())
			return Integer.MIN_VALUE;
		int obj = array[stackTop];
		array[stackTop] = Integer.MIN_VALUE;

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		stackTop--;
		return obj;
	}

	public boolean isEmpty() {
		return stackTop < 0;
	}

	public boolean isFull() {
		return stackTop >= array.length - 1;
	}
}
