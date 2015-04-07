package array.medium.TwoDArray;

public class SetMatrixZero {
	public static void setZeroes(int[][] matrix) {

		int m = matrix[0].length;
		int n = matrix.length;
		boolean rowFlag = false;
		boolean colFlag = false;
		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == 0) {
				colFlag = true;
				break;
			}
		}

		for (int i = 0; i < m; i++) {
			if (matrix[0][i] == 0) {
				rowFlag = true;
				break;
			}
		}

		for (int i = 1; i < n; i++)
			for (int j = 1; j < m; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}

		// go through again with just checking the row head or col head status
		for (int i = 1; i < n; i++)
			for (int j = 1; j < m; j++) {
				if(matrix[i][0]==0||matrix[0][j]==0)
					matrix[i][j]=0;
			}

		if (rowFlag)
			for (int i = 0; i < m; i++)
				matrix[0][i] = 0;

		if (colFlag)
			for (int i = 0; i < n; i++)
				matrix[i][0] = 0;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 2, 3 }, { 1, 0, 1 }, { 1, 3, 2 } };
		setZeroes(matrix);
	}
}
