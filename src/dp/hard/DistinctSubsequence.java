package dp.hard;

public class DistinctSubsequence {
	public int numDistinct(String S, String T) {
		if (T.length() == 0 || T == null)
			return 1;
		if (S.length() == 0 || S == null)
			return 0;

		int[][] memo = new int[S.length() + 1][T.length() + 1];
		// memo[i][j] represent S.substring(i) and T.substring(j);

		// this come first
		for (int j = 0; j <= T.length(); j++)
			memo[S.length()][j] = 0; // when S="" NO Subsequence exist;
		
		for (int i = 0; i <= S.length(); i++)
			memo[i][T.length()] = 1; // when T="" all S have one subsequence


		for (int i = S.length() - 1; i >= 0; i--) 
			for (int j = 0; j < T.length(); j++) 
				memo[i][j] = (S.charAt(i) == T.charAt(j) ? memo[i + 1][j + 1]
						: 0) + memo[i + 1][j];

		return memo[0][0];
	}
}
