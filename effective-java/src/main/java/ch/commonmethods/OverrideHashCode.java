package ch.commonmethods;
import com.google.common.base.Objects;

public class OverrideHashCode {
	/* Item 9 always override hashCode if equals is overridden. 
	 * This is necessary for use in hash based collections
	 * Must be consistent in application scope
	 * equals() -> equal hashCode MOST IMPORTANT this is the contract 
	 * !equals() Does not require equal hashCode But it is preferred
	 * 
	 *  
	 * Scala "case" class auto-generates equals, hashCode, toString

	 */
	private String x;
	private String y;
	private String z;
	
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
	@Override // Guava handles null
	public int hashCode() {

		return Objects.hashCode(getX(), getY(), getZ()); 
	}
	

}
