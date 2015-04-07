package linkedlist.medium.reorderList;


public class SwapNodesInPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = new ListNode(0);
		ListNode dummy = pre;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			ListNode next = cur.next;
			pre.next = next;
			cur.next = next.next;
			next.next = cur;	
			pre = cur;
			cur = cur.next;;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next=n3;
		n3.next=n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode node= swapPairs(n1);
		while(node!=null){
		System.out.print(node.val+"  ");
		node = node.next;
		}
		
	}
}
