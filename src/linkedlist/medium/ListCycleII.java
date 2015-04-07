package linkedlist.medium;

public class ListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode slower = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null) {
			runner = runner.next.next;
			slower = slower.next;
			if (runner == slower){
				slower=head;
				while (slower != runner) {
					slower = slower.next;
					runner = runner.next;
				}
				return slower;
			}
		}
		return null;
	}
}
