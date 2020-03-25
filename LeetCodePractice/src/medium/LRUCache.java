package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache - Least Recently used cache
 * 
 * References: https://www.youtube.com/watch?v=S6IfqDXWa10
 * 			   https://github.com/bephrem1/backtobackswe/blob/master/Linked%20Lists/LRUCache/LRUCache.java
 * 
 * @author srimeda
 */
public class LRUCache {
	
	/**
	 * Supports Double linked list for O(1) access of cache items.
	 */
	private Map<Integer, ListNode> hashTable = new HashMap<Integer, ListNode>();
	
	private ListNode head;
	private ListNode tail;
	
	private int totalItemsInCache;
	private int maxCapacity;
	
	public LRUCache(int maxCapacity) {
		totalItemsInCache = 0;
		this.maxCapacity = maxCapacity;
		
		head = new ListNode();
		tail = new ListNode();
		
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		ListNode node = hashTable.get(key);
		
		if(node == null) {
			return -1;
		}
		
		moveToHead(node);
		
		return node.value;
	}
	
	public void put(int key, int value) {
		ListNode node = hashTable.get(key);
		
		if(node == null) {
			// Item not found, create a new entry
			ListNode newNode = new ListNode();
			newNode.key = key;
			newNode.value = value;
			
			// add to the hashtable and the actual list that represents the cache
			hashTable.put(key, newNode);
			addToFront(newNode);
			totalItemsInCache++;
			
			//If Over capacity, remove the least recently used item
			if(totalItemsInCache > maxCapacity) {
				removeLeastRecentEntry();
			}
		} else {
			// If the item is found in the cache already, just update it and move it to the head of the list.
			node.value = value;
			moveToHead(node);
		}
	}
	
	private void removeLeastRecentEntry() {
		ListNode tail = popTail();
		hashTable.remove(tail.key);
		--totalItemsInCache;
	}

	private ListNode popTail() {
		ListNode tailItem = tail.prev;
		removeFromList(tailItem);
		return tailItem;
	}

	private void moveToHead(ListNode node) {
		removeFromList(node);
		addToFront(node);
	}

	private void addToFront(ListNode node) {
		node.prev = head;
		node.next = head.next;
		
		head.next.prev = node;
		head.next = node;
	}
	
	private void removeFromList(ListNode node) {
		ListNode savedPrev = node.prev;
		ListNode savedNext = node.next;
		
		savedPrev.next = savedNext;
		savedNext.prev = savedPrev;
	}
	
	/**
	 * List Node Class implementation
	 * 
	 * @author srimeda
	 *
	 */
	private static class ListNode {
		int key;
		int value;
		
		ListNode prev;
		ListNode next;
	}
}
