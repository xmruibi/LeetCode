package bitManipulation.medium;

public class SingleNumberII {
	public static int singleNumber(int[] A) {
		int[] memo = new int[32];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < 32; j++) {
				int cur = A[i] >> j;
				memo[j] += (cur & 1);
			}
		}
		int res =0;
		for (int i = 0; i < 32; i++) {
			if(memo[i]%3!=0)
				res|=1<<i;
		}		
		return res;
	}
	
	public static void main(String[] args) {
		int[] num = {1,1,2,2,1,2,3,3,3,4,5,5,5,6,6,6,7,7,7};
		System.out.println(singleNumber(num));
	}
}
