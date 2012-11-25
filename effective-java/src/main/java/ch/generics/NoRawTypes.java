package ch.generics;

import java.util.ArrayList;
import java.util.Collection;

/* Item 23
 * A raw type is a pre 1.5 declaration without parameterized types
 * A parameterized type makes the compiler insert a hidden cast, catching type errors
 * <E> is a formal parameter, <String> is an actual parameter
 */
public class NoRawTypes {
	private final Collection<String/* actual type */> cs = new ArrayList<String>(); // parameterized type
	private void someMethod(String s) {
		cs.add(s); //cs.add(new Integer(1)); would compile with raw type & runtime fail
	}
	// Can only put a null into unbounded wild card collection
	private final Collection<?> wildCardCollection = new ArrayList<String>();
	private void someWildCardMethod(String s) {
		wildCardCollection.add(null); //cs.add(s); compile error
		
		// Use wild card in instanceof
		if (wildCardCollection instanceof ArrayList) {
			ArrayList<?> a = (ArrayList<?>)wildCardCollection;
		}
	}
	
	// Must use raw types for class literals
	Class clz = ArrayList.class; //clz = ArrayList<String>.class; compile error

	
}
