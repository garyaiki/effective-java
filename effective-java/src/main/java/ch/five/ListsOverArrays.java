package ch.five;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;

/* Item 25
 * Arrays are Covarint (if Sub a subtype of Super -> Sub[] a subtype of Super[]
 * Lists are Invariant -> compiler catches wrong type assignments
 * Arrays fail wrong types at runtime
 * Arrays are reified, enforce type at runtime
 * Non reifiable types have less runtime than compile time information i.e.  E, List<E>, List<String>
 */
public class ListsOverArrays {
	// Reduce list of Integers to their sum 
	// Guava Function<E,E> returns type E from input E Prefer Java 8 Functions
	static <E> E reduceSameType(List<? extends E>list, Function<E,E>fun,E initVal) {
		List<E> snapshot;
		synchronized(list) {
			snapshot = new ArrayList<E>(list);
		}
		E result = initVal;
		for (E f: snapshot) {
			result = fun.apply(f);
			return result;
		}
		return result;
	}

	static <E, T> T reduceOtherType(List<? extends E>list, Function<E,T>fun,T initVal) {
		List<E> snapshot;
		synchronized(list) {
			snapshot = new ArrayList<E>(list);
		}
		T result = initVal;
		for (E f: snapshot) {
			result = fun.apply(f);
			return result;
		}
		return result;
	}
}
