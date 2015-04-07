package stack.hard;

public class TrappingWater {
	public static int trap(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int[] container = new int[A.length];
		container[0] = 0;
		int leftMax = A[0];
		for (int i = 1; i < A.length; i++) {
			container[i] = leftMax;
			leftMax = Math.max(leftMax, A[i]);
		}
		int res = 0;
		int rightMax = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			container[i] = Math.min(container[i], rightMax);
			rightMax = Math.max(rightMax, A[i]);
			res += ((container[i] - A[i]) > 0 ? (container[i] - A[i]) : 0);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println(trap(A));
	}
}
