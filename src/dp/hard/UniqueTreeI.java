package dp.hard;

public class UniqueTreeI {
	public int numTrees(int n) {
		if (n <= 0)
			return 0;
		int[] memo = new int[n + 1];
		memo[0] = memo[1] = 1;
		for (int i = 2	; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				memo[i] *=memo[j]*memo[i-1-j];
			}
		}
		return memo[n];
	}
}
