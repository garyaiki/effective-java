package ch.generics;
/* Item 27
 * 
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* Item 27
 * 
 * Scala [-P, +R] contravariant parmeter type, covariant return type
 * contravariant can only pass a subtype, a String argument can accept only String and its subTypes
 * covariant method can return a String to a val of Any
 * Use invariant arguments only for mutable objects  
 * 
 * Scala Upper bound T <: A means T is a subtype of A (A is the upper bound)
 * Scala Lower bound T >: A means T is a supertype of A (A is the lower bound)
 */
public class FavorGenericMethods  {
	
	// s1,s2 are producers should use ? extends T didn't because contrived example
	public static <T> Set<T> union(Set<T> s1, Set<T> s2) {
		Set<T> result = new HashSet<T>(s1);
		result.addAll(s2);
		return s2;		
	}
	// <E> is the argument type Set<? extends E> is the return type
	public static <E> Set<? extends E> union2(Set<E> s1, Set<E> s2) {
		s1.addAll(s2);
		Set<? extends E> result = s1;
		return result;		
	}
	
	// generic static factory method
	public static <K,V> HashMap<K,V> newHashMap() {
		return new HashMap<K, V>();
	}
	
	// cleaner parameterized type creation
	public void lessCruft() {
		Map<String, List<String>>anagrams = newHashMap();
	}
	
	//generic singleton factory pattern can be used as any type
	private static UnaryFunction<Object> IDENTITY_FUNCTION = 
			new UnaryFunction<Object>() {
		public Object apply(Object arg) {return arg;}
	};

	// stateless and unbounded, for all types
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}
	public static void main(String[] args) {
		String[] strings = {"jute","hemp","nylon"};
		UnaryFunction<String>sameString = identityFunction();
		for(String s : strings) System.out.println(sameString.apply(s));
	}
}
