package ch.methods;
/* Item 40
 * Methods should be verb or verb phrase, 
 * when returning boolean prefix with "is" followed by an adjective
 * get than noun or noun phrase
 * prefix type converting methods with "to"
 * An adapter aka view prefix with "as"
 * 
 * Every method should pull its weight, "when in doubt leave it out"
 * 
 * Avoid long parameter lists, 4 max usually, helper class to hold group of parameters or builder pattern
 * Favor interface types for arguments 
 */
public class DesignMethodSignatures {
	
	// Prefer 2 element enum to boolean parameters
	public enum TempretureScale { FAHENHEIT, CELSIUS }
	

}
