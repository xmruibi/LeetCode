package dp.hard;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {

		int m = s1.length();
		int n = s2.length();
		boolean[][] memo = new boolean[m + 1][n + 1];
		memo[0][0] = true;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i > 0)
					memo[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) ? memo[i - 1][j]
							: false;
				if (j > 0)
					memo[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) ? memo[i][j - 1]
							: memo[i][j];
			}
		}
		return memo[m][n];
	}
}
