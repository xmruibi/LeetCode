package array.medium.ksumProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < num.length; i++) {
			int l = i + 1;
			int r = num.length - 1;
			while(l<r){
				if(num[l]+num[r]+num[i]==0){
					List<Integer> list = new ArrayList<Integer>();
					list.add(i+1);
					list.add(l+1);
					list.add(r+1);
					res.add(list);
					l++;
					r--;
				}else if(num[l]+num[r]+num[i]>0){
					r--;
				}else{
					l++;
				}			
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] num = {-2,-1,0,1,2};
		System.out.println(threeSum(num));
	}
}
