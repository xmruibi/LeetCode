package tree.hard.dfs;

/**
 * 那么这时候需要调换的元素应该是第一次逆序前面的元素，和第二次逆序后面的元素。
 * 比如1234567,1和5调换了，会得到5234167，逆序发生在52和41，
 * 我们需要把4和1调过来，那么就是52的第一个元素，41的第二个元素调换即可。
 * 
 * @author xmrui_000
 *
 */
public class RecoverTree {

	TreeNode node1 = null, node2 = null, prePtr = null;

	// prePtr is the current pre-node on preorder
	// node1, node2 are the two nodes need to be swap
	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		dfsFinder(root);
		swap(node1, node2);
	}

	// preorder traversal
	private void dfsFinder(TreeNode node) {
		if (node == null)
			return;
		if (node.left != null)
			dfsFinder(node.left);
		if (prePtr != null && prePtr.val > node.val) {
			if (node1 == null)
				node1 = prePtr; // first node in first time reverse order
								// detected
			node2 = node; // second node in reverse order for second time
							// detected
		}
		prePtr = node; // update all the time for prePointer
		dfsFinder(node.right);
	}

	private void swap(TreeNode node1, TreeNode node2) {
		int tmp = node1.val;
		node1.val = node2.val;
		node2.val = tmp;
	}
}
