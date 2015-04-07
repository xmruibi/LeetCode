package array.medium.combPermutation;

import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backTrack(res, new ArrayList<Integer>(), candidates, target,0);
		return res;
	}

	private static void backTrack(List<List<Integer>> res, List<Integer> cur,
			int[] candidates, int target, int idx) {
		if(target<0)
			return;
		if (target== 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		
		for(int i=idx;i<candidates.length;i++){
			cur.add(candidates[i]);
			backTrack(res, cur, candidates, target-candidates[i], i); // not i+1
			cur.remove(cur.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] num = {2,3,6,7};
		System.out.println(combinationSum(num, 7));
	}
}
