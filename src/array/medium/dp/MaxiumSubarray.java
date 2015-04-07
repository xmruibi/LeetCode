package array.medium.dp;

public class MaxiumSubarray {
	public static int maxSubArray(int[] A) {
		int[][] memo = new int[A.length][A.length];

		for (int i = 0; i < A.length; i++)
			memo[i][i] = A[i];

		for (int i = 0; i < A.length; i++)
			for (int j = 1; j < A.length; j++) {
				memo[i][j] = Integer.MIN_VALUE;
				for (int k = i+1; k <=j; k++) {
					memo[i][j] = Math.max(memo[i][j], memo[i][k-1]+memo[k][j]);
				}
			}
		
		return memo[0][A.length-1];
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5, 4};
		System.out.println(maxSubArray(nums));
	}
}
