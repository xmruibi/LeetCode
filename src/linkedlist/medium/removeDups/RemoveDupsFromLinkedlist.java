package linkedlist.medium.removeDups;


public class RemoveDupsFromLinkedlist {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null||head.next==null)
    		return head;
    	
    	ListNode dummy = head;
    	while(dummy!=null&&dummy.next!=null){
    		while(dummy.next!=null&&dummy.val==dummy.next.val){
    			dummy.next = dummy.next.next;
    		}
    		dummy = dummy.next;
    	}
    	
    	return head;
    }
}
