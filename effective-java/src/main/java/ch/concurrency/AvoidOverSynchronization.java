package ch.concurrency;

import java.util.List;

/* Item 67
 * Never cede control to client within synchronized code don't call a method designed to be overridden 
 * or a function object provided by a client
 * 
 * an alien method invoked outside a synchronized region is known as an 'open call'
 * Try to do as little as possible within synchronized regions
 * 
 * In a multicore world the cost of synchronization is lost parallelism and making memory consistent
 * StringBuilder is an unsynchronized StringBuffer
 * 
 * @see Doug Lea for information on lock splitting, lock striping, and non-blocking concurrency control
 * @see ObservableSet
 */
public class AvoidOverSynchronization {
	private static String staticStringField;
	public static synchronized String getStaticStringField() {
		return staticStringField;
	}
	// Mutating static fields require synchronizing accessors to it 
	public static synchronized void setStaticStringField(String staticStringField) {
		AvoidOverSynchronization.staticStringField = staticStringField;
	}


}
