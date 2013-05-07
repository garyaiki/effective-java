package ch.createanddestroy;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author garystruthers
 * 
 * Scala doesn't have static instead it has an "object" singleton which is lazy (not evaluated until called)
 * A Scala object can have a "companion class" with the same name. Companions have access to each other's private fields.
 *
 */
public class Misc {
	// Item 4 private constructor
	private Misc() {
		// Item 5 don't create unnecessary objects
		String s = "not calling new String";
	}
	// Use static initializers for one time creation of expensive objects
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	}
	// primitives save creation over boxed primitives
	
	// eliminate obsolete references by defining them in the narrowest possible scope
	
	// Item 7 avoid finalizers Java runs them when they are about to be garbage collected.
	// GC runs in a low priority thread and may not run at all
	// Time to destroy an object is much longer in a finalizer
	// Cleanup in try - finally block
	
}
