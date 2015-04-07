package array.medium.TwoDArray;

import java.util.List;
import java.util.ArrayList;

public class SpiralMatrixI {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return res;
		int rowB = 0;
		int rowE = matrix.length - 1;
		int colB = 0;
		int colE = matrix[0].length - 1;

		while (rowB <= rowE && colB <= colE) {
			for (int i = colB; i <= colE; i++)
				res.add(matrix[rowB][i]);

			rowB++;
			for (int i = rowB; i <= rowE; i++)
				res.add(matrix[i][colE]);

			colE--;
			if (rowB <= rowE) {
				for (int i = colE; i >= colB; i--)
					res.add(matrix[rowE][i]);
				rowE--;
			}
			if (colB <= colE) {
				for (int i = rowE; i >= rowB; i--)
					res.add(matrix[i][colB]);
				colB++;
			}
		}
		return res;
	}
}
