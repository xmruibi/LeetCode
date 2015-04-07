package tree.easy.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int curLevel = 1;
		int nextLevel = 0;
		queue.add(root);
		List<Integer> cur = new  ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.remove();
			curLevel--;
			cur.add(curNode.val);
			if (curNode.left != null) {
				queue.add(curNode.left);
				nextLevel++;
			}
			if (curNode.right != null) {
				queue.add(curNode.right);
				nextLevel++;
			}
			if(curLevel==0){
				res.add(0,cur);
				cur = new ArrayList<Integer>();
				curLevel = nextLevel;
				nextLevel = 0;
			}	
		}
		
		return res;
	}
}
