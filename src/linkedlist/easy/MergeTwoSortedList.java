package linkedlist.easy;

public class MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null&&l2==null)
			return l1;
		else if(l1==null)
			return l2;
		
		ListNode dummy = new ListNode(0);
		dummy.next = l1;
		ListNode pre = dummy;
		ListNode head1 = l1;
		ListNode head2 = l2;
		while(l1!=null&&l2!=null){
			if(l2.val<l1.val){
				ListNode tmp = l2.next;
				l2.next = pre.next;
				pre.next = l2;			
				l2 = tmp;
			}else{
				l1 = l1.next;
			}
			pre = pre.next;
		}
		if(l2!=null){
			pre.next = l2;
		}
		return dummy.next;
	}
}
