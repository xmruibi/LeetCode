package array.medium.binarySearch;

public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		int upRow = 0;
		int lowRow = matrix.length - 1;
		int targetRow;
		while (upRow < lowRow) {
			int mRow = upRow + ((lowRow - upRow) >> 1);
			if (matrix[mRow][0] == target)
				return true;
			if (matrix[mRow][0] > target)
				lowRow = mRow - 1;
			else
				upRow = mRow + 1;
		}
		targetRow = lowRow;
		if (targetRow < 0)
			return false;
		int colLeft = 0, colRight = matrix[targetRow].length - 1;
		while (colLeft <= colRight) {
			int mi = colLeft + (colRight - colLeft) / 2;
			if (matrix[targetRow][mi] == target)
				return true;
			if (matrix[targetRow][mi] < target)
				colLeft = mi + 1;
			else
				colRight = mi - 1;
		}
		return false;
	}

}
