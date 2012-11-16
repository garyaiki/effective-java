package ch.two;

import java.util.Calendar;
import java.util.TimeZone;

public class Misc {
	// Item 4 private constructor
	private Misc() {
		// Item 5 don't create unnecessary objects
		String s = "not calling new String";
	}
	// Use static initializers for onetime creation of expensive objects
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	}
	// primitives save creation over boxed primitives
	
	// elimanate obsolete references by defining them in the narrowest possible scope
	
	// Item 7 avoid finalizers Java runs them when they are about to be garbage collected.
	// GC runs in a low priority thread and may not run at all
	// Time to destroy an object is much longer in a finalizer
	// Cleanup in try - finally block
	
}
