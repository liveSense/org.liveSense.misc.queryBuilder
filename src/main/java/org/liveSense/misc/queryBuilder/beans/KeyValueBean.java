package org.liveSense.misc.queryBuilder.beans;

public class KeyValueBean<K, V> {
	K key;
	V value;
	
	public KeyValueBean(K key, V text) {
		setKey(key);
		setText(text);
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setText(V value) {
		this.value = value;
	}
}
