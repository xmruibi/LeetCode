package linkedlist.medium.sort;


public class InsertionList {
	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode ptr1 = head;
		ListNode ptr2;
		
		while(ptr1!=null){
			ptr2 = ptr1.next;
			while(ptr2!=null){
				if(ptr1.val>ptr2.val){
					int tmp = ptr1.val;
					ptr1.val = ptr2.val;
					ptr2.val = tmp;
				}
				ptr2=ptr2.next;
			}
			ptr1 = ptr1.next;
		}

		return head;
	}
	public static void main(String[] args) {
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(6);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		ListNode node = insertionSortList(n1);
		while(node!=null){
			System.out.print(node.val+"  ");
			node = node.next;
			}
	}
}
