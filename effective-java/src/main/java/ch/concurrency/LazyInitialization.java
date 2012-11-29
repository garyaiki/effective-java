package ch.concurrency;

import static com.google.common.base.Preconditions.checkNotNull;

/* Item 71
 * Use lazy initialization judiciously
 * Unless a field is usually not used and it is expensive to initialize eager initialization is preferred
 */
public class LazyInitialization {
	/*
	 * To break an initialization circularity use a synchronized accessor
	 */
	private String field;
	
	synchronized String getField() {
		if(field == null) {
			field = new String(); // lazy initialization
		}
		return field;
	}
	
	/*
	 * Lazy instantition of a static field exploits the guarantee that a class will not be initialized until it's used
	 * When you invoke getField for the first time it causes FieldHolder to initialize
	 * Beauty is that it's not synchronized
	 */
	private static class FieldHolder {
		static final String field = new String(); // lazy
	}
	static String getStaticField() {
		return FieldHolder.field;
	}
	
	/*
	 * Double check idiom avoids locking after it has been initialized
	 */
	private volatile String doubleCheckField; // Because there is no locking after initialization it must be volatile
	String getDoubleCheckField() {
		String result = doubleCheckField; // In the common case where field is initialized may improve performance
		if(result == null) { // first check no locking
			synchronized(this) {
				result = doubleCheckField;
				if(result == null) { // second check with locking
					doubleCheckField = result = new String();
				}
			}
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
