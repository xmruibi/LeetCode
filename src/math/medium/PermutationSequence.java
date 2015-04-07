package math.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public static String getPermutation(int n, int k) {

		List<Integer> nums = new ArrayList<Integer>();
		int[] fact = new int[n];
		// initial list
		for (int i = 1; i <= n; i++) {
			nums.add(i);
			if (i == 1)
				fact[i - 1] = 1;
			else
				fact[i - 1] = fact[i - 2] * i;
		}
		StringBuilder sb = new StringBuilder();
		k -= 1;
		for (int i = 0; i < n-1; i++) {
			int idx = k / fact[n - i - 2]; // n-i-2? due to array index -1 once, and due to get (n-1)! -1 again
			sb.append(nums.get(idx));
			nums.remove(idx);
			k = k % fact[n - i - 2];
		}
		sb.append(nums.get(0)); // one number still left in list
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getPermutation(5, 5));
	}
}
