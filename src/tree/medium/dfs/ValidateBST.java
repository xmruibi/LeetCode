package tree.medium.dfs;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
	// by  checking inorder traversal
	public boolean isValidBST(TreeNode root) {
	    List<Integer> pre = new ArrayList<Integer>();  
	    pre.add(null);  
	    return helper(pre, root);  
	}

	private boolean helper(List<Integer> pre, TreeNode node){
		if(node==null)
			return true;
		boolean left = helper(pre, node.left);
		
		if(pre.get(0)!=null&&node.val<pre.get(0))
			return false;
		pre.set(0, node.val);
		return left&&helper(pre, node.right);
	}
}
