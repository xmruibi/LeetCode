package linkedlist.medium.sort;

public class SortList {
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// partition
		ListNode left = head;
		ListNode runner = head;
		ListNode slower = head;
		while (runner.next != null && runner.next.next != null) {
			runner = runner.next.next;
			slower = slower.next;
		}
		ListNode right = slower.next;
		slower.next = null;

		ListNode pleft = sortList(left);
		ListNode pright = sortList(right);
		return merge(pleft, pright);
	}

	private static ListNode merge(ListNode pleft, ListNode pright) {
		if(pleft==null)
			return pright;
		if(pright==null)
			return pleft;
		ListNode node = new ListNode(0);
		node.next = pleft;
		ListNode pre = node;
		while(pleft!=null&&pright!=null){
			if(pleft.val>pright.val){
				ListNode tmp =pright.next;
				pre.next = pright;
				pright.next = pleft;
				pright = tmp;
			}else
				pleft = pleft.next;
			pre = pre.next;
		}
		if(pright!=null)
			pre.next = pright;
		return node.next;
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
		ListNode node = sortList(n1);
		while(node!=null){
			System.out.print(node.val+"  ");
			node = node.next;
			}
	}
}
