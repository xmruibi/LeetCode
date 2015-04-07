package sort.hard;

import java.util.Arrays;

public class MaxmiumGap {
	public int maximumGap(int[] num) {
		if (num == null || num.length < 2)
			return 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i : num) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		int gap = (int) Math.ceil((double) (max - min)
				/ (double) (num.length - 1));
		int[] bucketMin = new int[num.length - 1];
		int[] bucketMax = new int[num.length - 1];
		Arrays.fill(bucketMin, Integer.MIN_VALUE);
		Arrays.fill(bucketMax, Integer.MAX_VALUE);
		
		for(int i=0;i<num.length;i++){
			if(num[i]==min||num[i]==max)
				continue;
			int getIdx = (num[i]-min)/gap;
			bucketMax[getIdx] = Math.max(num[i], bucketMax[getIdx]); 
			bucketMin[getIdx] = Math.min(num[i], bucketMin[getIdx]); 
		}
		int maxGap = Integer.MIN_VALUE;
		int prev = min;
		for(int i=0;i<num.length-1;i++){
			if(bucketMin[i]==Integer.MIN_VALUE||bucketMax[i]==Integer.MAX_VALUE)
				continue;
			maxGap = Math.max(maxGap, bucketMin[i]-prev);
			prev = bucketMax[i];
		}
		maxGap = Math.max(maxGap, max-prev);
		return maxGap;
	}
}
