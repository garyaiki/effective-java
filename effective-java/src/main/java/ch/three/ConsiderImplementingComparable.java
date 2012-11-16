package ch.three;
import com.google.common.collect.ComparisonChain;

public class ConsiderImplementingComparable implements Comparable<ConsiderImplementingComparable>{


/* Item 12
 * 
 * A Natural ordering is like 1 7 10
 * An alphanumeric ordering is 1 10 7
 * return -1 0 1
 * Recommended that x.compareTo(y) == 0 then x.equals(y) COMMENT WHEN OTHERWISE
 */
	
	private String x;
	private String y;
	private String z;
	
	@Override //Guava lazy comparison, stops on first non zero comparison
	public int compareTo(ConsiderImplementingComparable o) {
		return ComparisonChain.start().compare(x, o.x).compare(y, o.y).compare(z, o.z).result();
	}
}
