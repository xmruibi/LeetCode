package linkedlist.medium.removeDups;

public class RemoveDupsFromLinkedlistII {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (head != null) {
			ListNode tmp = head;
			while (head.next != null&&head.val==head.next.val){
        		head = head.next;
			}
			if(tmp!=head)
        		pre.next = head.next;
        	else
        		pre = head;
        	head=head.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;

		ListNode node = deleteDuplicates(n1);
		while (node != null) {
			System.out.print(node.val + "  ");
			node = node.next;
		}
	}
}
