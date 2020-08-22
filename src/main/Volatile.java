package main;

import java.util.concurrent.TimeUnit;

public class Volatile {

	public static volatile boolean stop;

	public static void main(String args[]) throws InterruptedException {
		new Thread(() -> {
			while (!stop) {
				System.out.println(stop + ": In while");
			}
		}).start();

		TimeUnit.SECONDS.sleep(1);
		System.out.println("Set as True");
		stop = true;
	}

}
