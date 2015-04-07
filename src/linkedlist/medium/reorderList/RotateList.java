package linkedlist.medium.reorderList;


public class RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
	    ListNode fast=dummy,slow=dummy;

	    int i;
	    for (i=0;fast.next!=null;i++)//Get the total length 
	        fast=fast.next;

	    for (int j=i-k%i;j>0;j--) //Get the i-n%i th node
	        slow=slow.next;

	    fast.next=dummy.next; //Do the rotation
	    dummy.next=slow.next;
	    slow.next=null;

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
		n2.next=null;
		
		ListNode node= rotateRight(n1, 2);
		while(node!=null){
		System.out.print(node.val+"  ");
		node = node.next;
		}
	}
}
