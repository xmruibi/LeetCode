package array.medium.dp;

import java.util.Random;

public class UniquePath {
	public static int uniquePaths(int m, int n) {
		int[][] memo = new int[m][n];
		memo[0][0] = 1;
		// initial
		for (int i = 0; i < m; i++)
			memo[i][0] = 1;
		for (int i = 0; i < n; i++)
			memo[0][i] = 1;

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				memo[i][j] = memo[i - 1][j] + memo[i][j - 1];

		return memo[m - 1][n - 1];
	}

	private static int reduceDimension(int m, int n) {
		// TODO Auto-generated method stub
		int[] memo = new int[n];
		memo[0] = 1;
		for (int i = 0; i < m; i++)
			for (int j = 1; j < n; j++)
				memo[j] += memo[j - 1];

		return memo[n - 1];
	}

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int m = 1 + r.nextInt(10);
			int n = 1 + r.nextInt(10);
			System.out.println(uniquePaths(m, n) == reduceDimension(m, n));
		}
	}
}
