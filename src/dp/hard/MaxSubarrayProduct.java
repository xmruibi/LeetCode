package dp.hard;

public class MaxSubarrayProduct {
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		if(A.length==1)
			return A[0];
		int maxPos = A[0];
		int maxNeg = A[0];
		int global = A[0];
		for (int i = 1; i < A.length; i++) {
			int tmp = maxPos;
			maxPos = Math.max(maxPos * A[i], Math.max(maxNeg * A[i], A[i]));
			maxNeg = Math.min(maxNeg * A[i], Math.min(tmp * A[i], A[i]));
			global = Math.max(maxPos, global);
		}
		return global;
	}
}
