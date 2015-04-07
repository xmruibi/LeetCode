package array.medium.treeConstruction;

import java.util.HashMap;
import java.util.Map;

public class PostInOrderConstruction {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//
		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);
		return helper(map, postorder, inorder, 0, postorder.length - 1, 0,
				inorder.length - 1);
	}

	private TreeNode helper(Map<Integer, Integer> map, int[] postOrder,
			int[] inorder, int postL, int postR, int inL, int inR) {
		TreeNode node = new TreeNode(postOrder[postR]);
		int idx = map.get(postOrder[postR]);
		node.left = helper(map, postOrder, inorder, postL, postL + idx - inL
				- 1, inL, idx - 1);
		node.right = helper(map, postOrder, inorder, postR + idx - inL,
				postR - 1, idx + 1, inR);

		return node;
	}
}
