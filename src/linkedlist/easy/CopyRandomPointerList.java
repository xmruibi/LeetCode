package linkedlist.easy;

public class CopyRandomPointerList {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode dummy = head;
		// clone each node after itself
		while (head != null) {
			RandomListNode clone = new RandomListNode(head.label);
			clone.next = head.next;
			head.next = clone;
			head = clone.next;
		}
		// copy random pointer
		head = dummy;
		while (head != null) {
			RandomListNode clone = head.next;
			if (head.random != null)
				clone.random = head.random.next;
			head = clone.next;
		}
		// remove the original nodes
		head = dummy;
		RandomListNode cloneDummy = dummy.next; // record the clone list head
		while (head != null) {
			RandomListNode clone = head.next;
			head.next  = clone.next;
			if (clone.next != null)
				clone.next = head.next.next;
			head = head.next;
		}
		return cloneDummy;

	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}