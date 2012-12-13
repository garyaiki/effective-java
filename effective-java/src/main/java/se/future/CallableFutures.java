package se.future;
/*
 * ExecutorService accepts Runnable or Callable submit() returns a Future which is used 
 * to retrieve the Callable retur value
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutures {
	private static final int NTHREADS = Runtime.getRuntime().availableProcessors();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		@SuppressWarnings("rawtypes")//OK in Java 7 Type inference not a raw type
		List<Future<Long>> list = new ArrayList();
		for(int i = 0; i < 20000; i++) {
			Callable<Long> worker = new MyCallable();
			Future<Long> submit = executor.submit(worker);
			list.add(submit);
		}
		long sum = 0;
		System.out.format("list size %d%n", list.size());
		for (Future<Long> future : list) {
			try {
				sum += future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.format("sum %d%n", sum);
		executor.shutdown();
	}

}
