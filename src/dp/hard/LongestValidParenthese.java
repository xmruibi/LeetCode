package dp.hard;

public class LongestValidParenthese {
	public int longestValidParentheses(String str) {
		if (str.length() == 0 || str == null)
			return 0;
		// the memo[i] means the substring from i has the longest parenthese
		int[] memo = new int[str.length()];
		// initial: the last index must have zero length
		memo[str.length() - 1] = 0;
		int max = Integer.MIN_VALUE;
		for (int i = str.length() - 2; i >= 0; i--) {
			// two situation: '(' or ')'
			if (str.charAt(i) != ')') {
				int j = memo[i + 1] + i + 1; // the corresponding position of i
				if (j < str.length() && str.charAt(j) == ')') {
					memo[i] = memo[i + 1] + 2;
					if (j + 1 < str.length()) // after coressponding position still have parenthese
						memo[i] = Math.max(memo[i], memo[j] + memo[i]);
				}
				max = Math.max(memo[i], max);
			}
		}
		return max;
	}
}
