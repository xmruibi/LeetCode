package tree.medium.constructTree;

public class SortedListToTree {
	
	private ListNode globalPtr;
	public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
        	return null;
        if(head.next==null)
        	return new TreeNode(head.val);
        
        int len = 0;
        ListNode dummy = head;
        while(dummy!=null){
        	dummy=dummy.next;
        	len++;
        }
        globalPtr = head;
        return helper(0, len-1);
    }
	
	private TreeNode helper(int l, int r) {
		if(r<l)
			return null;
		int m = l+((r-l)>>1);
		TreeNode left = helper(l, m);
		TreeNode root = new TreeNode(globalPtr.val);
		globalPtr = globalPtr.next;
		TreeNode right = helper(m+1, r);
		root.left = left;
		root.right = right;
		return root;
	}
}
