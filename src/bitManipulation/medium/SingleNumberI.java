package bitManipulation.medium;

public class SingleNumberI {
	public static int singleNumber(int[] A) {
		int res = A[0];
		for(int i=1;i<A.length;i++){
			res ^=A[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] num = {1,1,2,3,3,2,4,4,5,7,7,6,6};
		System.out.println(singleNumber(num));
	}
}
