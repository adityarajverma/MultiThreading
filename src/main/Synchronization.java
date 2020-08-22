package main;

import java.util.concurrent.TimeUnit;

public class Synchronization {

	public static void main(String args[]) throws InterruptedException {

		Sync sync = new Sync();

		Thread t1 = new Thread(() -> {
			sync.sync();

		});

		Thread t2 = new Thread(() -> {
			sync.nonSync();

		});

		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();

		t1.join();

		System.out.println("End OF Main Method");

	}

}

class Sync {
	public synchronized void sync() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("I am in Synchronized method ");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void nonSync() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("I am in non Sync method");
	}
}