package array.medium.dp;

public class MinimalPath {
	public static int minPathSum(int[][] grid) {

		if (grid.length == 0 || grid == null)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;
				else if (i == 0 || j == 0)
					grid[i][j] += ((i == 0) ? grid[i][j - 1] : grid[i - 1][j]);
				else
					grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] num = { { 1, 2, 1 }, { 2, 3, 1 }, { 1, 2, 1 } };
		System.out.println(minPathSum(num));
	}
}
