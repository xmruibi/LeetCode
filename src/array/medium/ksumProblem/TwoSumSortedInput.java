package array.medium.ksumProblem;

public class TwoSumSortedInput {
    public static int[] twoSum(int[] numbers, int target) {
    	for(int i=0;i<numbers.length;i++){
    		int l = i+1;
    		int r = numbers.length-1;
    		int rest = target - numbers[i];
    		while(l<r){
    			int m = l+((r-l)>>1);
    			if(numbers[m] == rest)
    				return new int[]{i+1,m+1};
    			else if(numbers[m]<rest)
    				r = m-1;
    			else
    				l = m+1;
    		}
    	}
    	return null;
    }
    
    public static void main(String[] args) {
		int[] num = {1,3,4,5,6,7,9};
		System.out.println(twoSum(num, 10)[0]);
	}
}
