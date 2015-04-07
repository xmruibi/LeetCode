package linkedlist.medium.reorderList;

public class ReorderList {
	public static void reorderList(ListNode head) {
        if(head==null||head.next==null)
        	return;
        
        ListNode pre = head;
        
        while(pre.next!=null&&pre.next.next!=null){
        	ListNode tailPtr = getTail(pre);
        	tailPtr.next.next = pre.next;
        	pre.next = tailPtr.next;
        	tailPtr.next = null;
        	pre = pre.next.next;
        }
    }
	
	private static ListNode getTail(ListNode node) {
		if(node==null||node.next==null)
			return node;
		while(node.next!=null&&node.next.next!=null){
			node = node.next;
		}
		return node;
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
		n3.next= null;
		
		reorderList(n1);;
		while(n1!=null){
		System.out.print(n1.val+"  ");
		n1 = n1.next;
		}
	}
}
