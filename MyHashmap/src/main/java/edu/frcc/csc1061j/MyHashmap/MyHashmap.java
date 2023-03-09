package edu.frcc.csc1061j.MyHashmap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyHashmap<K, V> implements Map<K, V> {

	private static final int INITIAL_NUM_BUCKETS = 4; // This will be the initial size of our hashmap

	private int size = 0; // This will track
	private double loadFactorThreshold = 0.5; // whenver the current size is half full we reach threshold
	private LinkedList<Entry<K, V>>[] buckets;

	private static class Entry<K, V> implements Map.Entry<K, V> {

		K key;
		V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V prevV = this.value;
			this.value = value;
			return prevV;
		}

	}

	public MyHashmap() {
		buckets = new LinkedList[INITIAL_NUM_BUCKETS];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public boolean containsKey(Object key) {
		if (get(key) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		if (buckets != null) {
			for (LinkedList<Entry<K, V>> list : buckets) { // TODO still gotta check if it ignores null lists
				if (list != null) {
					for (Entry<K, V> entry : list) {
						if (entry.getValue().equals(value)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length; // This finds the index of the bucket(hashindex)
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		for (Entry<K, V> entry : bucket) { // TODO what happens when a list is null
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length; // This finds the index of the bucket(hashindex)
		// This assigns bucket with the specific bucket at the hashindex
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		// if there is not a bucket there, then we create a new linked list and add it
		// to buckets
		if (bucket == null) {
			bucket = new LinkedList<Entry<K, V>>();
			buckets[bucketIndex] = bucket;
		}
		for (Entry<K, V> entry : bucket) {
			// This is for the case where there is a preexisting key
			if (entry.getKey().equals(key)) {
				V oldValue = entry.getValue();
				entry.setValue(value);
				return oldValue;
			}
		}
		bucket.add(new Entry<K, V>(key, value));
		size++;
		// TODO Homework 1
		// check if load factor has exceeded the threshold
		// Take action if it has, rehash()
		return value;
	}

	// Homework 2
	private void rehash() {

	}

	@Override
	public V remove(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length; // This finds the index of the bucket(hashindex)
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		if (bucket != null) {
			for (int i = 0; i < bucket.size(); i++) { // TODO what happens when a list is null
				if (bucket.get(i).getKey().equals(key)) {
					V prevV = bucket.get(i).getValue();
					bucket.remove(bucket.get(i));
					size--;
					return prevV;
				}
			}
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		size = 0;
		for (LinkedList<Entry<K, V>> bucket : buckets) {
			bucket = null;
		}

	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		if (buckets != null) {
			for (LinkedList<Entry<K, V>> list : buckets) {
				if (list != null) {
					for (Entry<K, V> entry : list) {
						//This adds the key
						set.add(entry.getKey());
					}
				}
			}
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
		if (buckets != null) {
			for (LinkedList<Entry<K, V>> list : buckets) { // TODO still gotta check if it ignores null lists
				if (list != null) {
					for (Entry<K, V> entry : list) {
						set.add(entry);
					}
				}
			}
		}
		return set;
	}

}
