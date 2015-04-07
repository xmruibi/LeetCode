package tree.medium.dfs;

import java.util.List;
import java.util.ArrayList;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		List<Integer> cur = new ArrayList<Integer>();
		cur.add(root.val);
		helper(res, cur, root, sum - root.val);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> cur,
			TreeNode node, int curVal) {
		if (node == null)
			return;
		if (node.left == null && node.right == null && curVal == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		if (node.left != null) {
			cur.add(node.left.val);
			helper(res, cur, node.left, curVal - node.left.val);
			cur.remove(cur.size()-1);
		}
		if (node.right != null) {
			cur.add(node.right.val);
			helper(res, cur, node.right, curVal - node.right.val);
			cur.remove(cur.size()-1);
		}
	}
}
