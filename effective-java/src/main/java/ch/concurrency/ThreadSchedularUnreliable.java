package ch.concurrency;
/* Item 72
 * Thread scheduler is inconsistent between implementations
 * Try to ensure the average number of runnable threads is not significantly greater than the number of processors
 * Threads that are waiting are not runnable
 * Threads should not run if they aren't doing useful work.
 * Try not to call Thread.yield it has no testable semantics
 * Thread priorities are amoung the least portable features of Java
 * For testing use Thread.sleep(1) Thread.yield() may not do anything
 */
public class ThreadSchedularUnreliable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
