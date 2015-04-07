package backtracking.hard;


import java.util.List;
import java.util.ArrayList; 

public class PermutationII {
    static boolean [] isUsed;
	public static List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num==null||num.length==0)
			return res;
		isUsed = new boolean[num.length];
		backtrack(res, new ArrayList<Integer>(), 0, num);
		return res;
	}

	private static void backtrack(List<List<Integer>> res, List<Integer> cur, int idx, int[] num) {
		if(idx == num.length){
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		
		for(int i=0;i<num.length;i++){
    	    if (i>0&&num[i]==num[i-1]&&(!isUsed[i-1]))//Not needed for Permutation I
                continue;
    		if(!isUsed[i]){
    			cur.add(num[i]);
    			isUsed[i] = true;
    			backtrack(res, cur, idx+1, num);;
    			isUsed[i] = false;
    			cur.remove(idx); //??
    		}
    	}
	}
	
	public static void main(String[] args) {
		int[] num = {1,1,2};
		System.out.println(permuteUnique(num));
	}
}
