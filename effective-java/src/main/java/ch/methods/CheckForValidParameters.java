package ch.methods;

import static com.google.common.base.Preconditions.checkArgument;

import java.math.BigInteger;

import com.google.common.collect.Ranges;
import com.google.common.primitives.Ints;

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
	
	public void rangeExamples() {
		Ranges.closed(1, 3).contains(2); // returns true
		Ranges.closed(1, 3).contains(4); // returns false
		Ranges.lessThan(5).contains(5); // returns false
		Ranges.closed(1, 4).containsAll(Ints.asList(1, 2, 3)); // returns true
		
		Ranges.closedOpen(4, 4).isEmpty(); // returns true
		Ranges.openClosed(4, 4).isEmpty(); // returns true
		Ranges.closed(4, 4).isEmpty(); // returns false
		Ranges.open(4, 4).isEmpty(); // Ranges.open throws IllegalArgumentException

		Ranges.closed(3, 10).lowerEndpoint(); // returns 3
		Ranges.open(3, 10).lowerEndpoint(); // returns 3
		Ranges.closed(3, 10).lowerBoundType(); // returns CLOSED
		Ranges.open(3, 10).upperBoundType(); // returns OPEN
	}
}
