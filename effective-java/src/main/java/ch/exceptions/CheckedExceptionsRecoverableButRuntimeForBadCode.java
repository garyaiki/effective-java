package ch.exceptions;

import java.io.FileNotFoundException;

/*
 * Item 58
 * Use checked exceptions when the caller can be expected to recover. 
 * This forces it to be dealt with in a catch clause
 * An exception in a method's throws declaration tells clients to handle them
 * So catch checked exceptions where they should be handled
 * checked exceptions should provide accessors to give clients recovery information
 * 
 * Runtime exceptions often caused by precondition violations
 * Errors are reserved for the Java libraries by convention
 */
public class CheckedExceptionsRecoverableButRuntimeForBadCode {
	int caseVar = 0;

	public void example() {
		try{
			switch(caseVar) {
			case 1: throw new FileNotFoundException();
			//break;
			case 2: throw new ArrayIndexOutOfBoundsException();
			//break;
			}
/*Java7 multi catch } catch (FileNotFoundException | ArrayIndexOutOfBoundsExceptione ) {
 * use multi catch to handle exceptions in the same block
 */
		} catch (FileNotFoundException e ) {

		} catch (ArrayIndexOutOfBoundsException ex) {

		}
	}
}


