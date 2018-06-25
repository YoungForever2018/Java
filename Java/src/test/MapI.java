package test;

import java.util.Collection;
import java.util.Set;

public interface MapI<K,V> {

	int size();
	
	boolean isEmpty();
	
	boolean constainKey(Object key);
	
	boolean constainValue(Object value);
	
	V get(Object key);
	
	V remove(Object key);
	
	V put(K key,V value);
	
	void clear();
	
	void putAll(MapI<? extends K, ? extends V> m);
	
	interface Entry<K,V>{
		K getKey();
		
		V getValue();
		
		V setValue(V value);
		
		boolean equals(Object o);
		
		int hashCode();
		
	}
	
	Set<K> keySet();
	
	Collection<V> values();
	
	Set<MapI.Entry<K, V>> entrySet();
	
}
