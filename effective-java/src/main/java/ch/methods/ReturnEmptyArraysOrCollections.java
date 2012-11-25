package ch.methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* Item 43
 * Arrays of zero length are immutable so they can be shared freely
 * null arrays are a holdover from C
 * 
 * There is no reason ever to return null from an array or collection instead of returning an
 * empty array or collection
 */

public class ReturnEmptyArraysOrCollections {
	private final List<String> cheesesInStock = new ArrayList<String>();
	
	private static final String[] EMPTY_CHEESE_ARRAY = new String[0];
	
	// right way to return an array from a collection
	public String[] getCheeses() {
		return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
	}
	
	// right way to return a copy of a collection
	public List<String> getCheeseList() {
		if(cheesesInStock.isEmpty()) {
			return Collections.emptyList();
		} else {
			return new ArrayList<String>(cheesesInStock);
		}
	}
}
