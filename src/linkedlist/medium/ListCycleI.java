package linkedlist.medium;

public class ListCycleI {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
        	return false;
        
        ListNode slower = head;
        ListNode runner = head;
        
        while(runner!=null&&runner.next!=null){

        	runner = runner.next.next;
        	slower = slower.next;
        	if(runner==slower)
        		return true;
        }   
        return false;
    }
}
