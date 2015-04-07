package linkedlist.easy;

public class InsertionTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		int lenA = 0;
		int lenB = 0;
		ListNode alen = headA;
		ListNode blen = headB;
		while (alen != null) {
			alen = alen.next;
			lenA++;
		}
		while (blen != null) {
			blen = blen.next;
			lenB++;
		}
		ListNode ahead = headA;
		ListNode bhead = headB;
		while (ahead != null&&lenA > lenB){
			ahead = ahead.next;lenA--;
		}

		while (bhead != null&&lenB > lenA){
			bhead = bhead.next;
		    lenB--;
		}

		while (ahead != null && bhead != null) {
			if (ahead == bhead)
				return ahead;
			ahead = ahead.next;
			bhead = bhead.next;
		}
		return null;
	}
}
