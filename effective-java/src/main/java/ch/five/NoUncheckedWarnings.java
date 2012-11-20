package ch.five;

import java.util.Arrays;

/* Item 24
 * Worth the effort to eliminate all generic type warnings that you can
 * Use @SuppressWarnings("unchecked") when you're sure it's typesafe
 * @SuppressWarnings("unchecked") use narrowest scope
 */
public class NoUncheckedWarnings {
	// narrow scope of suppress warning from whole method to local variable
	public <T> T[] toArray(T[] a) {
		int size = 10;
		if(a.length < size) {
			@SuppressWarnings("unchecked") // always comment why safe to suppress warning
			T[] result = (T[]) Arrays.copyOf(a, a.length, a.getClass());
			return result;
		}
		return null;
	}

}
