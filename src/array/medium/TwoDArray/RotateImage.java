package array.medium.TwoDArray;

public class RotateImage {
	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int n = matrix.length-1;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n-i; j++) { // only do half of image!!!
				int tmp = matrix[n - j][i];
				matrix[n - j][i] = matrix[n - i][n - j];
				matrix[n - i][n - j] = matrix[j][n - i];
				matrix[j][n - i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
	}
}
