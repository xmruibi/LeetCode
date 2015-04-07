package array.medium.combPermutation;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SubsetI {
	public static List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(S==null||S.length==0)
			return res;
		Arrays.sort(S);
		for (int i = 0; i <= S.length; i++)
			backTracking(res, new ArrayList<Integer>(), S, 0, i);

		return res;
	}

	private static void backTracking(List<List<Integer>> res,
			List<Integer> cur, int[] S, int start, int end) {
		if (start == end) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = start; i < end; i++) {
			cur.add(S[i]);
			backTracking(res, cur, S, i + 1, end);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		System.out.println(subsets(num));
	}
}
