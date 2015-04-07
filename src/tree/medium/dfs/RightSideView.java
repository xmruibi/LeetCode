package tree.medium.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int curLevel = 1;
		int nextLevel = 0;
		int levelEnd;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			levelEnd = cur.val;
			curLevel--;
			if (cur.left != null) {
				queue.add(cur.left);
				nextLevel++;
			}

			if (cur.right != null) {
				queue.add(cur.right);
				nextLevel++;
			}

			if (curLevel == 0) {
				res.add(levelEnd);
				curLevel = nextLevel;
				nextLevel = 0;
			}
		}
		
		return res;
	}
}
