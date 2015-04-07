package array.medium.dp;

public class UniquePathII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] memo = new int[m][n];
		if (obstacleGrid[0][0] == 1)
			return 0;
		memo[0][0] = 1; // assume the start point is not obstacle;
		// initial
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1)
				break;
			memo[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1)
				break;
			memo[0][i] = 1;
		}
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				if (obstacleGrid[i][j] == 1)
					memo[i][j] = 0;
				else
					memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
		return memo[m - 1][n - 1];
	}

	private int reduceDimension(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0
				|| obstacleGrid[0].length == 0)
			return 0;
		if (obstacleGrid[0][0] == 1)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] memo = new int[n + 1];
		memo[0] = 1;
		for (int i = 0; i < m; i++)
			for (int j = 1; j <= n; j++) {
				if(obstacleGrid[i][j]==1)
					memo[j]=0; // notice here should be zero!!
				else
					memo[j] +=memo[j-1];
			}
		return memo[n];
	}
}
