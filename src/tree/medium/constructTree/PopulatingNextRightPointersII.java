package tree.medium.constructTree;

public class PopulatingNextRightPointersII {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode lastHead = root; // last level head node(the parent of
										// current node)
		TreeLinkNode pre = null; // current previous pointer
		TreeLinkNode curHead = null; // current level head node

		while (lastHead != null) {
			TreeLinkNode lastCur = lastHead;
			while (lastCur != null) { 
				// in this while loop, nodes are made up in the same line
				// each time to make sure the curhead is null or not null
				// assign curHead once current node has child
				if (lastCur.left != null) {
					if (curHead == null) {
						curHead = lastCur.left;
						pre = curHead;
					} else {
						pre.next = lastCur.left;
						pre = pre.next;
					}
				}				
				if (lastCur.right != null) {
					if (curHead == null) {
						/**
						 *  for situation: 
						 *            O (lastCur)   --->        O
						 *         /      \                         /      \
						 *    null        O(nextHead)   O         O
						 */
						curHead = lastCur.right;
						pre = curHead;
					} else {
						// this is normal case;
						pre.next = lastCur.right;
						pre = pre.next;
					}
				}
				lastCur = lastCur.next; // change to next parent
			}
			//  do next line
			lastHead = curHead;
			curHead=null;
		}

	}
}
