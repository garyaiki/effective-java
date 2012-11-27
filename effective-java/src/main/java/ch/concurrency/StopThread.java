package ch.concurrency;

import java.util.concurrent.TimeUnit;
/*
 * Example of usually good enough stopThread.
 * If you need mutual exclusion make stopRequested() synchronized instead of volatile
 */
public class StopThread {

	private static volatile boolean stopRequested;// not mutually exclusive but guarantees most recent version

	private static synchronized boolean stopRequested() { // must be synchronized to ensure communication
		return stopRequested;
	}		
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested()) {
					i++;
				}
			}
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}

}
