package string.medium;

/**
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 * 
 * Hint: 1. If | n – m | is greater than 1, we know immediately both are not
 * one-edit distance apart. 2. It might help if you consider these cases
 * separately, m == n and m ≠ n. 3. Assume that m is always ≤ n, which greatly
 * simplifies the conditional statements. If m > n, we could just simply swap S
 * and T. 4. If m == n, it becomes finding if there is exactly one modified
 * operation. If m ≠ n, you do not have to consider the delete operation. Just
 * consider the insert operation in T.
 * 
 * @author xmrui_000
 *
 */
public class OneEditDistance {
	public static boolean isOneEditDistance(String s, String t) {
		int m = s.length(), n = t.length();
		if(Math.abs(m-n)>1)
			return false;
		int idx = 0;
		while(idx<Math.min(m, n)&&s.charAt(idx)==t.charAt(idx))
			idx++;
		if(idx==Math.min(n, m))
			return Math.abs(m-n)>0;
		if(Math.abs(m-n)==0)
			idx++; // skip the difference
		while(idx<Math.min(m, n)&&s.charAt(idx)==t.charAt(idx))
			idx++;
		return idx == Math.max(m, n);
	}
	
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("boat", "boat"));
	}
}
