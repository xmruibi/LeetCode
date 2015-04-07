package dp.hard;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {

		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] memo = new int[m][n];

		// initial stage :
		// bottom right point:
		memo[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1
				: -dungeon[m - 1][n - 1] + 1;
		// bottom right edge:
		// initial right and bottom edge
		for (int i = m - 2; i >= 0; i--)
			memo[i][n - 1] = Math.max(memo[i + 1][n - 1] - dungeon[i][n - 1], 1);

		for (int i = n - 2; i >= 0; i--)
			memo[m - 1][i] = Math.max(memo[m - 1][i+1] - dungeon[m - 1][i], 1);

		// start dp
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				memo[i][j] = Math.max(Math.min(memo[i + 1][j], memo[i][j + 1]),
						1) - dungeon[i][j];
			}
		}
		return memo[0][0];
	}
}
