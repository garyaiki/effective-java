package ch.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* Item 68
 * Thread is no longer the key abstraction. Now the unit of work and mechanisim are separate
 * unit of work is called a task And there are two kinds: Runnable and Callable(which is like Runnable
 * but it returns a value)
 * ExecutorService are the mechanism for executing tasks. Think in terms of tasks and let ExecutorService
 * execute them for you.
 * ExecutorService does for execution what Collections does for aggregation
 * 
 * Use a {@code ScheduledThreadPoolExecutor} instead of {@code java.util.Timer } because it supports multiple threads
 */
public class PreferExecutorsAndTasksToThreads {

	ExecutorService executor = Executors.newSingleThreadExecutor();
	
	private void submitRunnable(Runnable runnable) {
		executor.execute(runnable);
	}
	
	private void terminateGracefully() {
		executor.shutdown();
	}
	/*
	 * Submitted tasks are not queued but immediately handed off to a thread for execution
	 * If no threads are available a new thread is created which can overload a server
	 */
	private void forLightlyLoadedServer() {
		executor = Executors.newCachedThreadPool();
	}
	
	private void forLoadedServer() {
		int nThreads = 20;
		executor = Executors.newFixedThreadPool(nThreads);
	}
 	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
