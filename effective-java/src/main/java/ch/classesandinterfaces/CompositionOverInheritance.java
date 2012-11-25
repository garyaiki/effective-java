package ch.classesandinterfaces;

public class CompositionOverInheritance<E> {
	/* Item 16
	 * -Inheritance violates encapsulation; changing superclass can break subclass forcing 
	 * them to evolve in tandem
	 * +Better to have a private filed referencing the otherwise superclass
	 * +Guava provides forwarding decorators for collections and iterators
	 * +forwarding decorators are reusable and decouple changes in superclass
	 * 
	 * Subclass when there is truly an is-a relationship
	 * Prefer forwarding when overriding
	 */
	
	/*
	 * 
	 * @see http://code.google.com/p/guava-libraries/wiki/CollectionHelpersExplained#Forwarding_Decorators
	 */
	private ReusableForwardingSet<E> forwardingSet;
	
	public CompositionOverInheritance(ReusableForwardingSet<E> forwardingSet) {
		this.forwardingSet = forwardingSet;
	}
	
	public boolean isEmpty() {
		// change behavior here
		return forwardingSet.isEmpty();
	}
}
