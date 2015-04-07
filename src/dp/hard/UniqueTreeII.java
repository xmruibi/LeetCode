package dp.hard;

import java.util.LinkedList;
import java.util.List;

public class UniqueTreeII {
	public List<TreeNode> generateTrees(int n) {
		return generateTree(1, n);
	}

	private List<TreeNode> generateTree(int start, int end) {
		List<TreeNode> list = new LinkedList<>();

		if (start < end) {
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = generateTree(start, i - 1);
			List<TreeNode> rights = generateTree(i + 1, end);

			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode curRoot = new TreeNode(i);
					curRoot.left = left;
					curRoot.right = right;
					list.add(curRoot);
				}
			}
		}
		return list;
	}
}
