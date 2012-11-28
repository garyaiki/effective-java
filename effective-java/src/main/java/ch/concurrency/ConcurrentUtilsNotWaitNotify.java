package ch.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* Item 69
 * Standard concurrent.util collections internally manage concurrency, locking operations on them only slow them down
 */
public class ConcurrentUtilsNotWaitNotify {
	// ConcurrentHashMap is fast prefer it over Collections.synchronizedMap or Hashtable
	private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>();
	
	// concurrent version of String.intern. map maintains a pool
	public static String intern(String s) {
		String result = map.get(s); // if s already in the pool return it
		if(result == null) {
			result = map.putIfAbsent(s, s); // put s in pool if it's not there
			if(result == null) {
				result = s;
			}
		}
		return result;
	}
	
	// standard idiom for using wait method (when legacy requires it)
	public void waitIdiom(Object obj, boolean condition) throws InterruptedException {
		synchronized(obj) {
			while(!condition) { // skipping wait on true ensures liveness
				obj.wait(); // Don't perform action while condition not satisfied
			}
			// do things once condition holds here

		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
