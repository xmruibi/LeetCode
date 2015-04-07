package datastructure.hard;

import java.util.HashMap;

public class LRUCache {
	private final HashMap<Integer, Integer> map;
	private final DoublyLinkedList list;
	private final int capacity;

	public LRUCache(int capacity) {
		map = new HashMap<Integer, Integer>();
		list = new DoublyLinkedList();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (list.getNode(key) != null)
			return list.getNode(key).val;
		else
			return -1;
	}

	public void set(int key, int value) {
		if (list.size + 1 > capacity)
			map.remove(list.removeTail());
		if (list.removeCurNode(key))
			map.put(key, value);
		list.add(key);
	}
}

class DoublyLinkedList {
	ListNode head;
	ListNode tail;
	int size;

	public DoublyLinkedList() {
		head = new ListNode(0);
		tail = new ListNode(0);
	}

	// add to head
	public void add(int val) {
		ListNode node = new ListNode(val);
		ListNode tmp = head.next;
		head.next = node;
		node.next = tmp;
		node.prev = head;
		tmp.prev = node;
		size++;
	}

	public ListNode getNode(int val) {
		ListNode node = head.next;
		while (node != tail) {
			if (node.val == val)
				return node;
		}
		return null;
	}

	public boolean removeCurNode(int val) {
		ListNode node = getNode(val);
		if (node != null) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			size--;
			return true;
		}
		return false;
	}

	// remove from tail
	public int removeTail() {
		ListNode node = tail.prev;
		node.prev.next = tail;
		tail.prev = node.prev;
		size--;
		return node.val;
	}

	class ListNode {
		ListNode prev;
		ListNode next;
		int val;

		ListNode(int val) {
			this.val = val;
		}
	}
}
