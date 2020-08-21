package main;

import java.util.concurrent.TimeUnit;

public class Deadlock {

	public static void main(String args[]) throws InterruptedException {

		DeadLockTrigger dt = new DeadLockTrigger();
		dt.t1.start();
		dt.t2.start();

		dt.t1.join();
		dt.t2.join();

		System.out.println("End of main Thread");

	}

}

class DeadLockTrigger {
	String o1 = "Aditya";
	String o2 = "Verma";

	Thread t1 = (new Thread() {

		public void run() {
			System.out.println("You are in Thread 1");

			synchronized (o1) {
				System.out.println("Thread 1 Holding lock of o1");

				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Thread 1 : waiting for lock of o2");

				synchronized (o2) {
					System.out.println("Holding Lock of o1 + o2");
				}
			}
		}
	});

	Thread t2 = (new Thread() {

		public void run() {
			System.out.println("You are in Thread 2");
			synchronized (o2) {

				System.out.println("Thread 2 holding lock of o2");

				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Thread 2 : Waiting for o1 lock");

				synchronized (o1) {
					System.out.println("Thread 2 holding lock of o2 + o1");
				}
			}
		}
	});

}