package linkedlist.medium.reorderList;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null||head.next==null)
			return head;
		
		ListNode headPtr = head;
		
		while(headPtr!=null&&m>1){
			headPtr = headPtr.next;
		}
		if(headPtr==null&&headPtr.next==null)
			return head;
		ListNode pre = headPtr.next;
		ListNode cur = pre.next;
		while(cur==null&&cur.next==null&&n>m){
			ListNode next = cur.next;
			next.next = headPtr.next;
			headPtr.next = cur;
			pre.next = next;
			pre = cur;
			cur = next;
			n--;
		}
		
		return head;
	}
}
