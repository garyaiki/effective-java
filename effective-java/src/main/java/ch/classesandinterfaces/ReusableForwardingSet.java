package ch.classesandinterfaces;

import java.util.Set;

import com.google.common.collect.ForwardingSet;
/*
 * Item 16 forwarding decorator wraps standard class or what usually is a superclass
 * 
 */
public class ReusableForwardingSet<E> extends ForwardingSet<E> {
	final Set<E> delegate; // backing set
	
	public ReusableForwardingSet(Set<E> delegate) {
		this.delegate = delegate;
	}
	
	/*
	 * Overriding this abstract method passes every Set call to the delegate
	 * this.add("element") becomes this.delegate().add("element");
	 * Methods can be left as is or overridden
	 * @see com.google.common.collect.ForwardingSet#delegate()
	 */
	@Override
	protected Set<E> delegate() {
		return delegate; 
	}

}
