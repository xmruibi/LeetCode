package tree.easy.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left=n5;
		n3.right = n6;
		System.out.println(preorderTraversal(n1));
	}
}
