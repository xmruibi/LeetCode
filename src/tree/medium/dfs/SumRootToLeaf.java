package tree.medium.dfs;

import java.util.ArrayList;
import java.util.List;


public class SumRootToLeaf {

	public static int sumNumbers(TreeNode root) {
		if(root==null)
			return 0;
		List<Integer> sum =new ArrayList<Integer>();
		helper(sum, 0, root);
		int res =0;
		for(int i:sum)
			res+=i;
		return res;
	}

	private static void helper(List<Integer> sum, int curNum, TreeNode node) {
		curNum = curNum * 10 + node.val;
		if (node.left == null && node.right == null) {
			sum.add(curNum);
			return;
		}
		if (node.left != null) {
			helper(sum, curNum, node.left);
		}
		if (node.right != null) {
			helper(sum, curNum, node.right);
		}
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
		System.out.println(sumNumbers(n1));
	}
}
