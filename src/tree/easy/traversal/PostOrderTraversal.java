package tree.easy.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

	/**
	 * 1.1 Create an empty stack
	 * 
	 * 2.1 Do following while root is not NULL a) Push root's right child and
	 * then root to stack. b) Set root as root's left child.
	 * 
	 * 2.2 Pop an item from stack and set it as root. a) If the popped item has
	 * a right child and the right child is at top of stack, then remove the
	 * right child from stack, push the root back and set root as root's right
	 * child. b) Else print root's data and set root as NULL.
	 * 
	 * 2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		do {
			while (root != null) {
				if (root.right != null)
					stack.push(root.right);
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			if (!stack.isEmpty()&&root.right != null && root.right == stack.peek()) {
				stack.pop();
				stack.push(root);
				root = root.right;
			} else {
				res.add(root.val);
				root = null;
			}
		} while (!stack.isEmpty());

		return res;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.right = n2;
		System.out.println(postorderTraversal(n1));
	}
}
