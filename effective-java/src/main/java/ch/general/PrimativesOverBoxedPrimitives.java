package ch.general;
/* Item 49
 * Boxed primitives have identities distinct from their values, they can have be null
 * primitives more efficient 
 * Use Boxed primitives where necessary; in Collections and for parameterized types
 */
public class PrimativesOverBoxedPrimitives {

	public int compareIdenties(Integer first, Integer second) {
		if(first == second) {
			// == compares object identities They are never equal
			return 0;
		} else {
			int f = first; // auto un-boxed BUT IF OBJECT hasn't been initialized it throws NPE
			int s = second;
			return f < s ? -1 : (f == s ? 0 : 1);
		}
		
	}
}
