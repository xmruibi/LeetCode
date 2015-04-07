package array.medium.ksumProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	/**
	 * This problem is simply similar to three sum, just one more loop
	 * but the hard point is to avoid duplicates by three stage!!
	 * @param num
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int m = 0; m < num.length - 3; m++) {
			if(m>0&&num[m]==num[m-1])
		        continue; // this is classical method to avoid dups in start index
			
			for (int i = m + 1; i < num.length - 2; i++) { // this should be taken care of
				
				if(num[i]==num[i-1]&&i>m+1)
			        continue; // this is classical method to avoid dups in start index
				
				int l = i + 1;
				int r = num.length - 1;
				while (l < r) {
					int curSum = num[l] + num[r] + num[i] + num[m];
					if (curSum == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(num[m]);
						list.add(num[i]);
						list.add(num[l]);
						list.add(num[r]);
						res.add(list);
						// to skip the duplicates in binary search stage
						do{l++;}while(num[l]==num[l-1]&&l<r);
						do{r--;}while(num[r]==num[r+1]&&l<r);
					} else if (curSum > target) {
						r--;
					} else {
						l++;
					}
				}
			}
		}
		return res;
	}
}
