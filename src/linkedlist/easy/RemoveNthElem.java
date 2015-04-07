package linkedlist.easy;

public class RemoveNthElem {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null)
			return head;
		ListNode dummy = head;
		while(dummy!=null&&n>0){
			dummy = dummy.next;
			n--;
		}
		ListNode slower = head;
		if(dummy==null)
			return head.next;
		while(dummy.next!=null){
			slower = slower.next;
			dummy = dummy.next;
		}
		slower.next = slower.next.next;
		return head;
	}
	
	public static void main(String[] args) {
		
	}
}
