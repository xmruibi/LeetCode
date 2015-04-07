package tree.easy;

public class BalancedTree {
    public static boolean isBalanced(TreeNode root) {
        if(root==null)
        	return true;
        return Math.abs(helper(root.left)-helper(root.right))<=1;
    }
    
    private  static int helper(TreeNode root) {
    	if(root==null)
    		return 0;
    	else if(root.left==null&&root.right==null){
    		return 1;
    	}else if(root.left==null&&root.right!=null){
    		return helper(root.right)+1;
    	}else{
    		return helper(root.left)+1;
    	}
	}
    
    
    // test case
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(5);
		n1.left = n2;
		n2.left = n3;
		n2.right = n4;
		n3.left=n5;
		n5.left = n6;
		System.out.println(isBalanced(n1));
	}
  
}
