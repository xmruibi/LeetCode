package tree.easy.traversal;

import java.util.Stack;

/**
 * next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree
 * 
 * @author xmrui_000
 *
 */
public class BSTIterator {

	Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		 stack = new Stack<TreeNode>();
		 if(root!=null)
		     stack.push(root);
		 while(!stack.isEmpty()&&stack.peek().left!=null){
			 stack.push(stack.peek().left);
		 }
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		if(node.right!=null){
			stack.push(node.right);
			 while(!stack.isEmpty()&&stack.peek().left!=null){
				 stack.push(stack.peek().left);
			 }
		}
		return node.val;
	}	
}
