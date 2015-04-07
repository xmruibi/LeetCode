package string.medium.backTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese {
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		backTrack(n, 0, "", res);
		return res;
	}

	private static void backTrack(int fp, int bp, String cur, List<String> res) {
		if (fp == 0 && bp == 0) {
			res.add(cur);
			return;
		}
		String tmp = ""; // new a string ?!
		if (fp > 0) {
			tmp = cur + "(";
			backTrack(fp - 1, bp + 1, tmp, res);
		}

		if (bp > 0) {
			tmp = cur + ")";
			backTrack(fp, bp - 1, tmp, res);
		}

	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
}
