package tree.easy;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		else if(root.left==null&&root.right==null){
			return true;
		}else 
			return helper(root.left, root.right);
		
	}
	
	private boolean helper(TreeNode left, TreeNode right) {
		if(left==null&&right==null)
			return true;
		else if(left==null||right==null)
			return false; // this is necessary for check null pointer for next line!!!
		else if(left.val==right.val&&left!=null&&right!=null)
			return  helper(left.left, right.right)&&helper(left.right, right.left);
		else
			return false;
	}
}
