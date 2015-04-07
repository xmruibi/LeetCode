package tree.medium.constructTree;

public class PopulatingNextRightPointer {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode lineHead = root;
		TreeLinkNode cur = root;
		while (cur != null) {
			lineHead = cur.left;
			TreeLinkNode pre;
			while (cur.next != null) {
				lineHead = cur.left;
				while (cur!= null) {
					if (cur.left != null && cur.right != null)
						cur.left.next = cur.right;
					if ( cur.right != null&&cur.next != null) // check null 
						cur.right.next = cur.next.left;
					cur = cur.next;
				}
				cur = lineHead;
			}
			cur = lineHead;
		}
	}
}
