package ch.eight;
/* Item 56
 * 
 */
public class NamingConventions {
	
	// package lowercase, rarely digits, 8 chars max for component, meaningful abbreviations good, acronyms OK
	
	/* class & interface abbreviations BAD (max min OK), acronyms OK
	 * But for local variables, meaningful abbreviations good, acronyms OK
	 * When context makes it clear locals can be "i" "j"
	 */
	
	/*
	 *  Type parameter 'T' arbitrary type, 'E' element type, 'K' key, 'V' value, 'X' exception
	 *  Sequence of arbitrary type T, U, V, T1, T2
	 */
	
	// methods & fields begin lowercase letter CONSTANTS_UPPERCASE
	
	/* Grammer
	 * Class noun or noun phrase
	 * Interfaces like classes but can end with adjective 'able' 'ible' i.e. Runnable
	 * Action Methods begin with verb or verb phrase
	 * boolean methods begin with 'is'
	 * Accessor Methods getNoun setNoun
	 * Type adapters begin with 'to'
	 * Return primitives typeValue i.e. intValue
	 * static factories valueOf, getInstance, newInstance, getType, newType
	 */

}
