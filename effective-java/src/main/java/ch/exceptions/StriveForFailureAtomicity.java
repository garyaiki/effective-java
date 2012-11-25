package ch.exceptions;
/* Item 64
 * A failed method should be returned to the state it was in when it was called.
 * Use immutable objects, check preconditions
 * Order the method so that any failure takes place before modifying the object
 * 
 * Recovery code for after writing to a file or database
 * You can modify a copy and replace the original if no error
 */
public class StriveForFailureAtomicity {

}
