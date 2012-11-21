package ch.six;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Item 33
 * 
 */
public class EnumMapOverOrdinalIndexing {
	
	static public void main(String[] args) {
		Map<Herb.Type, Set<Herb>> herbsByType =
				new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
		for(Herb.Type t : Herb.Type.values()) {
			herbsByType.put(t, new HashSet<Herb>());
		}
		
	}

}
