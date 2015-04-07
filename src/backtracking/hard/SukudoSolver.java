package backtracking.hard;

public class SukudoSolver {
	public static void solveSudoku(char[][] board) {
		if (board.length == 0 || board == null)
			return;

		backtracking(board, 0, 0);

	}

	private static boolean backtracking(char[][] board, int i, int j) {

		if (j >= board[i].length)
			return backtracking(board, i + 1, 0);

		if (i >= board.length)
			return true;

		if (board[i][j] == '.')
			for (int k = 0; k < 9; k++) {
				if (checkValid(board, i, j, (char) (k + '0'))) {
					board[i][j] = (char) (k + '0');
					if (backtracking(board, i, j + 1))
						return true;
					board[i][j] = '.';
				}
			}
		else
			return backtracking(board, i, j + 1);

		return false;
	}

	public static boolean checkValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < board.length; i++)
			if (board[i][col] == c)
				return false;
		for (int i = 0; i < board[0].length; i++)
			if (board[row][i] == c)
				return false;
		for (int i = row / 3; i < row / 3 + 3; i++)
			for (int j = col / 3; j < col / 3 + 3; j++)
				if (board[i][j] == c)
					return false;

		return true;
	}
	
	public static void main(String[] args) {

	}
}
