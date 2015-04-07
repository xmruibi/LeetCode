package array.medium.combPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		List<Integer> cur = new ArrayList<Integer>();  
		backTrack(res, cur, num, target, 0);
		return res;
	}

	private static void backTrack(List<List<Integer>> res, List<Integer> cur,
			int[] candidates, int target, int idx) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = idx; i < candidates.length; i++) {
			if(i>idx&&candidates[i]==candidates[i-1])
				continue;
			cur.add(candidates[i]);
			backTrack(res, cur, candidates, target - candidates[i], i+1); // need i+1
			cur.remove(cur.size() - 1);
		}
	}
}
