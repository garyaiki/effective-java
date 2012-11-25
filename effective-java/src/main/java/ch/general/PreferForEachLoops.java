package ch.general;

import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.Collections2;

/* Item 46
 * 
 */
public class PreferForEachLoops {
	// use this form for iterating over collections, variable declared in loop less error prone 
	private static List<String> strings = new ArrayList(); 
	static void forEachExample() {
		for(String e : strings) { 
			e = e.trim();
		}
	}
	
	// use nested for loop for multiple collections and arrays
	private static List<String> otherStrings = new ArrayList(); 
	static void nestedForEachExample() {
		for(String e : strings) { 
			e.trim();
			for(String f : otherStrings) {
				f = f.trim();
			}
		}
	}
	
	/* Filter selected elements from a collection need an explicit iterator 
	 * Don't use GUAVA Predicate or Transform
	 * Use and ordinary for loop
	 */
	
}
