package ch.classesandinterfaces;

import java.util.AbstractList;
import java.util.List;

/* Item 18
 * Combine advantages of interfaces and abstract classes by providing skeletal implementation to 
 * accompany each non-trivial interface you create. Interface provides the type and skeletal 
 * implementation provides reusable base
 * JDK provides many AbstractXXX classes
 * Guava provides Abstract service and concurrent classes
 * 
 * +Skeletal implementations provide reuse of abstract classes without their constraints
 * when used as type definitions
 * 
 * Private inner classes implementing skeletal can simulate multiple inheritance 
 */
public class AbstractInterfaces {
	// example of AbstractList and Adapter pattern
	static List<Integer> initArrayAsList(final int[] a) {
		if(a == null) throw new NullPointerException();
		
		return new AbstractList<Integer>() {
			// implement abstract methods
			public Integer get(int i) {
				return a[i]; // autoboxes int to Integer
			}
			
			public int size() {
				return a.length;
			}
			
			@Override
			public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val; // Integer to int unboxing
				return oldVal; // autobox
			}
		};
	}

}
