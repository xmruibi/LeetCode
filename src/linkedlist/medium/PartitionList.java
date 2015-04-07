package linkedlist.medium;

public class PartitionList {
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;

		ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);
		ListNode dumL = left;
		ListNode dumR = right;

		while (head != null) {
			if (head.val < x) {
				left.next = head;
				left = head;
			} else {
				right.next = head;
				right = head;
			}
			head = head.next;
		}
		left.next = dumR.next;
		right.next = null;
		return dumL.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(6);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode node = partition(n1, 3);
		while(node!=null){
			System.out.print(node.val+"  ");
			node = node.next;
			}
	}
}
