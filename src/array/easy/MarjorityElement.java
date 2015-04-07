package array.easy;

import java.util.Arrays;

public class MarjorityElement {
	public int majorityElement(int[] num) {
		Arrays.sort(num);
		return num[num.length / 2 - 1];
	}

	private static int majorityElement2(int[] num) {
    	int elem = num[0];
    	int count =0;
    	for(int i=0;i<num.length;i++){
    		if(num[i] == elem){
    			count++;
    		}else if(count>0){
    			count--;
    		}else{
    			elem = num[i];
    			count =0;
    		}
    	}
    	return elem;
	}
	public static void main(String[] args) {
		int[] num = {1,2,3,4,4,3,4,2,2,3,1,4,4};
		System.out.println(majorityElement2(num));
	}
}
