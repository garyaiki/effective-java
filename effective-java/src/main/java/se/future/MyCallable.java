package se.future;

import java.util.concurrent.Callable;
/*
 * @see http://www.vogella.com/articles/JavaConcurrency/article.html#futures
 */
public class MyCallable implements Callable<Long> {

	@Override
	public Long call() throws Exception {
		long sum = 0;
		for(long i = 0; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}

}
