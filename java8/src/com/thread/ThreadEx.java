package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadEx {

	// ExecutorService
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {
			Runnable worker = new Workers("" + i);
			executor.execute(worker);

		}
		executor.shutdown();
	}

}

class Workers implements Runnable {

	private String command;

	public Workers(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : Start .");

		ProcessWork();

		System.out.println(Thread.currentThread().getName() + " : End .");
	}

	private void ProcessWork() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
