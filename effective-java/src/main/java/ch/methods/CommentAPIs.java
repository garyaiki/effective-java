package ch.methods;
/* Item 44
 * Javadoc EVERY exported class, interface, constructor, method, and field declaration
 * 
 * Comment for a method should describe contract between method and client
 */
public class CommentAPIs {

	/*
	 * First sentence is summary description of the element. A period'.' terminates the summary description
	 * Periods within the first sentence should use {@literal X. Y.}
	 * To avoid confusion No 2 members should have the same summary description.
	 * Use {@code} for code in javadoc
	 * {@code index < 0 || index >= this.size()}
	 * 
	 * Multiline code use
	 * <pre>{@code index < 0 
	 * || index >= this.size()}</pre>
	 * 
	 * HTML metacharacters use
	 * {@literal |x + y | < |x| + |y|}
	 */
	
	/*
	 * Document generic parameters
	 * 
	 * @param <K>...
	 * @param <V>...
	 */
	public interface Map<K,V> {}
	// comment enum element constants too
	public enum Type { ANNUAL /* Annual... */, PERENNIAL /* Perenial... */ }
	
	/* document annotation and annotation's member's */
	
	/* package level comments belong in package-info.java */
	
	// comment on thread saftey 
	
	/* Javadoc will inherit comments if none provided
	Explicitly inherit comment with {@inheritDoc} tag - Insert the inline tag {@inheritDoc} 
	in a method main description or @return, @param or @throws tag comment -- the corresponding 
	inherited main description or tag comment is copied into that spot.
			The source file for the inherited method need only be on the path specified by -sourcepath 
			for the doc comment to actually be available to copy. Neither the class nor its package needs 
			to be passed in on the command line.
	*/
}
