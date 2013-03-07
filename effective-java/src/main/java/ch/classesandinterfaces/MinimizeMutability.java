package ch.classesandinterfaces;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;


public class MinimizeMutability {
	/* Item 15
	 * 
	 * Classes should be immutable unless there is a good reason to make them mutable
	 * When a class can't be immutable, all fields that can be final should be to minimize number of states
	 * 
	 * To make a class immutable:
	 * +don't provide object state mutators i.e. set()
	 * +ensure class can't be extended; make class final is the habitual way
	 * +Prefer static factories with non-public constructors to final classes. See Item1 Factory Can Cache
	 * +make all fields final; this also alows a newly created object 
	 * to be passed to another thread without synchronization
	 * +make all fields private
	 * +don't leak internal mutable variables outside of class
	 * 
	 *+Immutable objects are SIMPLE they can only be in 1 state
	 *+Inherently threadsafe and can be shared freely
	 *+Great for Map keys and Set elements
	 * 
	 * -Disadvantage is they require an object for each value
	 * -Serializable final objects containing a mutable must override
	 * 
	 * Guava has immutable collections
	 * Scala "val" is immutable, "var" is mutable. Scala has immutable collection packages. 
	 * val fields have only getters, var has setters
	 * 
	 */
	// making immutables shareable
	public static final String ZERO = "0";
	private List<String> mutableSrc = new ArrayList<String>();
	
	// Don't provide public initialization methods without a compelling reason
	private void initSrc() {
		mutableSrc.add("arg0");
		mutableSrc.add("arg1");
		mutableSrc.add("arg2");
	}
	/*
	 * Can be cast to java.util interfaces
	 */
	public ImmutableList<String> defensiveCopy() {
		initSrc();
		return ImmutableList.copyOf(mutableSrc);
	}
}
