package ch.four;

public class MinimizeAccessibilityOfClassesAndMembers {
	/*
	 * Item 13
	 * Make each class or member as inaccessible as possible
	 * Instance fields should never be public, you lose control of limiting the values of the fields
	 * and lose control of the field's invariants
	 * and public mutable fields aren't threadsafe because you can't take any action when field is modified
	 * and lose flexibility of changing internal implementation
	 */

	public static final String[] values = {"one", "two"};
	
	public void finalFieldContainsMutableElements() {
		values[1] = "three"; // client can modify elements
	}
	
	public static final String A_CONSTANT = "OK"; // Constant public fields ok 
}
