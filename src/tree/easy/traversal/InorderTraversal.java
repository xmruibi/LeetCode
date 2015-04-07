package tree.easy.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (stack.peek().left != null) {
			stack.push(stack.peek().left);
		}
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			res.add(node.val);
			if(node.right!=null){
				stack.push(node.right);
				while(stack.peek().left!=null){
					stack.push(stack.peek().left);
				}
			}
		}
		return res;
    }
}
