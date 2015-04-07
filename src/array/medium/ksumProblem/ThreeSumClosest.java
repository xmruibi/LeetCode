package array.medium.ksumProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int res = target;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			int l = i + 1;
			int r = num.length - 1;
			while (l < r) {
				int curSum = num[l] + num[r] + num[i];
				if(Math.abs(target-curSum)<diff){
					res = curSum;
					diff = Math.abs(target-curSum);
				}
				if (curSum >= target) {
					r--;
				} else {
					l++;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,4,5,6,7};
		System.out.println(threeSumClosest(num, 19));
		
	}
}
