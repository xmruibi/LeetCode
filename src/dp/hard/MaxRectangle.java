package dp.hard;

import java.util.Stack;

public class MaxRectangle {
	public int maximalRectangle(char[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;
		int[][] memo = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (j < n - 1 && matrix[i][j] == '1')
					memo[i][j] = memo[i][j + 1] + 1;
				else if (matrix[i][j] == '1')
					memo[i][j] = 1;
				else
					memo[i][j] = 0;
			}
		}
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((m - i) * (n - j) < max)
					break;
				int width = memo[i][j];
				for (int k = i; k < m; k++) {
					if (width * (m - i) < max)
						break;
					width = memo[k][j] > width ? width : memo[k][j];
					max = Math.max(max, width * (k - i));
				}
			}
		}
		return max;
	}

	private int maximalRectStackWay(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int colLen = matrix[0].length;
		int rowLen = matrix.length;
		int maxArea = 0;
		int[] rowHeight = new int[colLen + 1]; // keep current line as histogram
		Stack<Integer> stack;
		for (int row = 0; row < matrix.length; row++) {
			stack = new Stack<Integer>();
			for (int col = 0; col <= matrix[0].length; col++) {
				if (col < matrix[0].length && matrix[row][col] == '1')
					rowHeight[col]++;
				else
					rowHeight[col] = 0;

				/******* Histogram Method ************/
				while (!stack.isEmpty()
						&& rowHeight[col] <= rowHeight[stack.peek()]) {
					int prevIdx = stack.pop();
					int curArea = (stack.isEmpty() ? col
							: (col - stack.peek() - 1)) * (rowHeight[prevIdx]);
					maxArea = Math.max(maxArea, curArea);
				}
				stack.push(col);
				/**********************************/
			}
		}
		return maxArea;
	}
}
