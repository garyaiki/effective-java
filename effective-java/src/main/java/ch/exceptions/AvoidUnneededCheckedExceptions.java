package ch.exceptions;

import static com.google.common.base.Preconditions.checkArgument;

import java.math.BigInteger;

/* Item 59
 * 
 * Checking preconditions allows using unchecked exceptions when exception wouldn't be thrown when precondition met
 */
public class AvoidUnneededCheckedExceptions {
	
	public BigInteger mod(BigInteger m) { // checkArgument throws runtime exception if expression is false
		checkArgument(m.signum() <= 0, "Descriptive error message");
		
		return m;
	}

}
