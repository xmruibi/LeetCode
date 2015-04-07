package linkedlist.medium;

public class AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode res = new ListNode(0);
		ListNode dummy = res;
		int carry = 0;
		while (l1 != null || l2 != null || carry > 0) {
			int cur = carry;
			if (l1 != null) {
				cur += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				cur += l2.val;
				l2 = l2.next;
			}

			ListNode curnode = new ListNode(cur % 10);
			carry = cur / 10;
			res.next = curnode;
			res = res.next;
		}
		return dummy.next;
	}
}
