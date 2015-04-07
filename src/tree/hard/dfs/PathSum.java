package tree.hard.dfs;


public class PathSum {

	int maxVal;

	public int maxPathSum(TreeNode root) {
		maxVal = Integer.MIN_VALUE;
		helper(root, maxVal);
		return maxVal;
	}

	private int helper(TreeNode node, int maxVal) {
		if (node == null)
			return 0;

		int left = helper(node.left, maxVal);
		int right = helper(node.right, maxVal);
		int passArch = left + right + node.val;
		int nopass = Math.max(node.val, Math.max(right, left) + node.val);

		maxVal = Math.max(maxVal, Math.max(passArch, nopass));
		return nopass;
	}
}
