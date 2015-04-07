package backtracking.hard;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class NQueen {
	public static List<String[]> solveNQueens(int n) {
		String[] board = new String[n];
		List<String[]> res = new ArrayList<String[]>();
		bakctrack(board, 0, res);
		return res;
	}

	private static void bakctrack(String[] board, int row, List<String[]> res) {
		if (row > board.length - 1) { // using greater than 
			res.add(board.clone());
			return;
		}

		for (int j = 0; j < board.length; j++) {
			if (checkValid(board, row, j)) {
				char[] chars = new char[board.length];
				Arrays.fill(chars, '.');
				chars[j] = 'Q';
				board[row] = new String(chars);
				bakctrack(board, row+1, res);
			}
		}
	}

	private static boolean checkValid(String[] board, int row, int col) {
		for (int i = 0; i < row; i++){
			int qCol = board[i].indexOf("Q");
			if(qCol == col)
				return false;
			else if(Math.abs(row-i)==Math.abs(qCol-col))
				return false;
		}
			return true;
	}

//	private static String[] printer(int[] board) {
//		String[] res = new String[board.length];
//		for (int i = 0; i < board.length; i++) {
//			StringBuilder sb = new StringBuilder();
//			for (int j = 0; j < board.length; j++)
//				// width == height
//				if (j == board[i])
//					sb.append("Q");
//				else
//					sb.append(".");
//			res[i] = sb.toString();
//		}
//		return res;
//	}

	public static void main(String[] args) {
		System.out.println(solveNQueens(4).size());
	}
}
