package com.thread;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

	private Queue<Integer> queue;
	private int capacity;

	public BlockingQueue(int capacity) {
		queue = new LinkedList<Integer>();
		this.capacity = capacity;
	}

	// if queue is full, it goes into waiting condition, releases the lock for other
	// threads to execute, and once it gets notified, it continues it execution
	// when it add new item, it notifies to all threads
	public boolean add(int item) {
		synchronized (queue) {
			while (queue.size() == capacity) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			queue.add(item);
			queue.notifyAll();
			return true;
		}
	}

	public int remove() {
		synchronized (queue) {
			while (queue.size() == 0) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			int element = queue.poll();
			queue.notifyAll();
			return element;
		}
	}
}
