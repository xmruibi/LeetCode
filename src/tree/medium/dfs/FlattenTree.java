package tree.medium.dfs;

public class FlattenTree {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left != null && cur.right != null) {
				TreeNode deepRight = cur.left;
				while (deepRight.right != null) {
					deepRight = deepRight.right;
				}
				deepRight.right = cur.right;
			}
			if (cur.left != null) {
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
	}
}
