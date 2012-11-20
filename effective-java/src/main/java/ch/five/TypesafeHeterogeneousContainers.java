package ch.five;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

/* Item 29
 * 
 */
public class TypesafeHeterogeneousContainers {
	
	// Guava TypeToken keeps type at runtime
	TypeToken<String>stringTok = TypeToken.of(String.class);
	TypeToken<List<String>>stringListTok = new TypeToken<List<String>>() {};
	TypeToken<Map<?,?>>wildMapTok = new TypeToken<Map<?,?>>() {};
	
	static <K,V> TypeToken<Map<K,V>> mapToken(TypeToken<K>keyToken, TypeToken<V>valueToken) {
		return new TypeToken<Map<K,V>>() {}.where(new TypeParameter<K>() {}, keyToken).
				where(new TypeParameter<V>() {}, valueToken);
	}
	
	static void useMapToken() { 
		TypeToken<Map<String, BigInteger>> mapToken = mapToken(
				TypeToken.of(String.class),TypeToken.of(BigInteger.class));
		System.out.println(mapToken); // "java.util.Map<java.lang.String, java.math.BigInteger>"
	}
	
	public static void main(String[] args) {
		useMapToken();
	}
}
