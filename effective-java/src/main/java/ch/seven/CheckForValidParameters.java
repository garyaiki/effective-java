package ch.seven;

import static com.google.common.base.Preconditions.checkArgument;

import java.math.BigInteger;

/* Item 38
 * Guava add Preconditions to Java -> Editor -> Content Assist -> Favorites for code completion
 * 
 */
public class CheckForValidParameters {
	public BigInteger mod(BigInteger m) {
		checkArgument(m.signum() <= 0);
		checkArgument(m.signum() <= 0, "Descriptive error message");
		
		return m;
	}
}
