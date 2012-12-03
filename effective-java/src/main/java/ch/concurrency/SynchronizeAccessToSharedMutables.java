package ch.concurrency;
/* Item 66
 * Synchronization is required for reliable communication between threads and for mutual exclusion
 * Do not use thread.stop
 * Confine mutable data to a single thread And Document it so it is maintained
 */
public class SynchronizeAccessToSharedMutables {
	
/*
 * Happens-before guarantees
 * @see http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/package-summary.html#MemoryVisibility
 * @see StopThread
 */

/* 
 * When other threads are immutable you can make immutable copies for them
 * Guava provides immutable collections
 */

}
