package ch.commonmethods;
import com.google.common.base.Objects;

public class OverrideToString {
	/* Item 10
	 * called automatically when passed to println, concat operator "+", assert, debugger
	 * + when practical, return all interesting information in object
	 * + if too large summarize 
	 * + provide programmatic access to all elements in toString
	 *  
	 * Scala "case" class auto-generates equals, hashCode, toString

	 */
	private String x;
	private String y;
	private String z;
	
	
	@Override
	public String toString() {
		//return "OverrideToString [x=" + x + ", y=" + y + ", z=" + z + "]"; Eclipse
		// Guava
		return Objects.toStringHelper(this).omitNullValues().add("x", x).add("y", y).add("z", z).
				toString();
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getZ() {
		return z;
	}
	public void setZ(String z) {
		this.z = z;
	}
	
}
