package array.medium.treeConstruction;

import java.util.HashMap;
import java.util.Map;

public class PreInOrderConstruction {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//
		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);
		return helper(map, preorder, inorder, 0, preorder.length - 1, 0,
				inorder.length - 1);
	}

	private TreeNode helper(Map<Integer, Integer> map, int[] preorder,
			int[] inorder, int preL, int preR, int inL, int inR) {
		TreeNode node = new TreeNode(preorder[preL]);
		int idx = map.get(preorder[preL]);
		node.left = helper(map, preorder, inorder, preL + 1, preL + idx - inL,
				inL, idx - 1);
		node.right = helper(map, preorder, inorder, preL + idx - inL + 1, preR,
				idx + 1, inR);

		return node;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}